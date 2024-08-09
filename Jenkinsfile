pipeline {
    agent any
    
    parameters {
        string(name: 'RUN_PLAN_ID', defaultValue: ' ', description: 'RunPlan Id for which test cases to be run')
        string(name: 'APP_URL', defaultValue: 'http://192.168.3.55:8090', description: 'Application Service URL')
    }
    
    tools {
        maven "M3"
    }

    stages {
        stage('Build') {
            steps {
                script {
                    def runPlanId = params.RUN_PLAN_ID
                    if (runPlanId?.trim()) {
                        sh "mvn clean verify -Dcucumber.features=src/test/resources/features/${runPlanId}.feature -Dmaven.test.failure.ignore=true"
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
                    if (status == 'SUCCESS') {
                    	archiveArtifacts 'target/site/serenity/**'
                    }
                    sh """
                        curl -X POST ${apiUrl} \
                             -H "Content-Type: application/json" \
                             -d '{"status": "${status}", "buildNumber": "${env.BUILD_NUMBER}", "runPlanId": "${params.RUN_PLAN_ID}"}'
                    """
                }
            }
        }
}