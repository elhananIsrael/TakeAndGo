package com.example.yyblumerandeiheller.takeandgo.model.datasource;

import android.content.ContentValues;
import android.util.Log;

import com.example.yyblumerandeiheller.takeandgo.model.backend.DataSource;
import com.example.yyblumerandeiheller.takeandgo.model.backend.GET_POST;
import com.example.yyblumerandeiheller.takeandgo.model.entities.Branch;
import com.example.yyblumerandeiheller.takeandgo.model.entities.Car;
import com.example.yyblumerandeiheller.takeandgo.model.entities.CarModel;
import com.example.yyblumerandeiheller.takeandgo.model.entities.Customer;
import com.example.yyblumerandeiheller.takeandgo.model.utils.ConstantsAndEnums;

import java.io.IOException;
import java.util.ArrayList;

public class MySQL_DB_manager implements DataSource {


        private static final String WEB_URL = "http://elhanani.vlab.jct.ac.il/httpdocs/TakeAndGo/carsRent/carsRent/";
        protected ArrayList<Car> cars = new ArrayList<>();

    public void printLog(String message)
    {
        Log.d(this.getClass().getName(),"\n"+message);
    }
    public void printLog(Exception message)
    {
        Log.d(this.getClass().getName(),"Exception-->\n"+message);
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

                GET_POST.POST(url, ConstantsAndEnums.CustomerToContentValues(customer));
            }
            catch (IOException e)
            {
                // printLog("addStudent Exception:\n" + e);
                Log.w( ConstantsAndEnums.Log.APP_LOG, e.getMessage() );
            }
        }


        @Override
        public void addCar(Car car)
        {
            try
            {
                String url = WEB_URL + "/add_car.php" ;

             /* final ContentValues values = new ContentValues();

                values.put( "Model", car.getModelCode() );
                values.put( "ProductionDate", car.getProductionDate().toString() );
                values.put( "LicenseNumber", car.getLicenseNumber() );
                values.put( "Mileage", car.getMileage() );
                values.put( "HomeBranch", car.getHomeBranch() );
                values.put( "AverageCostPerDay", car.getAverageCostPerDay() );
                values.put( "Busy", car.getBusy() );*/

                GET_POST.POST( url, ConstantsAndEnums.CarToContentValues(car) );
            }
            catch (Exception e)
            {
                Log.w( ConstantsAndEnums.Log.APP_LOG, e.getMessage() );
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
                Log.w( ConstantsAndEnums.Log.APP_LOG, e.getMessage() );
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
                Log.w( ConstantsAndEnums.Log.APP_LOG, e.getMessage() );
            }
        }

    //////////////////////////////////////////////////////


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
