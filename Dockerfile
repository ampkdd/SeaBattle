FROM openjdk:8-jdk-alpine
FROM ubuntu

# указываем точку монтирования для внешних данных внутри контейнера (как мы помним, это Линукс)
VOLUME /tmp

# внешний порт, по которому наше приложение будет доступно извне
EXPOSE 8080

#Install git
RUN apt-get update        
RUN apt-get install -y git

RUN cd /tmp/

#Clone
RUN git clone https://github.com/XXXXXXXXXXX/DockerConvertator.git

RUN find /DockerConvertator/ -type d -exec chmod 777 {} \;

RUN cd DockerConvertator

#Install Maven
RUN apt-get install -y maven

#Set working directory
WORKDIR /DockerConvertator/

#Собираем билд через Maven
RUN mvn clean
RUN mvn install

# указываем, где в нашем приложении лежит джарник
ARG JAR_FILE=DockerConvertator/target/convertator-0.0.1-SNAPSHOT.jar

# добавляем джарник в образ под именем rebounder-chain-backend.jar
ADD ${JAR_FILE} convertator-0.0.1.jar

# команда запуска джарника
ENTRYPOINT ["java","-jar","/convertator-0.0.1-SNAPSHOT.jar"]