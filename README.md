# MangaLib - Manga Reader Backend

MangaLib is a backend service for a manga reader application. It provides APIs for fetching manga chapters from a third-party source, managing user authentication, tracking reading history, and handling library management.

## Features
- **User Authentication**: Integrates with third-party authorization servers (Google, Facebook, GitHub) for authentication.
- **Manga Fetching**: Retrieves manga chapters from a third-party API.
- **Library Management**: Users can add, remove, and organize their manga collection.
- **Reading History**: Tracks users' reading progress.
- **Rate Limiting**: Prevents excessive API requests.
- **Caching**: Optimizes performance by storing frequently accessed data.

## Tech Stack
- **Spring Boot** - Backend framework
- **MongoDB** - NoSQL database for user data and manga metadata
- **Spring Security** - Authentication and authorization
- **OAuth 2.0** - Third-party authentication integration
- **Redis** - Caching mechanism
- **Resilience4j** - Rate limiting and circuit breaking
- **Spring WebFlux (optional)** - Handling async requests if required
