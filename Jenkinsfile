/*
 * Create Jenkins project 'Pipeline' or 'Multibranch Pipeline' and reference this SCM repository (e.g. Github).
 * In Github, create personal access token (developer settings) and register it in the Jenkins configuration, Github tab.
 */
pipeline {
    agent any

    stages {
        stage('Info') {
            steps {
                sh 'chmod +x gradlew'
                sh './gradlew --version'
            }
        }
        stage('Build') {
            steps {
                sh './gradlew --info clean'
                sh './gradlew --info classes testClasses'
                sh './gradlew --info war'
            }
        }
        stage('Unit Test') {
            steps {
                sh './gradlew --info test'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}