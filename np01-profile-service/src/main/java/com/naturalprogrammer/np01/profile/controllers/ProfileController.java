package com.naturalprogrammer.np01.profile.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naturalprogrammer.np01.profile.domain.Profile;
import com.naturalprogrammer.np01.profile.forms.ProfileForm;
import com.naturalprogrammer.np01.profile.services.ProfileService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/profiles")
@AllArgsConstructor
public class ProfileController {

	private static final Log log = LogFactory.getLog(ProfileController.class);
	
	private ProfileService profileService;

	@PostMapping
	public Profile upsertProfile(@RequestBody ProfileForm profile) {
		
		log.debug("Signing up: " + profile);
		return profileService.upsertProfile(profile);
	}
}
