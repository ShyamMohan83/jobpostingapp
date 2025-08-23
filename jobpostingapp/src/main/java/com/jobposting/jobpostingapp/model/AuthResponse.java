package com.jobposting.jobpostingapp.model;

public class AuthResponse {
    private String token;
    private String userName;
    private long userId;
    private long expiresAt;

    public AuthResponse(String token, String userName, long userId, long expiresAt) {
        this.token = token;
        this.userName = userName;
        this.userId = userId;
        this.expiresAt = expiresAt;
    }

    public long getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(long expiresAt) {
        this.expiresAt = expiresAt;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
