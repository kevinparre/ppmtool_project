package com.springboot.ppmtool.payload;

import java.util.Date;

import javax.validation.constraints.NotBlank;

public class SignUpRequest {
	    @NotBlank
	    private String username;

	    @NotBlank
	    private String fullName;

	    @NotBlank
	    private String password;
	    
	    @NotBlank
	    private String confirmpassword;

	   
	    private Date create_At;

	    @NotBlank
	    private  Date update_At;

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getFullName() {
			return fullName;
		}

		public void setFullName(String fullName) {
			this.fullName = fullName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getConfirmpassword() {
			return confirmpassword;
		}

		public void setConfirmpassword(String confirmpassword) {
			this.confirmpassword = confirmpassword;
		}

		public Date getCreate_At() {
			return create_At;
		}

		public void setCreate_At(Date create_At) {
			this.create_At = create_At;
		}

		public Date getUpdate_At() {
			return update_At;
		}

		public void setUpdate_At(Date update_At) {
			this.update_At = update_At;
		}



}
