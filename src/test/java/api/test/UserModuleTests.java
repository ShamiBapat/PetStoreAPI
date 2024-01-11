package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.userModuleEndPoints;
import api.payload.userPOJO;
import io.restassured.response.Response;

public class UserModuleTests {

	Faker faker;
	userPOJO userPayload;
	
	public Logger logger; // for logs
	
	@BeforeClass
	public void setup()
	{
		faker=new Faker();
		userPayload=new userPOJO();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		//logs
		logger= LogManager.getLogger(this.getClass());
		
		logger.debug("debugging.....");
		
	}
	
	@Test(priority=1)
	public void testPostUser()
	{
		logger.info("********** Creating user  ***************");
		Response response=userModuleEndPoints.createUser(userPayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(),200);
		
		logger.info("**********User is creatged  ***************");
			
	}
	
	@Test(priority=2)
	public void testGetUserByName()
	{
		logger.info("********** Reading User Info ***************");
		System.out.println("Previous Username created is="+this.userPayload.getUsername());
		System.out.println("Previous First name is="+this.userPayload.getFirstName());
		System.out.println("Previous last name is="+this.userPayload.getLastName());
		System.out.println("Previous email address is="+this.userPayload.getEmail());
		
		Response response=userModuleEndPoints.readUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		
		logger.info("**********User info  is displayed ***************");
		
	}
	
	@Test(priority=3)
	public void testUpdateUserByName()
	{
		
		logger.info("********** Updating User ***************");
		
		//update data using payload
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
		Response response=userModuleEndPoints.updateUser(this.userPayload.getUsername(),userPayload);
		response.then().log().body();
				
		Assert.assertEquals(response.getStatusCode(),200);
		
		logger.info("********** User updated ***************");
		System.out.println("New username="+this.userPayload.getUsername());
		System.out.println("New First name is="+this.userPayload.getFirstName());
		System.out.println("New Last name is="+this.userPayload.getLastName());
		System.out.println("New email is="+this.userPayload.getEmail());
		//Checking data after update
		Response responseAfterupdate=userModuleEndPoints.readUser(this.userPayload.getUsername());
		Assert.assertEquals(responseAfterupdate.getStatusCode(),200);
			
	}
	
	@Test(priority=4)
	public void testDeleteUserByName()
	{
		
		logger.info("**********   Deleting User  ***************");
		
		Response response=userModuleEndPoints.deleteUser(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(),200);
		
		logger.info("********** User deleted ***************");
		
		System.out.println("---------deleted user details-----");
		System.out.println("username="+this.userPayload.getUsername());
		System.out.println("firstname="+this.userPayload.getFirstName());
		System.out.println("Lastname="+this.userPayload.getLastName());
	}
	
	
}
