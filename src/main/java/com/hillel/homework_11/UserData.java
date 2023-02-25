package com.hillel.homework_11;

public class UserData {

    private String name;
    private String email;
    private String age;

    public UserData() {
    }

    public UserData(String name, String email, String age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAge() {
        return age;
    }

    public String getPeopleInfo() {
        return name + '\n' + email + '\n' + age + '\n';
    }
}