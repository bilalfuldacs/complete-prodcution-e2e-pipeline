pipeline {
    agent any

    tools {
        jdk 'Java17' //these are names in jenkins for jdk and maven
        maven 'Maven3'
    }
     environment {
        APP_NAME = "complete-prodcution-e2e-pipeline"
        RELEASE = "1.0.0"
        DOCKER_USER = "bilal4178"
        DOCKER_PASS = 'dckr_pat_zRNS2NOLKcqKWsV3_dx2I8pYBI4'
        IMAGE_NAME = "${DOCKER_USER}" + "/" + "${APP_NAME}"
        IMAGE_TAG = "${RELEASE}-${BUILD_NUMBER}"
        //JENKINS_API_TOKEN = credentials("JENKINS_API_TOKEN")

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
        // stage('squality gate') {
        //     steps {
        //         script{
        //          waitForQualityGate abortPipeline: false, credentialsId: 'sonar'
        //         }
        
        //     }
        // }
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
        // Add more stages as needed
    }

   }
