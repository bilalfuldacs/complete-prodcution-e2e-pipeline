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
        stage('build') {
            steps {
                sh 'mvn clean package'//this is used to clean up our workspace
            }
        }
        stage('test') {
            steps {
                sh 'mvn test'//this is used to clean up our workspace
            }
        }
        
         stage('sonarqube analysis') {
            steps {
                script{
                withSonarQubeEnv(credentialsId: 'sonar' ) {
                    sh 'mvn sonar:sonar'//this is used to clean up our workspace
                }
                }
        
            }
        }
        stage('squality gate') {
            steps {
                script{
                 waitforQualityGate abortPipeline: true, credentialsId: 'sonar'
                }
        
            }
        }

        // Add more stages as needed
    }

   }
