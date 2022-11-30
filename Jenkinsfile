pipeline{
    agent any
    stages{
        stage("checkout-spring-app"){
            steps{
                 bat "git clone https://github.com/ashu847/employee-management.git"
            }
		}
			stage("checkout-react-app"){
			steps{
                 bat "git clone https://github.com/ashu847/employee-management-reactApp.git"
            }
        }
        
         stage("package-spring"){
            steps{
            bat "mvn clean package"
            }
		}
		stage("Enter-react-folder"){
			
			steps{
					    dir('employee-management-reactApp') {
							bat "cd"
							bat "docker build -t ashu847/employee-management-react:1.0 ."
					}
            }
		}
		stage("return-home"){
			steps{
					bat "cd"
					    dir('employee-management') {
							bat "cd"
					}
					
            }
		}
        
        stage("docke-tag-admin"){
            steps{
				bat "docker tag app-admin-microservice:1.0 ashu847/app-admin-microservice:1.0"
            }
			}
		stage("docke-tag-eureka"){
            steps{
				bat "docker tag eureak-server:1.0 ashu847/eureak-server:1.0"
            }
			}
		stage("docke-tag-employee"){
            steps{
				bat "docker tag app-employee-microservice:1.0 ashu847/app-employee-microservice:1.0"
            }
			}
		stage("docke-tag-management"){
            steps{
				bat "docker tag app-management-service:1.0 ashu847/app-management-service:1.0"
            }
        }
		
        
        stage("deploy"){
            steps{
				bat "docker-compose up"
				sleep(360)
				bat "docker-compose down"
            }
        }
    }
 }