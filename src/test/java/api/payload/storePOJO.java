package api.payload;

import java.util.Date;

public class storePOJO {
	
	int id;
	int petId;
	int quantity;
	Date shipDate;
	String status="placed";
	String complete="true";
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPetId() {
		return petId;
	}
	public void setPetId(int petId) {
		this.petId = petId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Date getShipDate() {
		return shipDate;
	}
	public void setShipDate(Date date) {
		this.shipDate = date;
	}
	public String getComplete() {
		return complete;
	}
	public void setComplete(String complete) {
		this.complete = complete;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
