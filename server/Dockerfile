FROM eclipse-temurin:17-jdk-jammy
WORKDIR /server
ADD . .
RUN chmod +x ./gradlew
RUN ./gradlew --gradle-user-home .gradle/ bootJar
CMD java -jar build/libs/server-0.0.1-SNAPSHOT.jar
