## Short Description
Test Task for one of the internships

Web API with endpoints to retreive book by category,by ISBN and retreiving list of all authors with their average rating.
## Application framework - Spring Boot
Spring Boot is a framework which is designed to simplify the bootstraping and development of Spring application.
I've decided to use it because this project was my first experience in building Web API on Spring and I wanted to make it as easy and understandable as possible.
Also ,thanks to the Spring Boot, I didn't had to configure my XML file and there was an embedded HTTP server(Tomcat).
## Testing framework - The Spring MVC Test framework
As I've already wrote ,I wanted to stick with the options which are already available in Spring Boot and Spring MVC Test framework was one of them.
The syntax is quite understandable and I've been able to find a couple of very nice tutorials(this one has bought me (: )
## Design patter - DAO
I've decided to stick with the DAO design pattern in order to divide my project on layers, which will lead to modularity.
Thanks to it ,my code ,as well as my workflow, was divided into parts and I was undertanding what exactly I am working on.
## Instructions on how to run
### Building
In order to build the application run the following command
```
mvn package
```
And press Ctrl+Enter
### Running
After building the application run the following command

```
java -jar .\target\LibraryAPI-0.0.1-SNAPSHOT.jar [fileName.json]
```
If there are no arguments provided, the books.json will be chosen by default.
Datasets should be located in LibraryAPI\src\main\resources
