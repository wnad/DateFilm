pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'choswan/datefilm_spring'
        DOCKERHUB_CREDENTIALS = 'docker_hub_choswan'
        SYS_VERSION = '1.0'
        S510UN_SERVER = 's510un'
    }

    stages {
        stage('git_checkout') {
            steps {
                git branch: 'infra/2-jenkins-docker', credentialsId: 'github_wnad_pull', url: 'https://github.com/wnad/DateFilm.git'
            }
        }

        stage('secret.yml download') {
            steps {
                withCredentials([file(credentialsId: 'datefilm_spring_secret', variable: 'dbConfigFile')]) {
                    script {
                        def targetDir = "$WORKSPACE/DateFilm/src/main/resources/"
                        sh "mkdir -p ${targetDir}"
                        sh "cp ${dbConfigFile} ${targetDir}application-secret.yaml"
                    }
                }
            }
        }

        stage('spring build, docker image build') {
            steps {
                sh "chmod +x ./gradlew"
                sh "./gradlew clean build"
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("${env.DOCKER_IMAGE}:${env.SYS_VERSION}")
                }
            }
        }


        stage('Push Docker Image to Docker Hub') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: env.DOCKERHUB_CREDENTIALS, passwordVariable: 'DOCKERHUB_PASSWORD', usernameVariable: 'DOCKERHUB_USERNAME')]) {
                        sh "echo \${DOCKERHUB_PASSWORD} | docker login -u \${DOCKERHUB_USERNAME} --password-stdin"
                    }

                    docker.withRegistry('', env.DOCKERHUB_CREDENTIALS) {
                        docker.image("${env.DOCKER_IMAGE}:${env.SYS_VERSION}").push()
                    }
                }
            }
        }

        stage('Remove Docker Image') {
            steps {
                script {
                    sh "docker rmi ${env.DOCKER_IMAGE}:${env.SYS_VERSION}"
                }
            }
        }

        stage('Docker Clean Up') {
            steps {
                script {
                    sshPublisher(
                        publishers: [
                            sshPublisherDesc(
                                configName: env.S510UN_SERVER,
                                transfers: [
                                    sshTransfer(
                                        execCommand: '''
                                        if docker ps -a | grep "datefilm_spring"; then
                                            docker stop $(docker ps -aq --filter ancestor=datefilm_spring)
                                            docker rm $(docker ps -aq --filter ancestor=datefilm_spring)
                                            docker rmi datefilm_spring
                                        fi
                                        '''
                                    )
                                ],
                                usePromotionTimestamp: false,
                                verbose: true
                            )
                        ]
                    )
                }
            }
        }


        stage('git pull & docker run') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: env.DOCKERHUB_CREDENTIALS, passwordVariable: 'DOCKERHUB_PASSWORD', usernameVariable: 'DOCKERHUB_USERNAME')]) {
                        sshPublisher(
                            publishers: [
                                sshPublisherDesc(
                                    configName: env.S510UN_SERVER,
                                    transfers: [
                                        sshTransfer(
                                            execCommand: """
                                            cd /home/dundun/project/datefilm/datefilm_git/ &&
                                            git checkout infra/2-jenkins-docker &&
                                            git pull origin infra/2-jenkins-docker &&
                                            echo \${DOCKERHUB_PASSWORD} | docker login -u \${DOCKERHUB_USERNAME} --password-stdin &&
                                            docker-compose -f docker-compose.yml up -d --build
                                            """
                                        )
                                    ],
                                    usePromotionTimestamp: false,
                                    verbose: true
                                )
                            ]
                        )
                    }
                }
            }
        }

    }

    post {
        always {
            cleanWs()
        }
    }
}
