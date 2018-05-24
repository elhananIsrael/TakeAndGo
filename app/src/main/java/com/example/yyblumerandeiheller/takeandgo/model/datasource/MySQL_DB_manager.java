package com.example.yyblumerandeiheller.takeandgo.model.datasource;

import com.example.yyblumerandeiheller.takeandgo.model.backend.DataSource;
import com.example.yyblumerandeiheller.takeandgo.model.entities.Branch;
import com.example.yyblumerandeiheller.takeandgo.model.entities.Car;
import com.example.yyblumerandeiheller.takeandgo.model.entities.CarModel;
import com.example.yyblumerandeiheller.takeandgo.model.entities.Customer;

import java.util.ArrayList;

public class MySQL_DB_manager implements DataSource {
    @Override
    public void addCustomer(Customer customer) {

    }

    @Override
    public void addCar(Car car) {

    }

    @Override
    public void addCarModel(CarModel carModel) {

    }

    @Override
    public void addBranch(Branch branch) {

    }

    @Override
    public Customer isExistsCustomer(String id) {
        return null;
    }

    @Override
    public Car isExistsCar(String carNumber) {
        return null;
    }

    @Override
    public CarModel isExistsCarModel(String modelCode) {
        return null;
    }

    @Override
    public Branch isExistsBranch(String branchId) {
        return null;
    }

    @Override
    public ArrayList<Customer> allCustomers() {
        return null;
    }

    @Override
    public ArrayList<Car> allCars() {
        return null;
    }

    @Override
    public ArrayList<CarModel> allCarModels() {
        return null;
    }

    @Override
    public ArrayList<Branch> allBranches() {
        return null;
    }
}
