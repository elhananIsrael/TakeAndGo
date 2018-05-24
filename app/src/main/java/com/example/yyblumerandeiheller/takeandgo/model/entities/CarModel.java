package com.example.yyblumerandeiheller.takeandgo.model.entities;

import com.example.yyblumerandeiheller.takeandgo.model.utils.ConstantsAndEnums;
import com.example.yyblumerandeiheller.takeandgo.model.utils.ConstantsAndEnums.gearboxMode;
import com.example.yyblumerandeiheller.takeandgo.model.utils.ConstantsAndEnums.carKind;


public class CarModel
{
    protected String companyName;
    protected String modelName;
    protected String modelCode;
    protected int engineVolume;
    protected gearboxMode gearbox;
    protected int numOfSeats;
    protected carKind carKind;


    public CarModel(String companyName, String modelName, String modelCode, int engineVolume, gearboxMode gearbox, int numOfSeats, carKind carKind)
    {
        this.companyName = companyName;
        this.modelName = modelName;
        this.modelCode = modelCode;
        this.engineVolume = engineVolume;
        this.gearbox = gearbox;
        this.numOfSeats = numOfSeats;
        this.carKind=carKind;
    }

    public CarModel() {

    }


    public String getCompanyName() { return companyName; }

    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public String getModelName() { return modelName; }

    public void setModelName(String modelName) { this.modelName = modelName; }

    public String getModelCode() { return modelCode; }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public int getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(int engineVolume) {
        this.engineVolume = engineVolume;
    }

    public gearboxMode getGearbox() { return gearbox; }

    public void setGearbox(gearboxMode gearbox) {
        this.gearbox = gearbox;
    }

    public int getNumOfSeats() {
        return numOfSeats;
    }

    public void setNumOfSeats(int numOfSeats) {
        this.numOfSeats = numOfSeats;
    }

    public carKind getCarKind(){return carKind;}

    public void setCarKind(carKind carKind){this.carKind=carKind;}
}
