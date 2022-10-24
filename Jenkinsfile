pipeline {
    agent any 
    
    stages {
        stage ('Git') {
            steps {
                echo 'pulling...';
                git branch :'main' ,
           
                url : 'https://github.com/dbettayeb/Achat.git'
            }
        }
        
         
        
        
        
        
         stage ('Testing Maven') {
            steps {

                sh """mvn -version"""
            }
        }
        
        
        stage ('Maven Clean') {
            steps {
//                sh 'cd achat'
                sh 'mvn clean'
            }
        }
        stage ('Maven Compile') {
            steps {
//                sh "cd achat"
                sh "mvn compile"
            }
        }

        
      stage('Maven SONARQUBE') {
            steps {
               withSonarQubeEnv (installationName: 'sonar') {
   sh "mvn clean package sonar:sonar"
            }
          
        }
      }
        
        
 
        

        stage ('Maven Test JUnit') {
            steps {
                echo 'hello world'
            }
        }
        
    }
}
