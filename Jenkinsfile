pipeline {
    agent any

    stages {
        stage('Info') {
            steps {
                sh ./gradlew --version
            }
        }

        stage('Build / Package') {
            steps {
                sh ./gradlew --console verbose clean
                sh ./gradlew --console verbose classes testClasses
                sh ./gradlew --console verbose war
            }
        }
        stage('Unit Test') {
            steps {
                sh ./gradlew --console verbose test
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}