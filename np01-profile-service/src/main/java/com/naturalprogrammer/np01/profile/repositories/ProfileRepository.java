package com.naturalprogrammer.np01.profile.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naturalprogrammer.np01.profile.domain.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

	Optional<Profile> findByUserId(Long userId);
}
