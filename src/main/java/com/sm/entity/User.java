package com.sm.entity;

public class User {
    private Integer id;

    private String email;

    private String userName;

    private String passWord;

    public User(Integer id, String email, String userName, String passWord) {
        this.id = id;
        this.email = email;
        this.userName = userName;
        this.passWord = passWord;
    }

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord == null ? null : passWord.trim();
    }
}