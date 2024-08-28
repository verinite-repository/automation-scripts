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
                        def searchPattern = '"images/serenity-logo.png"'
                        def replacementString = '"images/serenity-logo.png" style="width: 150px;"'
                        def fileContent = new File(filePath).text
                        def updatedContent = fileContent.replaceAll(searchPattern, replacementString)
                        new File(filePath).write(updatedContent)
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
