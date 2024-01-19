package api.endpoints;

public class Routes {
	
	//this class will have all the requied urls only
public static String base_url="https://petstore.swagger.io/v2" ;
	
	//User module
	
	public static String post_url=base_url+"/user";
    public static String get_url=base_url+"/user/{username}";
    public static String update_url=base_url+"/user/{username}";
    public static String delete_url=base_url+"/user/{username}";
    
    //pet Module
    public static String uploadPetImage = base_url+"/pet/{petID}/uploadImage";
    public static String addPet_url = base_url+"/pet";
    public static String uploadImg_url = base_url+"/pet/{petID}/uploadImage"; 
    public static String getPet_url = base_url+"/pet/{petID}";
    public static String getPet_byStatus_url = base_url+"/pet/findByStatus";  //status value is query parameter
    public static String updatePet_url = base_url+"/pet";
    public static String updateStoreStatus_url = base_url+"/pet{petID}";       //pet name and Status as form data in request body
    public static String deletePet_url = base_url+"/pet{petID}";
    
    //store Module
    public static String postStore_url= base_url+"/store/order"; //place order
    public static String getStore_url = base_url+"/store/order/{orderID}"; //find order
    public static String getStorebyStatus_url= base_url+"/store/inventory"; //store status details
	public static String deleteStore_url = base_url+"/store/order/{orderID}"; //delete order

}
