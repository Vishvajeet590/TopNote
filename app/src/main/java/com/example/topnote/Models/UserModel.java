package com.example.topnote.Models;

public class UserModel {
    int id;
    String Name;
    String Branch;

    public UserModel() {
    }

    public UserModel(int id, String name, String branch) {
        this.id = id;
        Name = name;
        Branch = branch;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getBranch() {
        return Branch;
    }

    public void setBranch(String branch) {
        Branch = branch;
    }
}
