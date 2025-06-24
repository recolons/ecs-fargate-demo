# ECS Fargate Demo with Editor Authentication

This Spring Boot application provides a news article management system with role-based authentication for editors.

## Front-end source code

- https://github.com/recolons/ecs-fargate-demo-frontend

## Features

- **Public Access**: Anyone can read articles and browse sections
- **Editor Authentication**: Editors can create, update, and delete articles
- **JWT-based Authentication**: Secure token-based authentication
- **Role-based Authorization**: Different roles (USER, EDITOR, ADMIN) with different permissions

## Authentication System

### Default Editor Account
- **Username**: `editor`
- **Password**: `editor123`
- **Email**: `editor@example.com`

### API Endpoints

#### Authentication Endpoints
- `POST /api/auth/login` - Login with username and password
- `POST /api/auth/register` - Register a new user (gets USER role)
- `POST /api/auth/register/editor` - Register a new editor (gets EDITOR role)

#### Article Endpoints
- `GET /api/articles` - Get all articles (PUBLIC)
- `GET /api/articles/{id}` - Get article by ID (PUBLIC)
- `POST /api/articles` - Create new article (EDITOR only)
- `PUT /api/articles/{id}` - Update article (EDITOR only)
- `DELETE /api/articles/{id}` - Delete article (EDITOR only)

### How to Use

#### 1. Login as Editor
```bash
curl -X POST http://localhost:8080/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "username": "editor",
    "password": "editor123"
  }'
```

Response:
```json
{
  "token": "eyJhbGciOiJIUzUxMiJ9...",
  "username": "editor",
  "email": "editor@example.com",
  "roles": ["EDITOR"],
  "tokenType": "Bearer"
}
```

#### 2. Create an Article (requires authentication)
```bash
curl -X POST http://localhost:8080/api/articles \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer YOUR_JWT_TOKEN" \
  -d '{
    "title": "New Article",
    "author": "Editor Name",
    "description": "Article description",
    "content": "Article content here...",
    "section": {"id": 1}
  }'
```

#### 3. Update an Article
```bash
curl -X PUT http://localhost:8080/api/articles/ARTICLE_ID \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer YOUR_JWT_TOKEN" \
  -d '{
    "title": "Updated Article Title",
    "content": "Updated content..."
  }'
```

#### 4. Delete an Article
```bash
curl -X DELETE http://localhost:8080/api/articles/ARTICLE_ID \
  -H "Authorization: Bearer YOUR_JWT_TOKEN"
```

#### 5. Register Editor

- **URI**: /api/auth/register/editor
- **Headers**: Content-Type: application/json

- **Request Body**:
```json
{
  "username": "neweditor",
  "password": "password123",
  "email": "neweditor@example.com",
  "firstName": "John",
  "lastName": "Doe"
}
```

### Security Configuration

- **JWT Secret**: Configured in `application.properties`
- **Token Expiration**: 24 hours (86400000 ms)
- **Password Encryption**: BCrypt
- **CORS**: Enabled for all origins

### Database Schema

The application includes the following tables:
- `users` - User accounts
- `roles` - User roles (USER, EDITOR, ADMIN)
- `user_roles` - Many-to-many relationship between users and roles
- `articles` - News articles
- `sections` - Article sections/categories

### Running the Application

1. **Start the application**:
   ```bash
   ./mvnw spring-boot:run
   ```

2. **Access the application**:
   - Application: http://localhost:8080
   - Health check: http://localhost:8080/actuator/health

3. **Test authentication**:
   - Use the default editor account or register a new one
   - Use the JWT token in the Authorization header for protected endpoints

### Development Notes

- The application uses H2 in-memory database for development
- JWT tokens are stateless and don't require database lookups for validation
- All passwords are encrypted using BCrypt
- CORS is enabled for frontend integration
- The security configuration allows public access to read operations and requires authentication for write operations 