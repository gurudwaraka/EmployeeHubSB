package com.example.employeeHub.controller;

import com.example.employeeHub.entity.ProfileEntity;
import com.example.employeeHub.model.ProfileModel;
import com.example.employeeHub.repository.ProfileRepository;
import com.example.employeeHub.service.ProfileService;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    // Get all Employee Profiles
    @GetMapping()
    public ResponseEntity<List<ProfileModel>> getAllProfiles() {
        List<ProfileModel> profiles = profileService.getAllProfiles();
        return new ResponseEntity<>(profiles, HttpStatus.OK);
    }

    // Get a single Employee Profile by ID
    @GetMapping("/{id}")
    public ResponseEntity<ProfileModel> getProfileById(@PathVariable Long id) {
        Optional<ProfileModel> profile = profileService.getProfileById(id);
        return profile.map(response -> new ResponseEntity<>(response, HttpStatus.OK))
                      .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));	
    }

    // Create a new Employee Profile
    @PostMapping("/create")
    public ResponseEntity<?> createProfile(@RequestBody ProfileModel employeeProfile) {
        try {
            ProfileModel createdProfile = profileService.createProfile(employeeProfile);
            return new ResponseEntity<>(createdProfile, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }


    // Update an existing Employee Profile
    @PutMapping("/{id}")
    public ResponseEntity<ProfileModel> updateProfile(@PathVariable Long id, @RequestBody ProfileModel employeeProfile) {
        Optional<ProfileModel> updatedProfile = profileService.updateProfile(id, employeeProfile);
        return updatedProfile.map(response -> new ResponseEntity<>(response, HttpStatus.OK))
                             .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Delete an Employee Profile by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfile(@PathVariable Long id) {
        boolean isDeleted = profileService.deleteProfile(id);
        return isDeleted ? new ResponseEntity<>(HttpStatus.OK) 
                         : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    //Get the Employee Ids
    @GetMapping("/employees")
    public ResponseEntity<List<Long>> getAllEIds() {
        List<Long> profiles = profileService.getAllEIds();
        return new ResponseEntity<>(profiles, HttpStatus.OK);
    }
    //Get the manager Ids
    @GetMapping("/managers")
    public ResponseEntity<List<Long>> getAllMIds() {
        List<Long> profiles = profileService.getAllMIds();
        return new ResponseEntity<>(profiles, HttpStatus.OK);
    }
    
    
 // Employees under Manager using Id
    @GetMapping("/manager/{id}")
    public ResponseEntity<List<Long>> getEByManager(@PathVariable Long id) {
        List<Long> profileIds = profileService.getEByManager(id);
        
        if (profileIds.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(profileIds, HttpStatus.OK);
        }
    }
    
    @GetMapping("/password")
    public ResponseEntity<String> getPasswordByEmail(@RequestParam String email) {
        String password = profileService.getPasswordByEmail(email);
        
        if (password != null) {
            return new ResponseEntity<>(password, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Email not found", HttpStatus.NOT_FOUND);
        }
    }   

}
