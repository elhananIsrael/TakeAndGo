package com.example.yyblumerandeiheller.takeandgo.model.datasource;

import android.content.ContentValues;
import android.util.Log;

import com.example.yyblumerandeiheller.takeandgo.model.backend.DataSource;
import com.example.yyblumerandeiheller.takeandgo.model.backend.GET_POST;
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

public class MySQL_DB_manager implements DataSource {


    private static final String WEB_URL = "http://elhanani.vlab.jct.ac.il/httpdocs/TakeAndGo/carsRent";

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
    public void addCustomer(Customer customer)
    {
        try
        {
            String url = WEB_URL + "/add_customer.php";

             /*   final ContentValues values = new ContentValues();

              values.put("Id", customer.getId());
                values.put("FirstName", customer.getFirstName());
                values.put("LastName", customer.getLastName());
                values.put("PhoneNum", customer.getPhoneNum());
                values.put("Email", customer.getEmail());
                values.put("CreditCardNum", customer.getCreditCardNum());*/

            String result =GET_POST.POST(url, ConstantsAndEnums.CustomerToContentValues(customer));
            long id = Long.parseLong(result);
            if (id > 0)
                SetUpdate();
            printLog("add customer:\n" + result);
        }
        catch (IOException e)
        {
            // printLog("addStudent Exception:\n" + e);
            Log.w(ConstantsAndEnums.Log.APP_LOG, e.getMessage());
        }
    }


    @Override
    public void addCar(Car car)
    {
        try {
            String url = WEB_URL + "/add_car.php";

             /* final ContentValues values = new ContentValues();

                values.put( "Model", car.getModelCode() );
                values.put( "ProductionDate", car.getProductionDate().toString() );
                values.put( "LicenseNumber", car.getLicenseNumber() );
                values.put( "Mileage", car.getMileage() );
                values.put( "HomeBranch", car.getHomeBranch() );
                values.put( "AverageCostPerDay", car.getAverageCostPerDay() );
                values.put( "Busy", car.getBusy() );*/

            GET_POST.POST(url, ConstantsAndEnums.CarToContentValues(car));
        }
        catch (Exception e)
        {
            Log.w(ConstantsAndEnums.Log.APP_LOG, e.getMessage());
        }
    }


    @Override
    public void addCarModel(CarModel carModel)
    {
        try
        {
            String url = WEB_URL + "/add_car_model.php";

              /*final ContentValues values = new ContentValues();

                values.put("CompanyName", carModel.getCompanyName());
                values.put("ModelName", carModel.getModelName());
                values.put("ModelCode", carModel.getModelCode());
                values.put("EngineVolume", carModel.getEngineVolume());
                values.put("Gearbox", carModel.getGearbox().toString());
                values.put("NumOfSeats", carModel.getNumOfSeats());
                values.put("CarKind", carModel.getCarKind().toString());*/

            GET_POST.POST(url, ConstantsAndEnums.CarModelToContentValues(carModel));
        }
        catch (Exception e)
        {
            Log.w(ConstantsAndEnums.Log.APP_LOG, e.getMessage());
        }
    }


    @Override
    public void addBranch(Branch branch)
    {
        try
        {
            String url = WEB_URL + "/add_branch.php";

             /* final ContentValues values = new ContentValues();

                values.put("BranchAddress", branch.getBranchAddress());
                values.put("CapacityOfCar", branch.getCapacityOfCar());
                values.put("BranchNum", branch.getBranchNum());
                values.put("AdministratorName", branch.getAdministratorName());*/


            GET_POST.POST(url, ConstantsAndEnums.BranchToContentValues(branch));
        }
        catch (Exception e)
        {
            Log.w(ConstantsAndEnums.Log.APP_LOG, e.getMessage());
        }
    }

    @Override
    public void addOrder(Order order) {

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
            String str = GET_POST.GET(WEB_URL + "/getCustomers.php");
            JSONArray array = new JSONObject(str).getJSONArray("Customers");

            for (int i = 0; i < array.length(); i++)
            {
                JSONObject jsonObject = array.getJSONObject(i);

                ContentValues contentValues = GET_POST.JsonToContentValues(jsonObject);
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

            String str = GET_POST.GET(WEB_URL + "/getCars.php");
            JSONArray array = new JSONObject(str).getJSONArray("Cars");


            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonObject = array.getJSONObject(i);

                ContentValues contentValues = GET_POST.JsonToContentValues(jsonObject);
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

            String str = GET_POST.GET(WEB_URL + "/getCarModels.php");
            JSONArray array = new JSONObject(str).getJSONArray("CarModels");


            for (int i = 0; i < array.length(); i++)
            {
                JSONObject jsonObject = array.getJSONObject(i);

                ContentValues contentValues = GET_POST.JsonToContentValues(jsonObject);
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

            String str = GET_POST.GET(WEB_URL + "/getBranches.php");
            JSONArray array = new JSONObject(str).getJSONArray("Branches");

            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonObject = array.getJSONObject(i);

                ContentValues contentValues = GET_POST.JsonToContentValues(jsonObject);
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
    public ArrayList<Order> allOrders() {
        return null;
    }
}
