pipeline {
    agent any

    environment {
        DOCKER_COMPOSE_VERSION = '2.28.0'
        DOCKER_IMAGE = 'choswan/datefilm_spring'        // Docker Image
        DOCKERHUB_CREDENTIALS = 'docker_hub_choswan'    // Docker Hub ID
        SYS_VERSION = '1.0'
        USE_PROFILE = 'dev'                             // 기본적으로 개발 환경을 사용
    }

    stages {

        // git 소스 받기
        stage('git_checkout') {
            steps {
                git branch: 'develop', credentialsId: 'github_wnad_pull', url: 'https://github.com/wnad/DateFilm.git'
            }
        }


        // application-secret.yml 을 워크스페이스에 복사
        stage('secret.yml download') {
            steps {
                withCredentials([file(credentialsId: 'datefilm_spring_secret', variable: 'dbConfigFile')]) {
                    script {
                        sh "cp ${dbConfigFile} ./DateFilm/src/main/resources/application-secret.yml"
                    }
                }
            }
        }


        // spring 빌드 , 도커 이미지 빌드
        stage('spring build, docker image build') {
            steps {
                sh "chmod +x ./gradlew"
                sh "./gradlew clean build"
                script {
                    docker.build("${env.DOCKER_IMAGE}:${env.BUILD_ID}")
                }
            }
        }


        // 생성한 datefilm img push
        stage('Push Docker Image to Docker Hub') {
            steps {
                script {
                    docker.withRegistry('', "${DOCKERHUB_CREDENTIALS}") {
                        docker.image("${env.DOCKER_IMAGE}:${env.SYS_VERSION}").push()
                    }
                }
            }
        }


        // 원격 서버 접속해서 docker 컨테이너 정리
        stage('Docker Clean Up') {
            steps {
                script {
                    sshPublisher(
                        publishers: [
                            sshPublisherDesc(
                                configName: 's510un',
                                transfers: [
                                    sshTransfer(
                                        execCommand: '''
                                        if test "`docker ps -aq --filter ancestor=datefilm_spring`"; then
                                            # 이전 컨테이너 중지
                                            docker stop $(docker ps -aq --filter ancestor=datefilm_spring)
                                            # 이전 컨테이너 삭제
                                            docker rm -f $(docker ps -aq --filter ancestor=datefilm_spring)
                                            # 이전 이미지 삭제
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


        // 도커 이미지 빌드 및 컨테이너 실행
        stage('Docker run') {
            steps {
                script {
                    sh 'docker-compose -f docker-compose.yml up -d --build'
                }
            }
        }


    }


    // 빌드가 완료된 후 작업
    // Jenkins 워크스페이스 정리, 빌드가 끝난 후 생성된 파일과 디렉토리를 모두 삭제
    post {
        always {
            cleanWs()
        }
    }
}