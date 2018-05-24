package com.example.yyblumerandeiheller.takeandgo.model.backend;

import java.util.ArrayList;
import com.example.yyblumerandeiheller.takeandgo.model.entities.*;



public interface DataSource {

    //add:
    void addCustomer(Customer customer);
    void addCar(Car car);
    void addCarModel(CarModel carModel);
    void addBranch(Branch branch);
    void addOrder(Order order);


    //isExists:
    Customer isExistsCustomer(String id);
    Car isExistsCar(String carNumber);
    CarModel isExistsCarModel(String modelCode);
    Branch isExistsBranch(String branchId);
    Order isExistsOrder(String orderNum);


    //allList:
    ArrayList<Customer> allCustomers();
    ArrayList<Car> allCars();
    ArrayList<CarModel> allCarModels();
    ArrayList<Branch> allBranches();
    ArrayList<Order> allOrders();

////////////
}
