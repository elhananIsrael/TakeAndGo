package com.example.yyblumerandeiheller.takeandgo.model.entities;

public class Customer
{
    protected String Id;
    protected String FirstName;
    protected String LastName;
    protected String PhoneNum;
    protected String Email;
    protected String CreditCardNum;


    public Customer(String id, String firstName, String lastName, String phoneNumber, String email, String creditCardNum) {
        this.Id = id;
        this.FirstName = firstName;
        this.LastName = lastName;
        this.PhoneNum = phoneNumber;
        this.Email = email;
        this.CreditCardNum = creditCardNum;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        this.Id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        this.FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        this.LastName = lastName;
    }

    public String getPhoneNum() {
        return PhoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.PhoneNum = phoneNum;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getCreditCardNum() { return CreditCardNum; }

    public void setCreditCardNum(String creditCardNum) {
        this.CreditCardNum = creditCardNum;
    }
}
