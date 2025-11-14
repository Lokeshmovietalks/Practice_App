# k8s-practice-app

Simple Spring Boot (Thymeleaf) app for Kubernetes practice.

## What it contains
- A web page that displays: "Hi Lokesh Welcome to Kubernetes"
- Colors are controlled via CSS variables in `src/main/resources/static/css/style.css`
- A Thymeleaf template is used (`src/main/resources/templates/index.html`)

## Build & Run locally
1. Build with Maven:
```
mvn clean package
```
2. Run:
```
java -jar target/k8s-practice-app-0.0.1-SNAPSHOT.jar
```
3. Visit: `http://localhost:8080`

## Docker
Build and run the Docker image:
```
docker build -t k8s-practice-app:latest .
docker run -p 8080:8080 k8s-practice-app:latest
```

## Jenkins pipeline (simple)
You can add a stage to build the jar and docker image, then push to registry. Example stages:
- `mvn package`
- `docker build`
- `docker push`
- Apply k8s manifests

## Notes
- Edit `src/main/resources/static/css/style.css` to change colors quickly (variables at the top).
- The project uses Java 17 and Spring Boot 3.x.
