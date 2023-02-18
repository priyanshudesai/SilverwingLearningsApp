package com.example.myapplication.Firebase;

public class data {
    String fname,lname,id;

    public data(String fname, String lname, String id) {
        this.fname = fname;
        this.lname = lname;
        this.id = id;
    }

    public data() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }


}
