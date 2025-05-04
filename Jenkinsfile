pipeline{
    agent any
    stages{
        stage("Code"){
            steps{
                echo "this is cloning the code"
                git url: "https://github.com/Dev-With-Shiv/jenkins-project.git", branch:"master"
                 echo "this is cloning successful"
            }
        }
        stage("Build"){
            steps{
                bat "echo Hello from Jenkins"
                echo "this is building the code"
                bat "whoami"
                bat "mvn clean package"
                bat "dir target"
                echo "stoping the running container"
                bat "docker-compose down"
                sleep time: 5, unit: 'SECONDS'
                bat "docker ps"
                echo "removing the old image"
                bat "docker rmi -f javacicd-app:latest || echo Image not found, skipping..."
            }
        }
        stage("Test"){
            steps{
                echo "this is testing the code"
            }

        }
        stage("Deploy"){
            steps{
                echo "this is deploying the code"
                bat "docker-compose up -d"
                 withCredentials([usernamePassword(credentialsId : "dockerHubCred",
                    passwordVariable: "dockerHubPass",
                    usernameVariable: "dockerHubUser")]) {
                 bat "echo Logging in to DockerHub..."
                 bat "docker login -u %dockerHubUser% -p %dockerHubPass%"
                 bat "docker image tag javacicd-app:latest %dockerHubUser%/javacicd-app:latest"
                 bat "docker push %dockerHubUser%/javacicd-app:latest"
                }
            }
        }
    }
}