package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.storePOJO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StoreModuleEndPoints {
	
	//this class contains CRUD(create,retrieve,update and delete requests) operations implementations only(exclude validations in this class)
	
		public static Response placeOrder(storePOJO payload)
		{
			Response response=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
			.when()
				.post(Routes.postStore_url);
				
			return response;
		}
		
		public static Response getStoreData(int orderID)
		{
			Response response=given()
							.pathParam("orderID",orderID)
			.when()
				.get(Routes.getStore_url);
				
			return response;
		}
		public static Response deleteStoreOrder(int orderID)
		{
			Response response=given()
							.pathParam("orderID",orderID)
			.when()
				.delete(Routes.deleteStore_url);
				
			return response;
		}	
		public static Response getStoreInventory() {
			Response response = given()
									.when()
										.get(Routes.getStorebyStatus_url);
			return response;
		}
}
