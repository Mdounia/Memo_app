package com.example.demo.models;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="medicine")
public class Medicine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String description;
	private  String time;
	private float dose;
	private String support;
	@ManyToOne 
	private User user;
	
	

	public Medicine(String name, String description, String time,  float dose, String support, User user) {
		super();
		this.name = name;
		this.description = description;
		this.time = time;
		this.dose = dose;
		this.support = support;
		this.user = user;
	}
	public Medicine() {
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public float getDose() {
		return dose;
	}
	public void setDose(float dose) {
		this.dose = dose;
	}
	public String getSupport() {
		return support;
	}
	public void setSupport(String support) {
		this.support = support;
	}
	
	
	
	
	
	
	

}
