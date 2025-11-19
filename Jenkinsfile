pipeline{
    agent{
        label 'Node_1'
    }
    stages{
        stage('SCM checkout'){
            steps{
                git url: 'https://github.com/Lokeshmovietalks/Practice_App.git', branch: 'master'
            }
        }
        stage('maven build'){
            steps{
                sh 'mvn -v'
                sh 'mvn clean package'
            }
        }
        stage('Nexus Deploy'){
            steps{
                sh 'mvn deploy'
            }
        }
        stage('Nexus Download'){
            steps{
                withCredentials([usernamePassword(credentialsId: 'nexus-creds', usernameVariable: 'USER', passwordVariable: 'PASS')]){
                    sh '''
                    echo "Downloading from Nexus"
                    curl -u "$USER:$PASS" -O http://13.211.53.180:8081/repository/Practice_App_Snapshot/com/example/Practice-app/0.0.1-SNAPSHOT/Practice-app-0.0.1-20251115.035728-1.jar
                    '''
                }
            }
        }
        stage('Docker Build & Push'){
            steps{
                withCredentials([usernamePassword(credentialsId: 'docker-creds', usernameVariable: 'USER', passwordVariable: 'PASS')]){
                    sh '''
                    echo "Building Docker Image"
                    docker build -t $USER/practiceapp:nov19v2 .
                    echo "Pushing Image"
                    echo "$PASS" | docker login -u "$USER" --password-stdin
                    docker push $USER/practiceapp:nov19v2
                    '''
                }
            }
        }
    }
}
