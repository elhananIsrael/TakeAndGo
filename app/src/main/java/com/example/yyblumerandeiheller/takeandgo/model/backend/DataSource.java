package com.example.yyblumerandeiheller.takeandgo.model.backend;

import java.util.ArrayList;
import com.example.yyblumerandeiheller.takeandgo.model.entities.*;



public interface DataSource {

    //add:
    long addCustomer(Customer customer);
    long addCar(Car car);
    long addCarModel(CarModel carModel);
    long addBranch(Branch branch);
    long addOrder(Order order);


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


    //extra
    ArrayList<Car> allCarAvailable();


////////////
}
