pipeline {
    agent any

    stages{
        stage('Building'){
            steps{
                echo 'Building the application...'

            }
        }
        stage('Testing'){
            steps{
                echo 'Running tests...'
                bat 'mvn clean install'
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