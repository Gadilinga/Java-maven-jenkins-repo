pipeline {
    agent any

    tools {
        maven 'maven 3.9.11' // must match Jenkins global tool config name
    }

    stages {
        stage("Build JAR File") {
            steps {
                echo "Building the JAR artifact using Maven"
                sh 'mvn clean package'
            }
        }

        stage("Build and Push Docker Image") {
            steps {
                echo "Building the Docker image based on the artifact file"

                withCredentials([usernamePassword(credentialsId: 'dockerhubcredentials', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                    sh "docker build -t abdelhamedelbadawy/jenkinsbuiltapplication:javamaven-1.0 ."
                    sh "echo $PASSWORD | docker login -u $USERNAME --password-stdin"

                    sh 'docker push abdelhamedelbadawy/jenkinsbuiltapplication:javamaven-1.0'
                }
            }
        }
    }
}
