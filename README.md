
Here’s a README.txt file for your API project. It includes an overview of the project, instructions for setup, running tests, and key dependencies.

Cyshield API Automation Project
This project is an API automation framework built using Java, Maven, TestNG, and RestAssured. It includes tests for interacting with a RESTful API, utilizing data from an Excel spreadsheet for data-driven testing.

Project Structure
Read_Data: Reads data from an Excel file and provides it to test methods as a data provider.
ApiTest: Contains test cases for API endpoints, including GET, POST, and PUT requests.
BaseTest: Sets up the base URI for the RESTful API and configures RestAssured.
POM File: Defines project dependencies and configurations for Maven.
Prerequisites
Java 15
Maven
Apache POI (for reading Excel files)
RestAssured (for API testing)
TestNG (for test management)
Setup
1. Install Dependencies
Ensure Maven is installed. To install the project dependencies, run:

Use : mvn clean install


2. Excel File Setup
Place the Excel file (doc.xlsx) in the src/main/resources directory. This file should contain the data required for the data-driven tests.



Running Tests
1. Test Execution
To run the tests, use Maven commands. The tests are structured using TestNG. Execute the following command to run the tests: "mvn test"

3. Test Data
The test data is read from an Excel file. Ensure the Read_Data class is correctly configured to read the data from doc.xlsx. The data provider method test_data will supply this data to the test methods.

Key Dependencies
RestAssured: For testing RESTful APIs.
TestNG: Framework for structuring and running test cases.
Apache POI: For reading data from Excel files.
Test Workflow
Setup: The setup method in BaseTest initializes RestAssured with the base URI of the API.
Test Execution: Tests are defined in the ApiTest class, which utilizes data from the Excel file to perform API operations.
Teardown: There is no explicit teardown in the provided test classes; cleanup would be handled by RestAssured and TestNG.
Troubleshooting
Data Reading Issues: Ensure that the Excel file is correctly formatted and placed in the src/main/resources directory.
API Issues: Verify that the API endpoints and payloads are correct and that the API server is accessible.
Dependency Issues: Ensure all Maven dependencies are correctly included and updated.
Contributing
Feel free to fork the repository and submit pull requests. For significant changes, please open an issue first to discuss the proposed changes.

License
This project is licensed under the MIT License - see the LICENSE file for details.

