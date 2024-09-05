Welcome, this is my first project using Java Springboot. made for the challenge [text](https://roadmap.sh/projects/blogging-platform-api)

To run the project, follow these steps:

1. Make sure you have Java 17 and MySQL installed on your machine.

2. Clone the repository to your local machine using the following command:
    ```
    git clone <repository-url>
    ```

3. Open the project in your preferred IDE.

4. Configure the MySQL database connection in the `application.properties` file. Update the following properties with your MySQL credentials:
    ```
    spring.datasource.url=jdbc:mysql://localhost:3306/blog
    spring.datasource.username=<your-username>
    spring.datasource.password=<your-password>
    ```

5. Build the project to resolve dependencies.

6. Run the application by executing the main method in the `PlatformApplication.java` class.

7. Once the application is running, you can access the API endpoints using a tool like Postman or cURL.

That's it! You should now be able to run the project and start managing blog posts using the API. If you encounter any issues, feel free to ask for further assistance.