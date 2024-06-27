# 프로젝트 Java 버전에 맞는 openjdk 이미지 설정
# 베이스 이미지로 Java 17버전이 포함된 Docker 이미지를 사용
FROM openjdk:17-jdk

# Gradle로 빌드한 jar 파일의 위치를 변수로 설정
# gradle 빌드를 하면 build/libs 하위에 *.jar 생성됨. 해당 '*.jar'를 'app.jar'로 cpoy
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar

# .yaml local/prod 프로필 분리 구조일때 실행할 프로필 지정 dev(=개발)
# ENV USE_PROFILE dev

# 이미지 빌드 명령
# "-Dspring.profiles.active=${USE_PROFILE}"
ENTRYPOINT ["java", "-jar", "app.jar"]