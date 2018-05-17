package com.example.yyblumerandeiheller.takeandgo.model.entities;

import java.util.Date;


public class Car
{
    protected String Model;
    protected Date ProductionDate;
    protected int Mileage;
    protected String LicenseNumber;
    protected String HomeBranch;
    protected int AverageCostPerDay;
    protected boolean Busy;


    public Car(String model, Date productionDate, String licenseNumber, int mileage, String homeBranch, int averageCostPerDay)
    {
        this.Model=model;
        this.ProductionDate=productionDate;
        this.LicenseNumber=licenseNumber;
        this.Mileage=mileage;
        this.HomeBranch=homeBranch;
        this.AverageCostPerDay=averageCostPerDay;
        this.Busy=false;
    }


    public String getModel() {
        return Model;
    }

    public void setCarModel(String carModel) {
        this.Model = carModel;
    }

    public Date getProductionDate(){ return ProductionDate;}

    public void setProductionDate(Date productionDate){ this.ProductionDate=productionDate;}

    public int getMileage() { return Mileage; }

    public void setMileage(int mileage) {
        this.Mileage = mileage;
    }

    public String getLicenseNumber() {
        return LicenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) { this.LicenseNumber = licenseNumber; }

    public String getHomeBranch() {
        return HomeBranch;
    }

    public void setHomeBranch(String homeBranch) {
        this.HomeBranch = homeBranch;
    }

    public int getAverageCostPerDay(){return AverageCostPerDay;}

    public void setAverageCostPerDay(int averageCostPerDay){this.AverageCostPerDay=averageCostPerDay;}

    public boolean getBusy(){return Busy;}

    public void setBusy(boolean busy){this.Busy=busy;}
}
