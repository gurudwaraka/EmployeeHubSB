package com.example.employeeHub.entity;



import jakarta.persistence.*;

import java.util.Date;

import com.example.employeeHub.model.ProfileModel;

@Entity
@Table(name = "employee_profiles")  // Optional: specify the table name if different from the class name
public class ProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

    @Column(nullable = false)
    public String firstName;

    @Column(nullable = false)
    public String lastName;

    @Column(nullable = false, unique = true)
    public String email;

    @Column(nullable = false)
    public String password;

    @Column(nullable = true)
    public String phoneNumber;

    @Column(nullable = false)
    public String jobRole;

    @Column(nullable = true)
    public Long managerId;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date lastUpdated;

    @Column(nullable = false)
    public String lastModifiedBy;
    

	@Column(nullable = true)
	public String image;

    // Constructors
    public ProfileEntity() {
    }

    public ProfileEntity(String firstName, String lastName, String email, String password, String phoneNumber, String jobRole, Long managerId, Date lastUpdated, String lastModifiedBy,String image) {
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

    // Optional: Override toString, equals, and hashCode methods
    @Override
    public String toString() {
        return "ProfileEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", jobRole='" + jobRole + '\'' +
                ", managerId=" + managerId +
                ", lastUpdated=" + lastUpdated +
                ", lastModifiedBy='" + lastModifiedBy + '\'' +
                '}';
    }
    public ProfileModel toModel() {
        return new ProfileModel(
                this.id,
                this.firstName,
                this.lastName,
                this.email,
                this.password,
                this.phoneNumber,
                this.jobRole, 
                this.managerId,
                this.lastUpdated,
                this.lastModifiedBy,
                this.image
        );
    }
}
