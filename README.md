# WeatherSensorData
RESTful Spring Boot application to handle data from weather sensors

## Requirements
- Java 11 (Runtime Version 55 - SE Development Kit 11.0.15)
- Apache Netbeans 12.4 (Or any IDE of your choosing)
- XAMPP 8.1.6
    - PhpMyAdmin Module
    - MySQL Module
## Startup
- Load XAMPP and start modules:
  - Apache (Should be ports 80, 443)
  - MySQL (Should be port 3306)
- Load up project in your IDE
- Run a build
- Open command prompt in project root directory
- Enter: **_mvnw spring-boot:run_** in command prompt to start up application
### Commands:
- Consult **_Commands.txt_** for a list of commands that can be entered through command prompt & the web browser
- These commands can be run from a new command prompt window irrespective of its current directory location
- The full [[[Data Import]]] block of commands can be pasted into command prompt to populate the DB with test data
## Notes
- Currently the application is set to automatically create a database and then drop it on application close, this can be changed in the **_application.properties_** file found in **_src/main/resources_** by editting the **_spring.jpa.hibernate.ddl-auto=create-drop_** parameter
- - The following options are available:
    - **_create_** - Drops existing & creates new tables
    - **_update_** - Updates DB schema according to any differences
    - **_create-drop_** - Same as **_create_** but will drop the database after operations have completed. Used for testing
    - **_validate_** - Validates if tables and columns exist, otherwise will throw an exception
    - **_none_** - Turns off DB generation
