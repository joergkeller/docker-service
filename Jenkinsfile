pipeline {
    agent any

    stages {
        stage('Info') {
            sh ./gradlew --version
        }

        stage('Build / Package') {
            sh ./gradlew --console verbose clean
            sh ./gradlew --console verbose classes testClasses
            sh ./gradlew --console verbose war
        }
        stage('Unit Test') {
            sh ./gradlew --console verbose test
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}