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
        stage('deploy'){
            steps{
                sh 'cp ./target/hotelbooking-1.0.0.war ~/apache-tomcat-8.5.60/webapps'
            }
        }
    }
}
