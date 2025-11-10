def buildApp () {
    echo "building the application..."
}

def testApp () {
    echo "testing the application..."
}

def deplyApp () {
    
    echo "Deploying the application..."
    echo "deploying version ${params.VERSION} to selected environment"
}

return this
