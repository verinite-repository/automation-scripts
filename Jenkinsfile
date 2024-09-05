import java.nio.file.Files
import java.nio.file.Paths
import java.nio.charset.StandardCharsets
import groovy.io.FileType

pipeline {
    agent any
    
    parameters {
        string(name: 'RUN_PLAN_ID', defaultValue: ' ', description: 'RunPlan Id for which test cases to be run')
        string(name: 'APP_URL', defaultValue: 'http://192.168.3.195:8090', description: 'Application Service URL')
        string(name: 'SCENARIO_TYPE', defaultValue: 'pre', description: 'pre/post run scenarios')
    }
    
    tools {
        maven "M3"
    }

    stages {
        stage('Build') {
            steps {
                script {
                    def runPlanId = params.RUN_PLAN_ID
                    def sType = params.SCENARIO_TYPE
                    if (runPlanId?.trim()) {
                        sh "mvn clean verify -Dcucumber.features=src/test/resources/features/${runPlanId}-${sType}.feature -Dmaven.test.failure.ignore=true"
                    }
                    else {
                        sh "mvn clean verify -Dmaven.test.failure.ignore=true"
                    }
                }
            }
        }
    }
    
    post {
            always {
                script {
                	def baseUrl = params.APP_URL
                    def apiUrl = baseUrl + '/api/v1/cardtest/notify/build'
                    def status = currentBuild.result ?: 'SUCCESS'
                    def sourcePath = 'images/serenity-logo.png'
                    def destinationPath = 'target/site/serenity/images/serenity-logo.png'
                    if (status == 'SUCCESS') {
                    	sh "mv ${sourcePath} ${destinationPath}"
                    	def filePath = '/var/jenkins_home/workspace/CARDTEST.AI/target/site/serenity/index.html'
                        def dirPath = '/var/jenkins_home/workspace/CARDTEST.AI/target/site/serenity'
                        def searchPattern = '"images/serenity-logo.png"'
                        def replacementString = '"images/serenity-logo.png" style="width: 150px;"'

                        def directory = new File(dirPath)
                        if (!directory.exists() || !directory.isDirectory()) {
                            println "Directory does not exist: $dirPath"
                            return
                        }
                        directory.eachFileRecurse(FileType.FILES) { file ->
                            if (file.name.endsWith('.html')) {
                                println "Processing file: ${file.absolutePath}"
                                //def content = file.text
                                //def content = new File(file).text
                                def content = new String(Files.readAllBytes(Paths.get(file.absolutePath)), StandardCharsets.UTF_8)
                                def updatedContent = content.replace(searchPattern, replacementString)
                                //file.text = updatedContent
                                //new File(file).write(updatedContent)
                                Files.write(Paths.get(file.absolutePath), updatedContent.getBytes(StandardCharsets.UTF_8))
                                println "Updated file: ${file.absolutePath}"
                            }
                        }
                        //def fileContent = new File(filePath).text
                        //def updatedContent = fileContent.replaceAll(searchPattern, replacementString)
                        //new File(filePath).write(updatedContent)
                    	archiveArtifacts 'target/site/serenity/**'
                    }
                    sh """
                        curl -X POST ${apiUrl} \
                             -H "Content-Type: application/json" \
                             -d '{"status": "${status}", "buildNumber": "${env.BUILD_NUMBER}", "fileName": "${params.RUN_PLAN_ID}-${params.SCENARIO_TYPE}", "runPlanId":"${params.RUN_PLAN_ID}"}'
                    """
                }
            }
        }
}
