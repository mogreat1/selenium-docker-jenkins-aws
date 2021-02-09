pipeline {
    agent any
    stages {
        stage('Build Jar') {
            steps {
                bat "mvn clean package -DskipTests"
            }
        }
        stage('Build Image') {
            steps {
                bat "docker build -t max/selenium-docker ."
            }
        }
        stage('Push Image') {
            steps {
		        bat "docker login --username=mogreat1 --password=MaxDocker1"
		        bat "docker push max/selenium-docker:latest"
            }
        }
    }
}