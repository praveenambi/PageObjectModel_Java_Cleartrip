Hello all,

Hope you all are doing well

Agenda;
Here we are building a solution to compare the weather information of a selected  city  with an API response,The soul purpose of this
project  is to develop an automated process to compare the weather information and based on the results, the further process to be carried out.

 Project Architecture:
 
 The project is built using the below components 
 Java
 Selenium webdriver 4.x
 TestNG
 Maven
 RestAssured libraries as Rest client
 
 
 Here we have developed an automation framework using the POM pattern, where the each page objects are captured and store in the pages claases.
 we have a base class here which contains the functions of initial driver setup and generic functions. we have the test classes for each test performed in com.weatherInfo.test.
 
 
 The framework is well structured and separated from the test data.  The test data is maintained in a properties file. 
 It contains multiple packages  for each type of classes like basepages , object pages and tests.
 So it would be easy  in the point of maintenance.
 
 
 The common repository:
 This project has been pushed to the GITHub repository using the GIT client, so it would be easy to use for other members
 This project can be pulled to your local repository from the GIT hub repo. Please find the GIThub repositery link as below
 
 https://github.com/praveenambi/WeatherInfo_Test
 
 
 Instructions for local execution:
 1. connect to  https://github.com/praveenambi/WeatherInfo_Test repo using your local GIT client
 2. pull the code to your local GIT repository
 3. import the project to your local eclipse or any other editor workspace.
 4. update the project  if nessasary 
 5. make sure the  organizational proxy configurations are done for  building
 6. update the POM.xml file (dependencies will be downloaded)
 7. project will be built
 8. Run the project using the testng.xml file which will be used for parallel execution also.
 
 
 



