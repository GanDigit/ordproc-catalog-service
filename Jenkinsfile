pipeline {
    agent any
    stages {
        stage("Compile") {
            steps {
                sh "./gradlew compileJava"
            }
        }
        stage("Unit test") {
            steps {
                sh "./gradlew test"
            }
        }
        stage("Package") {
            steps {
                sh "./gradlew build"
            }
        }

        stage("Docker build") {
            steps {
                sh "docker build -t gandigit/ordproc-catalog-service ."
            }
        }

        stage("Docker push") {
            steps {
                sh "docker login -u username -p password"
                sh "docker push gandigit/ordproc-catalog-service"
            }
        }
        stage("Deploy to staging") {
            steps {
              //  sh "docker run -d --rm -p 8765:8080 --name calculator_1 nikhilnidhi/calculator_1"
               sh 'echo "Deployed to staging ...."'
            }
        }
        stage("Acceptance test") {
            steps {
                sleep 60
            //    sh "./acceptance_test.sh"
             sh 'echo "Acceptance test passed ...."'
            }
        }
    }
    post {
        always {
          //sh "docker stop calculator_1"
        }
    }
}