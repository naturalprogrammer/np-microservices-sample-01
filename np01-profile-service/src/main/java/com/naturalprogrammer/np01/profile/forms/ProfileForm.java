package com.naturalprogrammer.np01.profile.forms;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProfileForm {

	@NotNull
	private Long userId;

	@NotBlank
	@Size(max=100)
	private String name;

	@URL @Size(max=1024)
	private String website;
	
	@Size(max=4096)
	private String about;
}
