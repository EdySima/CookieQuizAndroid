package com.example.cookiequiz;

public class UsersData {

    String fullname, email;
    int cookies;

    public UsersData() {
    }

    public UsersData(String fullname, String email, int cookies) {
        this.fullname = fullname;
        this.email = email;
        this.cookies = cookies;
    }

    //region Setters and Getters
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCookies() {
        return cookies;
    }

    public void setCookies(int cookies) {
        this.cookies = cookies;
    }
    //endregion
}
