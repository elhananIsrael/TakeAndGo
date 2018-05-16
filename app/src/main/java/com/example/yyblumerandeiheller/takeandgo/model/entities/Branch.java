package com.example.yyblumerandeiheller.takeandgo.model.entities;

public class Branch {
    protected String BranchAddress;
    protected int CapacityOfCar;
    protected int BranchNum;
    protected String AdministratorName;

    public Branch(String address, int capacityOfCar, int branchNum, String administratorName)
    {
        this.BranchAddress = address;
        this.CapacityOfCar = capacityOfCar;
        this.BranchNum = branchNum;
        this.AdministratorName=administratorName;
    }

    public String getAddress() {
        return BranchAddress;
    }

    public void setAddress(String address) {
        this.BranchAddress = address;
    }

    public int getCapacityOfCar() {
        return CapacityOfCar;
    }

    public void setParkingSpacesNum(int parkingSpacesNum) {
        this.CapacityOfCar = parkingSpacesNum;
    }

    public int getBranchId() {
        return BranchNum;
    }

    public void setBranchId(int branchNum) {
        this.BranchNum = branchNum;
    }
}
