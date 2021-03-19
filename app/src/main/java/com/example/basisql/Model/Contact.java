package com.example.basisql.Model;

public class Contact {
    private int id;
    private String name;
    private String email;

    public Contact(String name, String email, int id) {
        this.name = name;
        this.email=email;
        this.id=id;
    }
    public Contact(String name, String email) {
        this.name = name;
        this.email=email;
    }
    public Contact() {

    }
    public void setName (String name){
        this.name = name;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
    public int getId(){
        return  id;
    }
}
