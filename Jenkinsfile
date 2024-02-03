pipeline {
    environment {
        // Define environment variables if needed
    }
    
    tools {
        jdk 'Java17'
        maven 'Maven3'
    }

    stages {
        stage('Cleanup Workspace') {
            steps {
                cleanWs()
            }
        }

        stage('Git') {
            steps {
                git branch: 'main',
                    credentialsId: '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',
                    url: 'https://github.com/bilalfuldacs/complete-prodcution-e2e-pipeline'
            }
        }

        // Add more stages as needed
    }

    post {
        // Define post-build actions if needed
    }
}
