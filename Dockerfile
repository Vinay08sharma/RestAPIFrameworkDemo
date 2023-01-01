FROM vinay08sharma/java8-3.3-apitest
COPY src home/apiframework/src
COPY pom.xml home/apiframework/pom.xml
COPY index.html home/apiframework/index.html
COPY testng.xml home/apiframework/testng.xml
WORKDIR home/apiframework
ENTRYPOINT mvn clean test