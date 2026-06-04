pipeline {
    agent any

    tools {
        maven 'Maven3'
    }

    environment {
        SONAR_SERVER = 'sonar'
    }

    stages {

        stage('Checkout Code') {
            steps {
                git 'https://github.com/Samhitha1705/devsecops-project.git'
            }
        }

        stage('Build + Test') {
            steps {
                sh 'mvn clean verify'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv("${SONAR_SERVER}") {
                    sh 'mvn sonar:sonar'
                }
            }
        }

        stage('Quality Gate Check') {
            steps {
                script {
                    timeout(time: 15, unit: 'MINUTES') {

                        def qg = waitForQualityGate()

                        echo "SonarQube Quality Gate status: ${qg.status}"

                        if (qg.status != 'OK') {
                            error "Pipeline failed due to Quality Gate: ${qg.status}"
                        }
                    }
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

        aborted {
            echo "Pipeline ABORTED ⚠"
        }

        always {
            echo "Pipeline finished."
        }
    }
}
