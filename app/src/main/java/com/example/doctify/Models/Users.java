package com.example.doctify.Models;

public class Users {

    String username,mail,password,phone,userId,organization,requirement,resume;


    public Users(String username, String mail, String password, String phone, String userId, String organization, String requirement, String resume) {
        this.username = username;
        this.mail = mail;
        this.password = password;
        this.phone = phone;
        this.userId = userId;
        this.organization = organization;
        this.requirement = requirement;
        this.resume = resume;
    }


    public Users(){}

    public Users(String username, String mail, String password, String phone) {
        this.username = username;
        this.mail = mail;
        this.password = password;
        this.phone = phone;

    }

    public Users(String username, String mail, String password, String phone,  String organization,String requirement) {
        this.username = username;
        this.mail = mail;
        this.password = password;
        this.phone = phone;
        this.organization = organization;
        this.requirement = requirement;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }
}
