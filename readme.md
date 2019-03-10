## Needed stacks
    + maven 3
    + java8
    
## Technologi stacks
    + maven 3
    + java8
    + springboot
    + jwt
    
## To get started follow this checklist:
    + build project : mvn clean install
    + run project in target: java -jar java-springboot-jwt-0.0.1-SNAPSHOT.jar
    + curl -X POST \
        http://localhost:5001/auth \
        -H 'Content-Type: application/x-www-form-urlencoded' \
        -H 'Postman-Token: 992cfa2e-5dd6-4617-9c27-513c69ee3057' \
        -H 'cache-control: no-cache' \
        -d 'username=israjhaliri&password=12345678&undefined='
    + curl -X GET \
       http://localhost:5001/adm/example \
       -H 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJpc3JhamhhbGlyaSIsImF1ZGllbmNlIjoid2ViIiwiY3JlYXRlZCI6MTU1MjIxOTE3NzM1MCwiZXhwIjoxNTUyODIzOTc3fQ.tIJDhOjJm5f77mkUTLkqOStSag0l0Ln22dh9uEP0BKcSFb3vFZdHAIqV9cOUiZsaVR5EGwitZ07Ry_0pkkUT5w' \
       -H 'Content-Type: application/x-www-form-urlencoded' \
       -H 'Postman-Token: df7703bb-8467-4cf0-9c1a-29677e396fa7' \
       -H 'cache-control: no-cache'