# Pets in Africa API Project

This project provides an end-to-end feature leveraging data from the Dogs and Cats API. It's built using Spring Boot for the backend, serving REST APIs, and React for the frontend. The backend incorporates caching mechanisms to enhance performance.

## Features
- **Dogs View:** Displays a list of dogs found in Africa, including their images, names, and life spans.
- **Cats View:** Shows a list of cats found in Africa, including their images, names, and life spans.


## Getting Started
1. Clone the repository.
2. Run the backend Spring Boot application.
3. Run the frontend React application.
4. Access the application through the provided URLs.


## Download and Run

1. **Clone the Repository:**

   Clone the project repository to your local machine using Git. Open a terminal or command prompt and execute the following command:

   ``git clone https://github.com/nadaveshed/AnimalAPI.git``

2. **Navigate to Project Directory:**
   
   Change your current directory to the newly cloned project directory:
   ``cd AnimalAPI``


## Backend (Java Spring Boot)
  **Run the Backend (Spring Boot):**
  Navigate to the backend directory (AnimalAPI) and run the Spring Boot application:
    ```
    cd AnimalAPIServer
    ./mvnw spring-boot:run
    ```
    The backend should now be running on http://localhost:8080.


### AnimalServiceImpl
- Fetches data for dogs and cats from the external API.
- Implements caching using Spring's `@Cacheable` annotation to store fetched data temporarily.

### CacheConfig
- Configures caching for the application using Spring's `@EnableCaching` and defines a `ConcurrentMapCacheManager`.

### AnimalController
- Exposes REST endpoints for fetching dogs and cats data.
- Utilizes `AnimalService` to retrieve data from the external API and return it to the frontend.

### AnimalService
- Interface defining methods to fetch dogs and cats data.

## Frontend (React)
***Run the Frontend (React):***
Navigate to the frontend directory (frontend) and install dependencies:
```
cd animals-api-client
npm install
```
Start the React development server:
```
npm start
```
The frontend should now be accessible at http://localhost:3000.

Access the Application:
Open your web browser and navigate to http://localhost:3000 to access the application. You should see the Dogs and Cats views with their respective data fetched from the backend.

## Technologies Used
- **Backend:** Java, Spring Boot, Spring Cache
- **Frontend:** React
- **HTTP Client:** Axios
- **Data Serialization:** JSON
