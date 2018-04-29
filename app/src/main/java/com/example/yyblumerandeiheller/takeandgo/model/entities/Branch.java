package com.example.yyblumerandeiheller.takeandgo.model.entities;

public class Branch {
    protected String address;
    protected int parkingSpacesNum;
    protected String branchId;

    public Branch(String address, int parkingSpacesNum, String branchId) {
        this.address = address;
        this.parkingSpacesNum = parkingSpacesNum;
        this.branchId = branchId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getParkingSpacesNum() {
        return parkingSpacesNum;
    }

    public void setParkingSpacesNum(int parkingSpacesNum) {
        this.parkingSpacesNum = parkingSpacesNum;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }
}
