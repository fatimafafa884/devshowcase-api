package com.devshowcase.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.devshowcase.api.model.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}