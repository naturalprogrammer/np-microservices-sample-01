package com.naturalprogrammer.np01.profile.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Profile {
	
	@Id
	@GeneratedValue
	private Long id;

	private Long userId;
	private String website;
	private String about;
}
