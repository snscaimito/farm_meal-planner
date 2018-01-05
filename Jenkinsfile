pipeline {
    agent any
    
    tools {
        maven 'mvn-3.5.2'
    }
    
    environment {
        VERSION=readMavenPom().getVersion()
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn package'
            }
        }
        
        stage('Make Container') {
            steps {
		    		sh "docker build -t snscaimito/meal-planner-app:${env.BUILD_ID} --build-arg JAR_VERSION=${VERSION} ."
		    		sh "docker tag snscaimito/meal-planner-app:${env.BUILD_ID} snscaimito/meal-planner-app:latest"
            }
        }
        
        stage('Check Specification') {
        		steps {
        			sh "chmod o+w *"
	        		sh "docker-compose up --exit-code-from cucumber --build"
        		}
        }
        
        stage('Store to Repository') {
	        	steps {
	        		withCredentials([usernamePassword(credentialsId: 'docker-credentials', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
					sh "docker login -u ${USERNAME} -p ${PASSWORD}"
	        			sh "docker push snscaimito/meal-planner-app:${env.BUILD_ID}"
	        		}
	        	}
        }
        
    }
    
    post {
        always {
            archive 'target/**/*.jar'
            junit 'target/**/*.xml'
            cucumber '**/*.json'
        }
    }
}

