package com.example.yyblumerandeiheller.takeandgo.model.entities;

import com.example.yyblumerandeiheller.takeandgo.model.utils.ConstantsAndEnums.gearboxMode;


public class CarModel {
    protected String modelCode;
    protected String companyName;
    protected String modelName;
    protected int engineCapacity;
    protected gearboxMode gearbox;
    protected int seats;


    public CarModel(String modelCode, String companyName, String modelName, int engineCapacity, gearboxMode gearbox, int seats){
        this.modelCode = modelCode;
        this.companyName = companyName;
        this.modelName = modelName;
        this.engineCapacity = engineCapacity;
        this.gearbox = gearbox;
        this.seats = seats;
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public gearboxMode getGearbox() {
        return gearbox;
    }

    public void setGearbox(gearboxMode gearbox) {
        this.gearbox = gearbox;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
