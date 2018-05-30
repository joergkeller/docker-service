#
# Create Jenkins project 'Pipeline' or 'Multibranch Pipeline' and reference this SCM repository (e.g. Github).
# In Github, create personal access token (developer settings) and register it in the Jenkins configuration, Github tab.
#
pipeline {
    agent any

    stages {
        stage('Info') {
            steps {
                 sh './gradlew --version'
            }
        }
        stage('Build') {
            steps {
                sh './gradlew --console verbose clean'
                sh './gradlew --console verbose classes testClasses'
                sh './gradlew --console verbose war'
            }
        }
        stage('Unit Test') {
            steps {
                sh './gradlew --console verbose test'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}