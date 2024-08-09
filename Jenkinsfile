pipeline {
    agent any
    
    parameters {
        string(name: 'RUN_PLAN_ID', defaultValue: ' ', description: 'RunPlan Id for which test cases to be run')
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
                        sh "cd automation-scripts && chmod 777 -R . && mvn clean verify -Dcucumber.features=src/test/resources/features/${runPlanId}.feature -Dmaven.test.failure.ignore=true"
                    }
                    else {
                        sh "cd automation-scripts && chmod 777 -R . && mvn clean verify -Dmaven.test.failure.ignore=true"
                    }
                }
            }
        }
    }
    
    post {
            success {
                script {
                    sh 'ls'
                }
                archiveArtifacts 'automation-scripts/target/site/serenity/**'
            }
            always {
                script {
                    def apiUrl = 'http://192.168.3.55:8090/api/v1/cardtest/notify/build'
                    def status = currentBuild.result ?: 'SUCCESS'
                    sh """
                        curl -X POST ${apiUrl} \
                             -H "Content-Type: application/json" \
                             -d '{"status": "${status}", "buildNumber": "${env.BUILD_NUMBER}", "runPlanId": "${params.RUN_PLAN_ID}"}'
                    """
                }
            }
        }
}