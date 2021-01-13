package com.measuring.equipment.common;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginModel implements Serializable{
	
	private int id;
	
	@NotBlank(message = "Please enter a valid e-mail address")
	@Email(message = "Please enter a valid e-mail address")
	private String email;
	@NotBlank(message = "Please enter the password")
	private String password;

}
