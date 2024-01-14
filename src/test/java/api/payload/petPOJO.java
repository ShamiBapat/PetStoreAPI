package api.payload;

public class petPOJO {
	int id;
	TagsPojo tags;
	CategoryPojo category;
	private String name;
	private String photoUrls;
	
	private String status="available";
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public CategoryPojo getCategory() {
		return category;
	}
	public void setCategory(CategoryPojo category) {
		this.category = category;
	}
	public TagsPojo getTags(TagsPojo tags)	{
		return tags;	 
	}
	public void setTags(TagsPojo tags) {
		this.tags = tags;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhotoUrls() {
		return photoUrls;
	}
	public void setPhotoUrls(String string) {
		this.photoUrls = string;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
