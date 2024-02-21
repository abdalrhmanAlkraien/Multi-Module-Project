### Use a JDK image as a base
FROM openjdk:17-oracle
MAINTAINER marinabit.com
LABEL version="1.0.0"
LABEL description="This text multi module project"
LABEL author="Abdalrhman ALkraien"

#ARG JAR_FILE=./app-module/target/app-module-0.0.1-SNAPSHOT.jar
COPY app-module/target/app-module-0.0.1-SNAPSHOT.jar app.jar

RUN sh -c 'touch /app.jar'

ENTRYPOINT ["java","-XX:+UnlockExperimentalVMOptions","-XX:+UseContainerSupport","-XX:MaxRAMFraction=1","-XX:+UseG1GC","-jar", "/app.jar"]
#ENTRYPOINT ["java", "-cp","/app.jar", "com.project.multimodule.MultiModuleApplication"]