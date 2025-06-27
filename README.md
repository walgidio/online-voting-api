# Online Voting API 🗳️

A simple RESTful API built with Spring Boot for creating and managing polls with multiple options and vote counts.

## Features

- Create polls with a question and at least two options
- Vote for a specific option in a poll
- Get all polls or a single poll by ID
- Delete polls

## Technologies

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- MySQL (or compatible relational database)
- Maven

## Getting Started

### Clone the repository

```
git clone https://github.com/walgidio/online-voting-api.git
cd online-voting-api
```

Configure the database
Update src/main/resources/application.properties:
```
spring.datasource.url=jdbc:mysql://localhost:3306/online_voting
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```
Run the application
```
mvn spring-boot:run
```
The API will be available at: http://localhost:8080

Example Endpoints:

GET /api/polls – list all polls

GET /api/polls/{id} – get a poll by ID

POST /api/polls – create a poll
Example payload:

```
{
    "question": "What is your favorite engineering area?",
    "options": [
        {"voteOption": "Backend", "voteCount": 0},
        {"voteOption": "Frontend", "voteCount": 0},
        {"voteOption": "Cloud", "voteCount": 0},
        {"voteOption": "DevOps", "voteCount": 0}
        ]
}
```
POST /polls/{id}/vote – vote for an option
Example payload:
```
{
    "pollId": 1,
    "optionIndex": 0
}
```
