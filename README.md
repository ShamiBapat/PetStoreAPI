This is the PETSTORE project which is done for practising API testing.
Rest assured and TestNG framework is used here.

Folder structure -- 
src/test/java  
  1. api.endpoints --> this package contains CRUD(create,retrieve,update and delete requests) operations implementations only(exclude validations in this class)
                        also had routes.java class which has endpoints of all URLs.
  2. api.payload --> this has all the required POJO classes of respective modules
  3. api.test --> this package has all the testcase and hence includes validations(assertion)
  4. api.utilities--> this includes all the ultity files like Excel utility, log4j2 utility,report utility

src/test/resources 
  1. test data folder - this has excel file which is used for data driven testcases
  2. log4j utility
  3. routes.properties - this file has key value pairs of all the URLs required in all three modules. these URLs can be fetched using resource bundles approach.
