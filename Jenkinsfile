pipeline {
    agent any

    
    tools {
        jdk 'Java17' // These are the names in Jenkins for JDK and Maven
        maven 'Maven3'
        docker 'Docker'
    }
    
    environment {
        APP_NAME = "complete-prodcution-e2e-pipeline"
        RELEASE = "1.0.0"
        DOCKER_USER = 'bilal4178'
        DOCKER_PASS = 'dckr_pat_djv8yCJjHep88dwdJHuNJL25yiU' 
        IMAGE_NAME = "${DOCKER_USER}/${APP_NAME}"
        IMAGE_TAG = "${RELEASE}-${BUILD_NUMBER}"
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

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        
        stage('SonarQube Analysis') {
            steps {
                script {
                    withSonarQubeEnv(credentialsId: 'sonar') {
                        sh 'mvn sonar:sonar'
                    }
                }
            }
        }
        
        stage("Build & Push Docker Image") {
            steps {
                script {
                    docker.withRegistry('',DOCKER_PASS) {
                        docker_image = docker.build "${IMAGE_NAME}"
                    }

                    docker.withRegistry('',DOCKER_PASS) {
                        docker_image.push("${IMAGE_TAG}")
                        docker_image.push('latest')
                    }
                }
            }

        }
    
    }
}
