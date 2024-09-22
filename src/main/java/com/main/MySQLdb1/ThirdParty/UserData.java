package com.main.MySQLdb1.ThirdParty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "user_data")
public class UserData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pId;
	
	private int userId;
	private int id;
	private String title;
	
	@JsonProperty("completed")
	private Boolean status;
	public UserData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserData(Long pId, int userId, int id, String title, Boolean status) {
		super();
		this.pId = pId;
		this.userId = userId;
		this.id = id;
		this.title = title;
		this.status = status;
	}
	public Long getpId() {
		return pId;
	}
	public void setpId(Long pId) {
		this.pId = pId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "UserData [pId=" + pId + ", userId=" + userId + ", id=" + id + ", title=" + title + ", status=" + status
				+ "]";
	}
	 
	
	
	
}
