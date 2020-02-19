// Initialize a LinkedHashMap / object to share between stages
def pipelineContext = [:]
pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2'
        }
    }
    environment {
        DOCKER_IMAGE_TAG = "my-app:build-${env.BUILD_ID}"
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean install'
                 script {
                              dockerImage = docker.build("${env.DOCKER_IMAGE_TAG}",  '-f ./Dockerfile .')
                              pipelineContext.dockerImage = dockerImage
                        }
            }


        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
    }
}
