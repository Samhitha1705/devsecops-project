pipeline {
    agent any

    tools {
        maven 'Maven3'
    }

    stages {

        stage('Checkout Code') {
            steps {
                git 'https://github.com/Samhitha1705/devsecops-project.git'
            }
        }

        stage('Build, Test & Sonar Analysis') {
            steps {
                withSonarQubeEnv('sonar') {
                    sh """
                    mvn clean verify sonar:sonar
                    """
                }
            }
        }

        stage('Quality Gate') {
            steps {
                timeout(time: 2, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }
    }

    post {
        success {
            echo "Pipeline SUCCESS ✔"
        }

        failure {
            echo "Pipeline FAILED ❌"
        }
    }
}

