package api.test;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.PetModuleEndPoints;
import api.payload.CategoryPojo;
import api.payload.StatusValues;
import api.payload.TagsPojo;
import api.payload.petPOJO;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class PetModuleTests {
	
	Faker faker;
	petPOJO petPayload;
	
	@BeforeClass
	public void setUp()
	{
		faker = new Faker();
		petPayload = new petPOJO();
		
		petPayload.setId(faker.animal().hashCode());
		petPayload.setName(faker.dog().name());
		
		CategoryPojo category = new CategoryPojo();
		category.setID(faker.hashCode());
		category.setName(faker.dog().breed());
		petPayload.setCategory(category);
		
		List<TagsPojo> allTags = new ArrayList<>();
		TagsPojo tags = new TagsPojo();
		tags.setId(1);
		tags.setName("Dog");
		allTags.add(tags);
		petPayload.setTags(allTags);
		
		String[] photoURLs = new String[] {"https://abc.jpeg"};
		petPayload.setPhotoUrls(photoURLs);
		
		petPayload.setStatus(StatusValues.available);
	}
	
	@Test(priority=1)
	public void testPostPet() 
	{
		Response response = PetModuleEndPoints.addPetPost(petPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	//@Test(priority=2)    
	//this test uploads a file from local sysytem so commenting it for now.
	public void uploadPetImage()
	{
		Response response = PetModuleEndPoints.uploadPetImage(this.petPayload.getId());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	@Test(priority=3)
	public void getPetByID()
	{
		Response response =PetModuleEndPoints.getPetByID(this.petPayload.getId());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	@Test(priority=4)
	public void updatePet()
	{
		String newPetname = faker.animal().name();
		petPayload.setName(newPetname);
		System.out.println("New name ="+newPetname);
		Response response = PetModuleEndPoints.updateExistingPet(this.petPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=5)
	public void updatePetStoreStatus() 
	{
		Response response = PetModuleEndPoints.updateStoreStatus(this.petPayload.getId(),this.petPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	//@Test(priority=6)
	public void getPetByStatus()
	{
		Response response = PetModuleEndPoints.getPetByStatus();
		response.then().log().all();
	}
	@Test(priority=7)
	public void deletePet()
	{
		System.out.println("Deleted Pet id ="+this.petPayload.getId());
		Response response = PetModuleEndPoints.deletePet(this.petPayload.getId());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
}
