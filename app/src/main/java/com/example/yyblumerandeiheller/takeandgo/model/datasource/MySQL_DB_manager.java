package com.example.yyblumerandeiheller.takeandgo.model.datasource;

import android.content.ContentValues;
import android.util.Log;

import com.example.yyblumerandeiheller.takeandgo.model.backend.DataSource;
import com.example.yyblumerandeiheller.takeandgo.model.backend.PHP_Tools;
import com.example.yyblumerandeiheller.takeandgo.model.entities.Branch;
import com.example.yyblumerandeiheller.takeandgo.model.entities.Car;
import com.example.yyblumerandeiheller.takeandgo.model.entities.CarModel;
import com.example.yyblumerandeiheller.takeandgo.model.entities.Customer;
import com.example.yyblumerandeiheller.takeandgo.model.entities.Order;
import com.example.yyblumerandeiheller.takeandgo.model.utils.ConstantsAndEnums;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class MySQL_DB_manager implements DataSource
{
    private static final String WEB_URL = "http://elhanani.vlab.jct.ac.il/TakeAndGo/carsRent";

    private boolean updateFlag = false;

    public void printLog(String message)
    {
        Log.d(this.getClass().getName(), "\n" + message);
    }

    public void printLog(Exception message)
    {
        Log.d(this.getClass().getName(), "Exception-->\n" + message);
    }

    private void SetUpdate()
    {
        updateFlag = true;
    }



    @Override
    public long addCustomer(Customer customer)
    {
        try
        {
            String url = WEB_URL + "/add_customer.php";

            String result =PHP_Tools.POST(url, ConstantsAndEnums.CustomerToContentValues(customer));
            long id = Long.parseLong(result);
            if (id > 0)
                SetUpdate();
            printLog("add customer:\n" + result);
            return id;
        }
        catch (IOException e)
        {
            printLog("addCustomer Exception:\n" + e);
            return -1;
        }
    }


    @Override
    public long addCar(Car car)
    {
        try {
            String url = WEB_URL + "/add_car.php";

            String result = PHP_Tools.POST(url, ConstantsAndEnums.CarToContentValues(car));

            long id = Long.parseLong(result);
            if (id > 0)
                SetUpdate();
            printLog("add car:\n" + result);

            return id;

        }
        catch (Exception e)
        {
            printLog("addCar Exception:\n" + e);
            return -1;
        }
    }


    @Override
    public long addCarModel(CarModel carModel)
    {
        try
        {
            String url = WEB_URL + "/add_car_model.php";

            String result =  PHP_Tools.POST(url, ConstantsAndEnums.CarModelToContentValues(carModel));

            long id = Long.parseLong(result);
            if (id > 0)
                SetUpdate();
            printLog("add carModel:\n" + result);

            return id;
        }
        catch (Exception e)
        {
            printLog("addCarModel Exception:\n" + e);
            return -1;
        }
    }


    @Override
    public long addBranch(Branch branch)
    {
        try
        {
            String url = WEB_URL + "/add_branch.php";

            String result =  PHP_Tools.POST(url, ConstantsAndEnums.BranchToContentValues(branch));

            long id = Long.parseLong(result);
            if (id > 0)
                SetUpdate();
            printLog("add Branch:\n" + result);

            return id;
        }
        catch (Exception e)
        {
            printLog("addBranch Exception:\n" + e);
            return -1;
        }
    }

    @Override
    public long addOrder(Order order) {
        try
        {
            String url = WEB_URL + "/add_order.php";

            String result =  PHP_Tools.POST(url, ConstantsAndEnums.OrderToContentValues(order));

            long id = Long.parseLong(result);
            if (id > 0)
                SetUpdate();
            printLog("add order:\n" + result);

            return id;
        }
        catch (Exception e)
        {
            printLog("addOrder Exception:\n" + e);
            return -1;
        }
    }

    //////////////////////////////////////////////////////


    @Override
    public Customer isExistsCustomer(String id) { return null; }

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
    public Order isExistsOrder(String orderNum) {
        return null;
    }




    @Override
    public ArrayList<Customer> allCustomers()
    {
        ArrayList<Customer> customers = new ArrayList<>();

        try
        {
            String str = PHP_Tools.GET(WEB_URL + "/getCustomers.php");
            JSONArray array = new JSONObject(str).getJSONArray("Customers");

            for (int i = 0; i < array.length(); i++)
            {
                JSONObject jsonObject = array.getJSONObject(i);

                ContentValues contentValues = PHP_Tools.JsonToContentValues(jsonObject);
                Customer customer=ConstantsAndEnums.ContentValuesToCustomer(contentValues);

                customers.add(customer);
            }
            return customers;

        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }




    @Override
    public ArrayList<Car> allCars()
    {
        ArrayList<Car> cars = new ArrayList<>();

        try {

            String str = PHP_Tools.GET(WEB_URL + "/getCars.php");
            JSONArray array = new JSONObject(str).getJSONArray("Cars");


            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonObject = array.getJSONObject(i);

                ContentValues contentValues = PHP_Tools.JsonToContentValues(jsonObject);
                Car car = ConstantsAndEnums.ContentValuesToCar(contentValues);

                cars.add(car);
            }
            return cars;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    @Override
    public ArrayList<CarModel> allCarModels()
    {
        ArrayList<CarModel> carModels = new ArrayList<>();

        try
        {

            String str = PHP_Tools.GET(WEB_URL + "/getCarModels.php");
            JSONArray array = new JSONObject(str).getJSONArray("CarModels");


            for (int i = 0; i < array.length(); i++)
            {
                JSONObject jsonObject = array.getJSONObject(i);

                ContentValues contentValues = PHP_Tools.JsonToContentValues(jsonObject);
                CarModel carModel=ConstantsAndEnums.ContentValuesToCarModel(contentValues);

                carModels.add(carModel);
            }
            return carModels;

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    @Override
    public ArrayList<Branch> allBranches()
    {
        ArrayList<Branch> branches = new ArrayList<>();

        try
        {

            String str = PHP_Tools.GET(WEB_URL + "/getBranches.php");
            JSONArray array = new JSONObject(str).getJSONArray("Branches");

            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonObject = array.getJSONObject(i);

                ContentValues contentValues = PHP_Tools.JsonToContentValues(jsonObject);
                Branch branch=ConstantsAndEnums.ContentValuesToBranch(contentValues);

                branches.add(branch);
            }
            return branches;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public ArrayList<Order> allOrders()
    {
        ArrayList<Order> orders = new ArrayList<>();

        try
        {
            String str = PHP_Tools.GET(WEB_URL + "/getOrders.php");
            JSONArray array = new JSONObject(str).getJSONArray("Orders");

            for (int i = 0; i < array.length(); i++)
            {
                JSONObject jsonObject = array.getJSONObject(i);

                ContentValues contentValues = PHP_Tools.JsonToContentValues(jsonObject);
                Order order=ConstantsAndEnums.ContentValuesToOrder(contentValues);

                orders.add(order);
            }
            return orders;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
