pipeline {
    agent any

    tools {
        jdk 'Java17' //these are names in jenkins for jdk and maven
        maven 'Maven3'
    }

    stages {
        stage('Cleanup Workspace') {
            steps {
                cleanWs()//this is used to clean up our workspace
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

   }
