package com.example.yyblumerandeiheller.takeandgo.model.entities;

import java.text.SimpleDateFormat;


public class Car
{
    protected String modelCode;
    protected SimpleDateFormat productionDate;
    protected int mileage;
    protected String licenseNumber;
    protected String homeBranch;
    protected int averageCostPerDay;
    protected boolean busy;


    public Car(){ }

    public Car(String modelCode, SimpleDateFormat productionDate, String licenseNumber, int mileage, String homeBranch, int averageCostPerDay)
    {
       this.modelCode=modelCode;
        this.productionDate=productionDate;
        this.licenseNumber=licenseNumber;
        this.mileage=mileage;
        this.homeBranch=homeBranch;
        this.averageCostPerDay=averageCostPerDay;
        this.busy=false;
    }




    public String getModelCode(){
        return this.modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public SimpleDateFormat getProductionDate(){ return productionDate;}

    public void setProductionDate(SimpleDateFormat productionDate){ this.productionDate=productionDate;}

    public int getMileage() { return mileage; }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) { this.licenseNumber = licenseNumber; }

    public String getHomeBranch() {
        return homeBranch;
    }

    public void setHomeBranch(String homeBranch) {
        this.homeBranch = homeBranch;
    }

    public int getAverageCostPerDay(){return averageCostPerDay;}

    public void setAverageCostPerDay(int averageCostPerDay){this.averageCostPerDay=averageCostPerDay;}

    public boolean getBusy(){return busy;}

    public void setBusy(boolean busy){this.busy=busy;}



    public void ToString()
    {
        System.out.println("\n"+modelCode +"\n"+productionDate+"\n"+mileage+"\n"+licenseNumber+"\n"+homeBranch +"\n"+averageCostPerDay+"\n"+busy+"\n");
    }

}
