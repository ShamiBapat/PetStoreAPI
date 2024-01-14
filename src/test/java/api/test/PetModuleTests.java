package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.PetModuleEndPoints;
import api.payload.CategoryPojo;
import api.payload.TagsPojo;
import api.payload.petPOJO;
import io.restassured.response.Response;

public class PetModuleTests {
	
	Faker faker;
	petPOJO petPayload;
	
	@BeforeClass
	public void setUp()
	{
		faker = new Faker();
		petPayload = new petPOJO();
	//	String category[]= {"1","Dalmation"}; //how to pass the string array values
		
		petPayload.setId(faker.animal().hashCode());
		petPayload.setName(faker.dog().name());
		
		CategoryPojo category = new CategoryPojo();
		category.setCategoryID(211);
		category.setCategoryName("Dalmation");
		petPayload.setCategory(category);
		
		TagsPojo tags = new TagsPojo();
		tags.setId(1);
		tags.setName("Dog");
		petPayload.setTags(tags);
		
	}

	@Test(priority=1)
	public void testPostPet() 
	{
		Response response = PetModuleEndPoints.addPetPost(petPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	@Test(priority=2)
	public void getPetByID()
	{
		Response response =PetModuleEndPoints.getPetByID(this.petPayload.getId());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	@Test(priority=3)
	public void getPetByStatus()
	{
		Response response = PetModuleEndPoints.getPetByStatus();
		response.then().log().all();
	}
}
