# GameVibes F2P - Game Recommendation

## Overview
GameVibes F2P is a REST API that provides personalized free-to-play game recommendations based on the user's mood and time of day. It integrates with the FreeToGame API to suggest games that match the user's current emotional state and schedule.

## Key Features
- Mood-based game recommendations
- Time-sensitive suggestions
- Integration with FreeToGame API
- PC game filtering
- Customized game information responses
- Tag-based recommendation system

## Project Structure
```
project-root/
├── src/
│   └── main/
│       └── java/
│           ├── config/          # Configuration classes
│           ├── controller/      # REST controllers
│           ├── dto/            # Data Transfer Objects
│           ├── exception/      # Custom exceptions and handlers
│           ├── model/          # Entity classes
│           ├── repository/     # Data access layer
│           ├── request/        # Request models
│           ├── response/       # Response models
│           └── service/        # Business logic layer
├── api_collection.InsomniaV4.json    # Insomnia API collection
└── database_schema.sql               # Database creation script
```

## API Documentation
The project includes a complete Insomnia collection file (`api_collection.InsomniaV4.json`) that contains all available endpoints with example requests and responses. To use it:

1. Open Insomnia
2. Go to Application -> Preferences -> Data -> Import Data
3. Select the `api_collection.InsomniaV4.json` file
4. All endpoints will be imported with their corresponding request configurations

## Database Setup
1. The project includes a `database_schema.sql` file with all necessary database tables and relationships
2. To set up the database:
```bash
# Connect to your database server
mysql -u your_username -p

# Create the database
source path/to/database_schema.sql
```

## API Endpoints

### Game Recommendations
```
POST /api/recommendations
```
**Request Body:**
```json
{
    "mood": "string",
    "hour": "string"
}
```
**Response:**
- List of recommended games with:
  - Title
  - Short description
  - Genre

## Technical Stack
- **Framework**: Spring Boot
- **Build Tool**: Gradle
- **Java Version**: 17
- **External API**: FreeToGame API
- **JSON Parser**: Gson
- **Database**: MySQL/PostgreSQL
- **Architecture**: REST API
- **Design Pattern**: MVC
- **API Testing**: Insomnia

## Dependencies
```groovy
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-web'
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
    implementation 'com.google.code.gson:gson:2.x.x'
    runtimeOnly 'mysql:mysql-connector-java' // or your preferred DB connector
    // Add other dependencies as needed
}
```

## Setup Requirements
1. Java 17
2. Gradle
3. MySQL/PostgreSQL
4. Internet connection for FreeToGame API access
5. Spring Boot properties configuration

## Installation & Running
```bash
# Clone the repository
git clone [repository-url]

# Navigate to project directory
cd gamevibes-f2p

# Setup database
mysql -u your_username -p < database_schema.sql

# Build the project
gradle clean build

# Run the application
gradle bootRun
```

## Environment Configuration
```properties
# application.properties/yaml
spring.datasource.url=jdbc:mysql://localhost:3306/gamevibes_db
spring.datasource.username=your_username
spring.datasource.password=your_password
```

## How It Works
1. User submits their current mood and time of day
2. System analyzes the input to determine appropriate game tags
3. API queries FreeToGame for matching games
4. Results are filtered and formatted
5. Customized recommendations are returned to the user

## Error Handling
- Custom ResourceNotFoundException for no games found
- Appropriate HTTP status codes
- Descriptive error messages

## Build Configuration
```groovy
plugins {
    id 'org.springframework.boot' version '3.x.x'
    id 'io.spring.dependency-management'
    id 'java'
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-web'
    implementation 'com.google.code.gson:gson:2.x.x'
    implementation 'org.springframework.boot:spring-boot-starter-validation'
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
    // Add other dependencies as needed
}
```

## Usage Example
```curl
curl -X POST http://localhost:8080/api/recommendations \
-H "Content-Type: application/json" \
-d '{
    "mood": "happy",
    "hour": "evening"
}'
```

## Response Example
```json
{
    "recommendations": [
        {
            "title": "Game Title",
            "shortDescription": "Game Description",
            "genre": "Game Genre"
        }
    ]
}
```


## Contributing
Feel free to submit issues and enhancement requests.
