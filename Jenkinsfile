pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'choswan/datefilm_spring'
        DOCKERHUB_CREDENTIALS = 'docker_hub_choswan'
        SYS_VERSION = '1.1.5'
        S510UN_SERVER = 's510un'
    }

    stages {
        // git pull
        stage('git_checkout') {
            steps {
                git branch: 'infra/2-jenkins-docker', credentialsId: 'github_wnad_pull', url: 'https://github.com/wnad/DateFilm.git'
            }
        }


        // datefilm_spring_secret 복사
        stage('copy secret-yaml') {
            steps {
                withCredentials([file(credentialsId: 'datefilm_spring_secret', variable: 'secretFile')]) {
                    script {
                        sh "cp $secretFile ./src/main/resources/application-secret.yaml"
                    }
                }
            }
        }


        // jar build
        stage('spring build') {
            steps {
                sh "chmod +x ./gradlew"
                sh "./gradlew clean build"
            }
        }


        // 도커 이미지 빌드
        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("${env.DOCKER_IMAGE}:${env.SYS_VERSION}")
                }
            }
        }


        // 새 이미지 도커 허브에 push
        stage('Push Docker Image to Docker Hub') {
            steps {
                script {
                    // 도커 로그인
                    withCredentials([usernamePassword(credentialsId: env.DOCKERHUB_CREDENTIALS, passwordVariable: 'DOCKERHUB_PASSWORD', usernameVariable: 'DOCKERHUB_USERNAME')]) {
                        sh "echo \${DOCKERHUB_PASSWORD} | docker login -u \${DOCKERHUB_USERNAME} --password-stdin"
                    }

                    // 도커 레포지토리에 이미지 push
                    docker.withRegistry('', env.DOCKERHUB_CREDENTIALS) {
                        docker.image("${env.DOCKER_IMAGE}:${env.SYS_VERSION}").push()
                    }
                }
            }
        }


        // 생성한 이미지 삭제
        stage('Remove Docker Image') {
            steps {
                script {
                    sh "docker rmi ${env.DOCKER_IMAGE}:${env.SYS_VERSION}"
                }
            }
        }


        // 원격 서버에 올라가있는 컨테이너 중지, 삭제
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
                                        if docker ps -a | grep "datefilm"; then
                                            docker stop datefilm
                                            docker rm datefilm
                                            docker rmi datefilm
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
                                            git pull origin infra/2-jenkins-docker && clear &&
                                            echo \${DOCKERHUB_PASSWORD} | docker login -u \${DOCKERHUB_USERNAME} --password-stdin
                                            docker-compose -f docker-compose.yml up -d
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
