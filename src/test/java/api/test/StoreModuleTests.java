package api.test;

import java.util.Date;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.StoreModuleEndPoints;
import api.payload.storePOJO;
import io.restassured.response.Response;

public class StoreModuleTests {
	Faker faker;
	storePOJO storePayload;
	public Logger logger;
	
	@BeforeClass
	public void setUp() 
	{
		storePayload = new storePOJO();
		Random random = new Random();
		faker = new Faker();
		
		storePayload.setId(random.nextInt(300));
		storePayload.setPetId(faker.idNumber().hashCode());
		storePayload.setQuantity(random.nextInt(10)); //random value within 10
		storePayload.setShipDate(new Date()); //Date() returns current date and time
		
		//logs
				logger= LogManager.getLogger(this.getClass());			
				logger.debug("debugging.....");
		
	}
	
	@Test(priority=1)
	public void testPostStore() 
	{
		logger.info("********** placing an order  ***************");
		Response response = StoreModuleEndPoints.placeOrder(storePayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("********** Order placed sucessfully  ***************");
	}
	
	@Test(priority=2)
	public void testGetStoreDetails()
	{
		logger.info("********** Reading Store Info ***************");
		Response response = StoreModuleEndPoints.getStoreData(this.storePayload.getId());
		response.then().log().all();
		Assert.assertEquals(response.statusLine(), "HTTP/1.1 200 OK");
		logger.info("********** Store info displayed ***************");
	}
	@Test(priority=3)
	public void testGetInventoryStatus()
	{
		logger.info("********** Store inforation by status ***************");
		Response response = StoreModuleEndPoints.getStoreInventory();
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
		logger.info("********** Status displayed ***************");
	}
	@Test(priority=4)
	public void testDeleteOrder()
	{
		logger.info("********** Deleting order placed ***************");
		Response response = StoreModuleEndPoints.deleteStoreOrder(this.storePayload.getId());
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("Deleted order details of orderID="+this.storePayload.getId());
		logger.info("********** order deleted ***************");
	}
}
