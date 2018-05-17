package com.example.yyblumerandeiheller.takeandgo.model.entities;

public class Branch {
    protected String BranchAddress;
    protected int CapacityOfCar;
    protected String BranchNum;
    protected String AdministratorName;

    public Branch(String address, int capacityOfCar, String branchNum, String administratorName)
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

    public String getBranchId() {
        return BranchNum;
    }

    public void setBranchId(String branchNum) {
        this.BranchNum = branchNum;
    }
}
