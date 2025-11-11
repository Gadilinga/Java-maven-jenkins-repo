// #!/usr/bin/env groovy

// pipeline{
//     agent any
//     tools {
//         maven 'maven-3.9'
//     }
//     stages {
//         stage("build") {
//             steps {
//                 script {
//                     echo "Building the application..."
//                     sh 'mvn package'
//                 }
//             }
//         }
//         stage("build-docker-image") {
//             steps {
//                 script {
//                     echo "Building Docker image..."
//                     withCredentials([usernamePassword(credentialsId: 'docker-hub-login', usernameVariable: 'DOCKERHUB_USERNAME', passwordVariable: 'DOCKERHUB_PASSWORD')]) {
//                     //sh 'docker build -t waseemdevopsdemp/mywp_site .'
//                     sh 'docker build -t nanajanashia/k8s-demo-app .'
//                     sh "echo $PASS | docker login -u $DOCKERHUB_USERNAME  --password-stdin"
//                     sh 'docker push  waseemdevopsdemp/demo-app:jam-2.0 .'
//                 }
//             }
//         }
//     }
//         stage("test") {
//             steps {
//                 script {
//                     echo "Testing the application...."
//                 }
//             }
//         }
//         stage("deploy") {
//             steps {
//                 script {
//                     echo "Deploying the application..."
//                 }
//             }
//         }
//     }
// }

#!/usr/bin/env groovy

pipeline {
    agent any

    tools {
        maven 'maven-3.9'
    }

    stages {
        stage("build") {
            steps {
                script {
                    echo "Building the application..."
                    sh 'mvn package'
                }
            }
        }

        stage("build-docker-image") {
            steps {
                script {
                    echo "Building Docker image..."
                    withCredentials([usernamePassword(
                        credentialsId: 'docker-hub-login',
                        usernameVariable: 'DOCKERHUB_USERNAME',
                        passwordVariable: 'DOCKERHUB_PASSWORD'
                    )]) {
                        sh 'docker build -t nanajanashia/k8s-demo-app .'
                        sh "echo $DOCKERHUB_PASSWORD | docker login -u $DOCKERHUB_USERNAME --password-stdin"
                        sh 'docker push waseemdevopsdemp/k8s-demo-app:latest'
                    }
                }
            }
        }

        stage("test") {
            steps {
                script {
                    echo "Testing the application...."
                }
            }
        }

        stage("deploy") {
            steps {
                script {
                    echo "Deploying the application..."
                }
            }
        }
    }
}
