# jawwytv-test
To run project : mvn clean install
created a project using selenium java
here I have created a data driven framework
data is stored in the excel file.
POM with page factory is used as a design pattern
maven is used as the build tool
TestNG is used as UnitTesting tool.
reusable utilities are created under utility package. 
excel utility and wait utility.

under testscript package i have test class called HomePageTest
in Homepage Test ,there is a test TC_001_ValidateTheSubscriptionPackages
here iam using data provider to run the same test for multiple countries.
expected data for all countries are stored in TestData excel file under resources
each country subscription plan ,price and currency(actual data) will read and stored in list of array list
and it can be assert by comapring expected data from excel fle.

as part of configuration crossbrowserTestNG created.






