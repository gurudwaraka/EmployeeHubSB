package com.example.employeeHub.service;


import java.util.List;
import java.util.Optional;

import com.example.employeeHub.model.ProfileModel;

public interface ProfileService {
	
    Optional<ProfileModel> getProfileById(Long id);
    Optional<ProfileModel> updateProfile(Long id, ProfileModel employeeProfile);
    boolean deleteProfile(Long id);

	List<ProfileModel> getAllProfiles();

	ProfileModel createProfile(ProfileModel employeeProfile);
	List<Long> getAllEIds();
	List<Long> getAllMIds();
	List<Long> getEByManager(Long id);
	
	String getPasswordByEmail(String email);
}