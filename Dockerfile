FROM alpine
RUN apk add openjdk11 curl jq
ENV PATH $PATH:/usr/lib/jvm/jdk-11.0.3/bin

#Workspace
WORKDIR /user/share/test

#Add .jar under target from host into this image
ADD target/selenium-docker.jar selenium-docker.jar
ADD target/selenium-docker-tests.jar selenium-docker-tests.jar
ADD target/libs libs

#Add suite files
ADD book-flight-module.xml book-flight-module.xml
ADD search-module.xml search-module.xml

#ADD health check script
ADD healthcheck.sh healthcheck.sh
RUN dos2unix healthcheck.sh

#Browser
#HUB_HOST
#Module
ENTRYPOINT sh healthcheck.sh
