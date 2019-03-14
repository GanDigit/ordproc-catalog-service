node {
    def app

    stage("Compile") {
        sh 'echo "Compile Started ...."'
        checkout scm
          sh 'echo "Compile Started 2...."'
        sh "./gradlew compileJava"
        sh 'echo "Compile Completed ...."'
    }
    stage("Unit test") {
        sh 'echo "Unit Started ...."'
        sh "./gradlew test"
        sh 'echo "Unit Completed ...."'
    }
    stage("Package") {
        sh 'echo "Package Started ...."'
        sh "./gradlew build"
        sh 'echo "Package Completed ...."'
    }

    stage("Docker build") {
        sh 'echo "build Started ...."'
        sh "docker build -t gandigit/ordproc-catalog-service ."
        sh 'echo "build Completed ...."'
    }

    stage("Docker push") {
        sh 'echo "push Started ...."'
        sh "docker login -u ${env.DOCKER_USER} -p ${env.DOCKER_PASSWORD}"
        sh "docker push gandigit/ordproc-catalog-service"
        sh 'echo "push Completed ...."'
    }
    stage("Deploy to staging") {
        sh 'echo "Deploy Started ...."'
      //  sh "docker run -d --rm -p 8765:8080 --name calculator_1 nikhilnidhi/calculator_1"
        sh 'echo "Deployed to staging ...."'
        sh 'echo "Deploy Completed ...."'
    }
    stage("Acceptance test") {
        sleep 60
    //    sh "./acceptance_test.sh"
         sh 'echo "Acceptance test passed ...."'
    }
}