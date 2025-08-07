def gv

pipeline {
    agent any
    stages {
        stage("build jar") {
            steps {
                script {
                    echo "building jar"
                }
            }
        }
        stage("build image") {
            steps {
                script {
                    echo "building image"
                    sh 'docker -v'
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    echo "deploying to ec2 instance"
                }
            }
        }
    }   
}