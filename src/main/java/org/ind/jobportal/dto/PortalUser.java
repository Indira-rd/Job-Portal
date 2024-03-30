package org.ind.jobportal.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Data
public class PortalUser {
	@Size(min=3, max=15, message="* Enterbetween 3-15 characters")
	private String name;
	@NotNull(message=" * this is required field")
	@Email(message="* Enter proper email format")
	private String email;
	@DecimalMin(value="6000000000", message="* Enter proper mobile number")
	@DecimalMax(value="9999999999", message="* Enter proper mobile number")
	private long mobile;
	@NotNull(message="* this is required field")
	private LocalDate dob;
	@Size(min=8, max=15, message="* Enter between 8-15 characters")
	private String password;
	@Size(min=8, max=15, message="* Enter between 8-15 characters")
	private String confirm_password;
	private String role;
	

}
