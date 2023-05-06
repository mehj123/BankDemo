FROM openjdk:17
LABEL maintainer ="bankdemo"
ADD target/BankDemo-0.0.1-SNAPSHOT.jar BankDemo-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","BankDemo-0.0.1-SNAPSHOT.jar"]