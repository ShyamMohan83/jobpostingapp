package com.jobposting.jobpostingapp.model;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;

public class User {
    private Long userId;
    private String firstName;

    private String middleName;
    private String lastName;
    private String username;
    private String profileImageUrl;
    private LocalDate dateOfBirth;

    private List<UserRole> roles; // e.g., Admin, Recruiter
    private List<Email> emails; // All user emails
    private List<Address> address;
    private List<Phone> phones; // All user phones
    private String status;
    private String gender;
    private String maritalStatus;

    private UserAuthEntity authEntity;

    private  List<UserPreference> userPreference;



    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    public UserAuthEntity getAuthEntity() {
        return authEntity;
    }

    public void setAuthEntity(UserAuthEntity authEntity) {
        this.authEntity = authEntity;
    }

    public List<UserPreference> getUserPreference() {
        return userPreference;
    }

    public void setUserPreference(List<UserPreference> userPreference) {
        this.userPreference = userPreference;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public List<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRole> roles) {
        this.roles = roles;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }
    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
