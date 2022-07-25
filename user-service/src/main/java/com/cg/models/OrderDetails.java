package com.cg.models;

import javax.validation.constraints.NotEmpty;


import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "userdetailsdb")
public class OrderDetails 
{
	@Id
	private int id;
	
	private String CarName;
    @NotEmpty(message="carname should not be empty")
	private String Model;
    @NotEmpty(message="model should not be empty")
	private String washerName;
    @NotEmpty(message="washername should not be empty")
	private int washpackId;
    @NotNull(message="washpackageid should not be empty")
	private String Date;
    @NotNull(message="preffered should not be empty")
    @NotNull(message="contactNo should not be empty")
	private long contact;
    
    public OrderDetails()
    {
    	
    }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCarName() {
		return CarName;
	}
	public void setCarName(String carName) {
		CarName = carName;
	}
	public String getModel() {
		return Model;
	}
	public void setModel(String model) {
		Model = model;
	}
	public String getWasherName() {
		return washerName;
	}
	public void setWasherName(String washerName) {
		this.washerName = washerName;
	}
	public int getWashpackId() {
		return washpackId;
	}
	public void setWashpackId(int washpackId) {
		this.washpackId = washpackId;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public OrderDetails(int id, String carName, @NotEmpty(message = "carname should not be empty") String model,
			@NotEmpty(message = "model should not be empty") String washerName,
			@NotEmpty(message = "washername should not be empty") int washpackId,
			@NotNull(message = "washpackageid should not be empty") String date,
			@NotNull(message = "preffered should not be empty") @NotNull(message = "contactNo should not be empty") long contact) {
		super();
		this.id = id;
		CarName = carName;
		Model = model;
		this.washerName = washerName;
		this.washpackId = washpackId;
		Date = date;
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", CarName=" + CarName + ", Model=" + Model + ", washerName=" + washerName
				+ ", washpackId=" + washpackId + ", Date=" + Date + ", contact=" + contact + "]";
	}
    
	
	
}
