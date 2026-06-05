DevSecOps Project Notes (Spring Boot + Maven +
SonarQube + Jenkins)


Project Overview

Simple Spring Boot app with CI/CD pipeline using Maven, JUnit, JaCoCo, SonarQube, Jenkins.


API Endpoints
/add?a=2&b;=3 -> returns sum
/multiply?a=2&b;=3 -> returns product

Important Maven Commands

mvn clean -> clean build
mvn test -> run tests
mvn clean verify -> build + test + coverage
mvn spring-boot:run -> run application

Running Application

After running mvn spring-boot:run, open browser:

http://localhost:8080/add?a=2&b;=3

Code Coverage (JaCoCo)

Minimum coverage set to 70%

Report generated at target/site/jacoco/index.html

SonarQube

mvn sonar:sonar used for static analysis

Quality Gate fails if issues or low coverage

Jenkins Pipeline Flow

Checkout -> Build -> Test -> Sonar Scan -> Quality Gate Check -> Deploy decision



----------------------sonarcube setup-----------------------------


->   checked the located file

->    cd ~/sonarqube-26.5.0.122743/bin/linux-x86-64

->     started the application

->     ./sonar.sh start

->     made sure sonarcube to run the application instead of local host used  Internal network IP address

->     hostname -I

->     THEN it came like 172.21.7.189

->    Opened sonarcuvbe like http://172.21.7.189:9000/

->    and in sonarQube administration we set webhook configuration for jenkins setup in sonarqube by 

->    IN Administration -Configuration-webhooks


->  Name : jenkins
->  URL :https://ce3d-136-232-205-158.ngrok-free.app/sonarqube-webhook/

-> Then jenkins and sonarqube will coomunicate easily for quality check other wise sonar cant do localhost jenkins build


-------------------Jenkins setup-----------

-> Installed sonar required plugins

->and also made sure installed ngrok and exposed through ngrok http 8080 

-> for running builds through by sonaranalysis

-> And also set the creds in manage jenkins-> credentials ->add creds -> secret text ->scope(global) -> secret need to take from sonar token through by sonar account security by genearting token in sonar and in jenkins by typing this token in secret text we can create.

-> nd also manage jenkins -> system -> soanrqube servers  by checking environment variables by clicking server url http://172.21.7.189:9000 and by typing name as sonar and server authentication token will come as by t6aking from creds id  and then save 


