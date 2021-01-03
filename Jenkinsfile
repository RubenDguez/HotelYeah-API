pipeline {
    agent any

    stages {
        stage('clean') {
            steps {
                sh 'mvn clean'
            }
        }
        stage('package') {
            steps {
                sh 'mvn package'
            }
        }
        stage('deploy (find name)'){
            steps{
                sh 'ls ./target'
            }
        }
    }
}
