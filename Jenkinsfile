
pipeline {
    agent any

    triggers {
        pollSCM('H/1 * * * *')
    }

    stages {
        stage('Check Java and Maven') {
            steps {
                bat 'java -version'
                bat 'wsl mvn -version'
            }
        }

        stage('Run Tests') {
            steps {
                bat 'wsl mvn clean test'
            }
        }

        stage('Build Package') {
            steps {
                bat 'wsl mvn clean package -DskipTests'
            }
        }
    }

    post {
        success {
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
        }
    }
}
