pipeline {
    agent any

    stages{
        stage('Building'){
            steps{
                echo 'Building the application...'
                bat 'mvn clean install'
            }
        }
        stage('Testing'){
            steps{
                echo 'Running tests...'
                bat 'mvn test'
            }
        }
        stage('Deploying'){
            steps{
                echo "Deploy the application..."
                // Add your deployment steps here
            }
        }
    }
}