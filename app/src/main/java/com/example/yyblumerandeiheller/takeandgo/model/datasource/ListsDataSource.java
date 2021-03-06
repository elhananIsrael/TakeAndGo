package com.example.yyblumerandeiheller.takeandgo.model.datasource;

import java.util.ArrayList;
import com.example.yyblumerandeiheller.takeandgo.model.backend.DataSource;
import com.example.yyblumerandeiheller.takeandgo.model.entities.Customer;
import com.example.yyblumerandeiheller.takeandgo.model.entities.Car;
import com.example.yyblumerandeiheller.takeandgo.model.entities.CarModel;
import com.example.yyblumerandeiheller.takeandgo.model.entities.Branch;
import com.example.yyblumerandeiheller.takeandgo.model.entities.Order;

public class ListsDataSource implements DataSource {

    protected ArrayList<Customer> customers;
    protected ArrayList<Car> cars;
    protected ArrayList<CarModel> carModels;
    protected ArrayList<Branch> branches;
    protected ArrayList<Order> orders;



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

    public ArrayList<Order> getOrders() {
        return orders;
    }


    public ListsDataSource() {
        customers = new ArrayList<>();
        cars = new ArrayList<>();
        carModels = new ArrayList<>();
        branches = new ArrayList<>();
        orders=new ArrayList<>();
    }

    @Override
    public long addCustomer(Customer customer) {
        customers.add( customer );
        return Long.parseLong(customer.getId());
    }
    public long addCar(Car car) {
        cars.add( car );
        return Long.parseLong(car.getLicenseNumber());
    }
    public long addCarModel(CarModel carModel) {
        carModels.add( carModel );
        return Long.parseLong(carModel.getModelCode());
    }
    public long addBranch(Branch branch) {
        branches.add( branch );
        return Long.parseLong(branch.getBranchNum());
    }

    @Override
    public long addOrder(Order order) {
        orders.add(order);
        return Long.parseLong(order.getOrderNum());
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
    public Order isExistsOrder(String orderNum) {
        for( Order order : orders)
            if (order.getOrderNum().equals( orderNum ))
                return  order;
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

    @Override
    public ArrayList<Order> allOrders() {
        return this.orders;
    }

    @Override
    public ArrayList<Car> allCarAvailable() {
        return null;
    }
}
