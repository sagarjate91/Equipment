package com.measuring.equipment.common;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserModel implements Serializable {

	private int id;
	@NotBlank(message = "Please enter the firstName")
	private String firstName;
	@NotBlank(message = "Please enter the lastName")
	private String lastName;
	@NotBlank(message = "Please enter the userName")
	private String userName;
	@NotBlank(message = "Please enter a valid e-mail address")
	@Email(message = "Please enter a valid e-mail address")
	private String email;
	@NotBlank(message = "Please enter the password")
	private String password;
	@NotBlank(message = "Please enter mobileNumber")
	private String mobileNumber;
	@NotBlank(message = "Please enter the address")
	private String address;
	@NotBlank(message = "Please enter the pincode")
	private String pinCode;

	


}
