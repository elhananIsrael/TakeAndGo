package com.example.yyblumerandeiheller.takeandgo.model.entities;

public class Customer
{
    protected String id;
    protected String firstName;
    protected String lastName;
    protected String phoneNum;
    protected String email;
    protected String creditCardNum;
    protected String password ;


    public Customer(String id, String firstName, String lastName, String phoneNumber, String email, String creditCardNum, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNum = phoneNumber;
        this.email = email;
        this.creditCardNum = creditCardNum;
        this.password= password;
    }

    public Customer() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreditCardNum() { return creditCardNum; }

    public void setCreditCardNum(String creditCardNum) {
        this.creditCardNum = creditCardNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String ToString()
    {
        return "\n"+id +"\n"+firstName+"\n"+lastName+"\n"+phoneNum+"\n"+email +"\n"+creditCardNum+"\n";
    }

}
