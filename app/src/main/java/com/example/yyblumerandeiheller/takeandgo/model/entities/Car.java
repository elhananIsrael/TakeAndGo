package com.example.yyblumerandeiheller.takeandgo.model.entities;

import com.example.yyblumerandeiheller.takeandgo.model.utils.ConstantsAndEnums.carKind;


public class Car {
    protected String homeBranch;
    protected carKind kindOfCar;
    protected int kilometreSize;
    protected String carNumber;

    public Car(String homeBranch, carKind kindOfCar, int kilometreSize, String carNumber){
        this.homeBranch = homeBranch;
        this.kindOfCar = kindOfCar;
        this.kilometreSize = kilometreSize;
        this.carNumber = carNumber;
    }

    public String getHomeBranch() {
        return homeBranch;
    }

    public void setHomeBranch(String homeBranch) {
        this.homeBranch = homeBranch;
    }

    public carKind getKindOfCar() {
        return kindOfCar;
    }

    public void setKindOfCar(carKind kindOfCar) {
        this.kindOfCar = kindOfCar;
    }

    public int getKilometreSize() {
        return kilometreSize;
    }

    public void setKilometreSize(int kilometreSize) {
        this.kilometreSize = kilometreSize;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }
}
