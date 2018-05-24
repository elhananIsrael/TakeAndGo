package com.example.yyblumerandeiheller.takeandgo.model.datasource;

import java.util.ArrayList;
import com.example.yyblumerandeiheller.takeandgo.model.backend.DataSource;
import com.example.yyblumerandeiheller.takeandgo.model.entities.Customer;
import com.example.yyblumerandeiheller.takeandgo.model.entities.Car;
import com.example.yyblumerandeiheller.takeandgo.model.entities.CarModel;
import com.example.yyblumerandeiheller.takeandgo.model.entities.Branch;

public class ListsDataSource implements DataSource {

    protected ArrayList<Customer> customers;
    protected ArrayList<Car> cars;
    protected ArrayList<CarModel> carModels;
    protected ArrayList<Branch> branches;


    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public ArrayList<CarModel> getCarModels() {
        return carModels;
    }

    public ArrayList<Branch> getBranches() {
        return branches;
    }

    public ListsDataSource() {
        customers = new ArrayList<>();
        cars = new ArrayList<>();
        carModels = new ArrayList<>();
        branches = new ArrayList<>();
    }

    @Override
    public void addCustomer(Customer customer) {
        customers.add( customer );
    }
    public void addCar(Car car) {
        cars.add( car );
    }
    public void addCarModel(CarModel carModel) {
        carModels.add( carModel );
    }
    public void addBranch(Branch branch) {
        branches.add( branch );
    }

    @Override
    public Customer isExistsCustomer(String id) {
        for( Customer customer : customers)
            if (customer.getId().equals( id ))
                return  customer;
        return null;
    }

    @Override
    public Car isExistsCar(String carNumber) {
        for( Car car : cars)
            if (car.getLicenseNumber().equals( carNumber ))
                return  car;
        return null;
    }

    @Override
    public CarModel isExistsCarModel(String modelCode) {
        for( CarModel carModel : carModels)
            if (carModel.getModelCode().equals( modelCode ))
                return  carModel;
        return null;
    }

    @Override
    public Branch isExistsBranch(String branchId) {
        for( Branch branch : branches)
            if (branch.getBranchNum().equals( branchId ))
                return  branch;
        return null;    }

    @Override
    public ArrayList<Customer> allCustomers() {
        return this.customers;
    }

    @Override
    public ArrayList<Car> allCars() {
        return this.cars;
    }

    @Override
    public ArrayList<CarModel> allCarModels() {
        return this.carModels;
    }

    @Override
    public ArrayList<Branch> allBranches() {
        return this.branches;
    }
}
