# graphwalker-selenium-RottenTomatoes
This is a Readme for the project.
- Navigate to https://github.com/adilaghayev/graphwalker-selenium-RottenTomatoes/tree/master/src/main/java/com/company to see the class files.
- Runner class is the main class, that executes the tests.
- To select the test (LoginTest, SearchWatchlistRateTest, TopMoviesTest), simply write the test class file name in the Runner Class
  - Ex. (To run LoginTest): 
  
public class Runner {
  public static void main(String[] args) throws IOException {
    TestExecutor executor = new TestExecutor(
            LoginTest.class
            
- Helper class is an accessory class that contains getWaiter and getInstance methods, which are modeified getDriver methods, for ease of use.         
- Navigate to https://github.com/adilaghayev/graphwalker-selenium-RottenTomatoes/tree/master/src/main/resources/com/company to see the Graphwalker json files.
- The project should work after you compile it in Maven environment.
