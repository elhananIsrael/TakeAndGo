package com.example.yyblumerandeiheller.takeandgo.model.entities;

import com.example.yyblumerandeiheller.takeandgo.model.utils.ConstantsAndEnums;
import com.example.yyblumerandeiheller.takeandgo.model.utils.ConstantsAndEnums.gearboxMode;
import com.example.yyblumerandeiheller.takeandgo.model.utils.ConstantsAndEnums.carKind;


public class CarModel
{
    protected String CompanyName;
    protected String ModelName;
    protected String ModelCode;
    protected int EngineVolume;
    protected gearboxMode Gearbox;
    protected int NumOfSeats;
    protected carKind CarKind;


    public CarModel(String companyName, String modelName, String modelCode, int engineVolume, gearboxMode gearbox, int seats, carKind kind)
    {
        this.CompanyName = companyName;
        this.ModelName = modelName;
        this.ModelCode = modelCode;
        this.EngineVolume = engineVolume;
        this.Gearbox = gearbox;
        this.NumOfSeats = seats;
        this.CarKind=kind;
    }


    public String getCompanyName() { return CompanyName; }

    public void setCompanyName(String companyName) { this.CompanyName = companyName; }

    public String getModelName() { return ModelName; }

    public void setModelName(String modelName) { this.ModelName = modelName; }

    public String getModelCode() { return ModelCode; }

    public void setModelCode(String modelCode) {
        this.ModelCode = modelCode;
    }

    public int getEngineCapacity() {
        return EngineVolume;
    }

    public void setEngineCapacity(int engineVolume) {
        this.EngineVolume = engineVolume;
    }

    public gearboxMode getGearbox() { return Gearbox; }

    public void setGearbox(gearboxMode gearbox) {
        this.Gearbox = gearbox;
    }

    public int getSeats() {
        return NumOfSeats;
    }

    public void setSeats(int numOfSeats) {
        this.NumOfSeats = numOfSeats;
    }

    public carKind getCarKind(){return CarKind;}

    public void setCarKind(carKind kind){CarKind=kind;}
}
