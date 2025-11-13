def buildApp () {
     echo "Building the application..."
     sh 'mvn package'    
}

def buildImage () {
    echo "Building the Docker image ..."
        withCredentials([usernamePassword(
            credentialsId: 'docker-hub-login',
            usernameVariable: 'DOCKERHUB_USERNAME',
            passwordVariable: 'DOCKERHUB_PASSWORD'
        )]) {
        sh 'docker build -t waseemdevopsdemp/k8s-demo-app:v0.2 .'
        sh "echo $DOCKERHUB_PASSWORD | docker login -u $DOCKERHUB_USERNAME --password-stdin"
        sh "docker push waseemdevopsdemp/k8s-demo-app:v0.2"
    }

}

def deplyApp () {
    echo "Depploying the docker application...."
} 
   
return this
