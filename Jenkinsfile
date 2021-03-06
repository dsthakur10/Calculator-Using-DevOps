pipeline {
    // Declare environment variables that will be used by multiple stages to avoid redundancy
    environment {
        DOCKERHUB_REGISTRY = "dsthakur10/calculator-using-devops"
        DOCKERHUB_CREDENTIALS = credentials('dockerHub-devendra')
    }
    
    // The "agent" section configures on which nodes the pipeline can be
    // run. Specifying "agent any" means that Jenkins will run the job on
    // any of the available nodes.

    agent any 
    
    stages {
        
        stage('Git Pull') {
            steps {
                // To git pull from a private repository, credentials are required
                git url: 'https://github.com/dsthakur10/Calculator-Using-DevOps.git',
                branch: 'master',
                credentialsId: 'github-devendra'
            }
        }
        
        stage('Maven Build + JUnit Tests') {
            steps {
                sh 'mvn clean install'
            }
        }
        
        stage('Build Docker Image') {
			steps {
				sh "docker build -t $DOCKERHUB_REGISTRY:latest ."
			}
		}

		stage('Login to Docker Hub') {
			steps {
				sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
			}
		}

		stage('Push Docker Image to Docker Hub') {
			steps {
				sh 'docker push $DOCKERHUB_REGISTRY:latest'
			}
		}

        // Ansible Deploy to remote server (managed host)
        stage('Ansible Deploy') {
            steps {
                ansiblePlaybook becomeUser: 'null',
                colorized: true,
                credentialsId: 'dockerHub-devendra',
                installation: 'Ansible',
                inventory: 'inventory',
                playbook: 'ansible-playbook.yml',
                sudoUser: 'null'
            }
        }
    }
}
