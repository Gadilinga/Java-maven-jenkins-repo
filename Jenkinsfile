pipeline {
    agent none

    stages {
        stage("Test the Java Software") {
            steps {
                script {
                    echo "Testing the application... executing the pipeline of branch ${env.BRANCH_NAME}"
                }
            }
        }

        stage("Build") {
            when {
                expression { env.BRANCH_NAME == 'master' }
            }
            steps {
                script {
                    echo "Building the application..."
                }
            }
        }

        stage("Deploy") {
            when {
                expression { env.BRANCH_NAME == 'master' }
            }
            steps {
                script {
                    echo "Deploying the application..."
                }
            }
        }
    }
}
