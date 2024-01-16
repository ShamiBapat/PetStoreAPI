package api.payload;

import java.util.List;

public class petPOJO {
	int id;
	List<TagsPojo> tags;
	CategoryPojo category;
	private String name;
	private String photoUrls[];
	StatusValues status;

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
	public List<TagsPojo> getTags() {
		return tags;
	}
	public void setTags(List<TagsPojo> tags) {
		this.tags = tags;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
	public String[] getPhotoUrls() {
		return photoUrls;
	}
	public void setPhotoUrls(String[] photoUrls) {
		this.photoUrls = photoUrls;
	}
	public StatusValues getStatus() {
		return status;
	}
	public void setStatus(StatusValues status) {
		this.status = status;
	}
}
