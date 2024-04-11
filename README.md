[![MasterHead](https://i.pinimg.com/originals/ec/ec/36/ecec3687a972a20d8ba953b7f1bf4e43.gif)]()
<h1 align="center">Topic Board project for GreenAtom</h1>
<h2>Running the Project</h2>
To run the project, you will need Docker Compose. Simply run the following command:                                                
docker-compose up


This will start the application and its dependencies.

<h3>Building the Project</h3>

The project uses Gradle as the build system.

<h4>Authentication</h4>

The project uses Jwt Bearer authentication for securing endpoints.
Default user: johnDoe. Default password: 12345

<h5>Database Migration</h5>

Database migration is handled using LiquiBase.                           
The configuration files can be found in the src/main/resources/db/changelog directory.

<h6>API Documentation</h6>

API documentation is available using Swagger. Once the application is running, you can access the documentation at http://localhost:8080/swagger-ui.html.

<h6>Additional Notes</h6>

This is a test project for GreenAtom. Feel free to customize the project to fit your needs. If you have any questions or feedback, please create an issue or reach out to us directly.