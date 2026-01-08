# Content Calendar API 📅

> A RESTful API aimed at helping content creators manage their creative workflow.

This application allows users to **create, update, and track content ideas** for social media. It serves as a central hub for managing the lifecycle of digital content, from the initial "Idea" phase to "Published" status.

## Tech Stack 🛠️

* **Java:** Core programming language.
* **Spring Boot:** Framework for building the REST API.
* **Spring Data JDBC:** For simplified database interaction.
* **PostgreSQL:** Relational database for persistent storage.
* **Docker:** For containerizing the database and application.
* **Spring Validation:** To ensure data integrity.

## Key Features ✨

* **CRUD Operations:** Create, Read, Update, and Delete content posts.
* **Robust Validation:** Prevents invalid data (e.g., blank titles, future dates) from entering the system.
* **Automated Persistence:** seamless data storage using Spring Data JDBC.
* **Containerized Environment:** Easy setup and teardown using Docker Compose.

* ## Getting Started 🚀

### Prerequisites
* Java 21
* Docker Desktop (or Docker Engine)

### Installation & Run
1. **Clone the repository:**
   ```bash
   git clone [https://github.com/crawfordclarke/content-calendar.git](https://github.com/crawfordclarke/content-calendar.git)

*   Once the system is up, the API will be available at: http://localhost:8080/api/content

## API Reference 📡

Here are examples of how to interact with the API using tools like IntelliJ HTTP Client, Postman, or cURL.

1. List All Content

Retrieves a list of all content items in the system.

Request: GET /api/content

Example Response:
  {
    "id": 1,
    "title": "My First Blog Post",
    "description": "A post about Spring Boot",
    "status": "IDEA",
    "contentType": "ARTICLE",
    "dateCreated": "2026-01-08T10:00:00",
    "dateUpdated": null,
    "url": ""
  }



2. Create New Content

Adds a new content item to the database.

Request: POST /api/content

Body:

{
  "title": "Dockerizing Java Apps",
  "description": "A guide to using Docker with Spring Boot",
  "status": "IDEA",
  "contentType": "ARTICLE",
  "dateCreated": "2026-01-09T12:00:00",
  "url": ""
}


3. Update Existing Content

Updates the details of a specific post by ID.

Request: PUT /api/content/{id}

Body:

{
  "id": 1,
  "title": "Dockerizing Java Apps (Updated)",
  "description": "Updated guide with Docker Compose",
  "status": "PUBLISHED",
  "contentType": "ARTICLE",
  "dateCreated": "2026-01-09T12:00:00",
  "dateUpdated": "2026-01-10T15:30:00",
  "url": "http://localhost:8080/my-post"
}


4. Delete Content

Removes a post from the system.

Request: DELETE /api/content/{id}

Response: 204 No Content









