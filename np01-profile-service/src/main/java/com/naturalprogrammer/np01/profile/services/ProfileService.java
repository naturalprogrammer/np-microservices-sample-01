package com.naturalprogrammer.np01.profile.services;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.naturalprogrammer.np01.profile.domain.Profile;
import com.naturalprogrammer.np01.profile.forms.ProfileForm;
import com.naturalprogrammer.np01.profile.repositories.ProfileRepository;
import com.naturalprogrammer.spring.lemon.commons.security.UserDto;
import com.naturalprogrammer.spring.lemon.commons.util.LecUtils;
import com.naturalprogrammer.spring.lemon.commonsweb.util.LecwUtils;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Validated
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class ProfileService {
	
	private static final Log log = LogFactory.getLog(ProfileService.class);
	private ProfileRepository profileRepository;
	
	@PreAuthorize("isAuthenticated()")
	public Profile upsertProfile(ProfileForm form) {
		
		UserDto user = LecwUtils.currentUser();
		LecUtils.ensureAuthority(user.isGoodAdmin() || user.getId().equals(
				form.getUserId().toString()),
				"com.naturalprogrammer.spring.notGoodAdminOrSameUser");
		
		return profileRepository.findByUserId(form.getUserId())
				.map(profile -> updateProfile(profile, form))
				.orElse(newProfile(form));
	}
	
	private Profile updateProfile(Profile profile, ProfileForm form) {

		profile.setWebsite(form.getWebsite());
		profile.setAbout(form.getAbout());
		
		return profileRepository.save(profile);
	}

	private Profile newProfile(ProfileForm form) {

		Profile profile = new Profile();
		profile.setUserId(form.getUserId());
		profile.setWebsite(form.getWebsite());
		profile.setAbout(form.getAbout());
		
		return profileRepository.save(profile);
	}	
}
