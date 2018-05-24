package com.example.yyblumerandeiheller.takeandgo.model.entities;

import java.util.Date;


public class Car
{
    protected String modelCode;
    protected Date productionDate;
    protected int mileage;
    protected String licenseNumber;
    protected String homeBranch;
    protected int averageCostPerDay;
    protected boolean busy;


    public Car(String modelCode, Date productionDate, String licenseNumber, int mileage, String homeBranch, int averageCostPerDay)
    {
        this.modelCode=modelCode;
        this.productionDate=productionDate;
        this.licenseNumber=licenseNumber;
        this.mileage=mileage;
        this.homeBranch=homeBranch;
        this.averageCostPerDay=averageCostPerDay;
        this.busy=false;
    }

    public Car() {

    }


    public String getModelCode() {
        return this.modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public Date getProductionDate(){ return productionDate;}

    public void setProductionDate(Date productionDate){ this.productionDate=productionDate;}

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
}
