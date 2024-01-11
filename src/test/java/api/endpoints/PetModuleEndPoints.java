package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.petPOJO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PetModuleEndPoints {
	//this class contains CRUD(create,retrieve,update and delete requests) operations implementations only(exclude validations in this class)
	
	
	//this method will load properties file
	static ResourceBundle getURL() 
	{
		ResourceBundle routes=ResourceBundle.getBundle("routes"); //getbundle() looks for properties file so no need to give any path of file
		return routes;	
	}
	
	public static Response addPetPost(petPOJO payload) 
	{
		String addPet_url = getURL().getString("addPet_url");
		Response response=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
			.when()
				.post(addPet_url);
		return response;
		
	}
	public static Response getPetByID(int petID)
	{
		String getPet_url = getURL().getString("getPet_url");
		Response response = given()
						.accept(ContentType.JSON)
						.pathParam("petID", petID)
					.when()
						.get(getPet_url);
		return response;
	}
}
