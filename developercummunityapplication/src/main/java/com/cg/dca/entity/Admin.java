package com.cg.dca.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Admin")
public class Admin {
	@Column(name = "admin_id")
	@Id
	private	int adminId;
	@Column(name = "name")
	private	String adName;

	@Size(min = 3, max = 20, message = "Username must be between 3 and 20   characters long.")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Username must be alphanumeric with no spaces")
	@Column(name = "username")
	private	String adUser;
	
	@Size(min = 6, max = 20, message = "The password must be at least 6 characters long.")
	@Column(name = "password")
	private	String adPassword;

	public int getAdminId() {
		return adminId;
	}

	public void setAdId(int adId) {
		this.adminId = adId;
	}

	public String getAdName() {
		return adName;
	}

	public void setAdName(String adName) {
		this.adName = adName;
	}

	public String getAdUser() {
		return adUser;
	}

	public void setAdUser(String adUser) {
		this.adUser = adUser;
	}

	public String getAdPassword() {
		return adPassword;
	}

	public void setAdPassword(String adPassword) {
		this.adPassword = adPassword;
	}
	
	

}
