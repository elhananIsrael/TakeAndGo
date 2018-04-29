package com.example.yyblumerandeiheller.takeandgo.model.backend;

import java.util.ArrayList;
import com.example.yyblumerandeiheller.takeandgo.model.entities.Customer;
import com.example.yyblumerandeiheller.takeandgo.model.entities.Car;
import com.example.yyblumerandeiheller.takeandgo.model.entities.CarModel;
import com.example.yyblumerandeiheller.takeandgo.model.entities.Branch;


public interface DataSource {

    //add:
    void addCustomer(Customer customer);
    void addCar(Car car);
    void addCarModel(CarModel carModel);
    void addBranch(Branch branch);

    //isExists:
    Customer isExistsCustomer(String id);
    Car isExistsCar(String carNumber);
    CarModel isExistsCarModel(String modelCode);
    Branch isExistsBranch(String branchId);

    //allList:
    ArrayList<Customer> allCustomers();
    ArrayList<Car> allCars();
    ArrayList<CarModel> allCarModels();
    ArrayList<Branch> allBranches();
////////////
}
