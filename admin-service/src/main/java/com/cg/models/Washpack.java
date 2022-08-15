package com.cg.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "washpackdb")
public class Washpack {
	@Id
	private int id;
	private String packname;
	private String description;
	private Integer cost;
	
	@Transient
    public static final String SEQUENCE_NAME = "users_sequence";
	
	
	public Washpack(int id, String packname, String description, Integer cost) {
		super();
		this.id = id;
		this.packname = packname;
		this.description = description;
		this.cost = cost;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPackname() {
		return packname;
	}
	public void setPackname(String packname) {
		this.packname = packname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getCost() {
		return cost;
	}
	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Washpack [id=" + id + ", packname=" + packname + ", description=" + description + ", cost=" + cost
				+ "]";
	}
	
	
	
	

}
