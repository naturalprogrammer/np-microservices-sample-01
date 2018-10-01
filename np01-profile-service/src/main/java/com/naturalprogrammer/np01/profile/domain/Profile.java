package com.naturalprogrammer.np01.profile.domain;

import javax.persistence.Entity;

import com.naturalprogrammer.spring.lemon.commonsjpa.LemonEntity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Profile extends LemonEntity<Long> {
	
	private Long userId;
	private String website;
	private String about;
}
