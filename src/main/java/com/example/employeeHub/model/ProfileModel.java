package com.example.employeeHub.model;

import java.util.Date;

import com.example.employeeHub.entity.ProfileEntity;

public class ProfileModel {

    public Long id;
    public String firstName;
    public String lastName;
    public String email;
    public String password;
    public String phoneNumber;
    public String jobRole;
    public Long managerId;
    public Date lastUpdated;
    public String lastModifiedBy;
	public String image;

    // Constructors
    public ProfileModel() {
    }

    public ProfileModel(Long id, String firstName, String lastName, String email, String password, String phoneNumber, String jobRole, Long managerId, Date lastUpdated, String lastModifiedBy,String image) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.jobRole = jobRole;
        this.managerId = managerId;
        this.lastUpdated = lastUpdated;
        this.lastModifiedBy = lastModifiedBy;
        this.image=image;
    }

    // Conversion from Entity to Model
    public static ProfileModel fromEntity(ProfileEntity entity) {
        return new ProfileModel(
                entity.id,
                entity.firstName,
                entity.lastName,
                entity.email,
                entity.password,
                entity.phoneNumber,
                entity.jobRole,
                entity.managerId,
                entity.lastUpdated,
                entity.lastModifiedBy,
                entity.image
        );
    }
    public ProfileEntity toEntity() {
        ProfileEntity entity = new ProfileEntity();
        entity.setId(this.id);
        entity.setFirstName(this.firstName);
        entity.setLastName(this.lastName);
        entity.setEmail(this.email);
        entity.setPassword(this.password);
        entity.setPhoneNumber(this.phoneNumber);
        entity.setJobRole(this.jobRole);
        entity.setManagerId(this.managerId);
        entity.setLastUpdated(this.lastUpdated != null ? this.lastUpdated : new Date());
        entity.setLastModifiedBy(this.lastModifiedBy);
        entity.setImage(this.image);
        return entity;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }
    public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
