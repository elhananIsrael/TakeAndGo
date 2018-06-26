package com.example.yyblumerandeiheller.takeandgo.controller;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yyblumerandeiheller.takeandgo.R;
import com.example.yyblumerandeiheller.takeandgo.model.backend.FactoryMethod;
import com.example.yyblumerandeiheller.takeandgo.model.datasource.MySQL_DB_manager;
import com.example.yyblumerandeiheller.takeandgo.model.entities.Branch;
import com.example.yyblumerandeiheller.takeandgo.model.entities.Car;
import com.example.yyblumerandeiheller.takeandgo.model.entities.CarModel;
import com.example.yyblumerandeiheller.takeandgo.model.entities.Customer;
import com.example.yyblumerandeiheller.takeandgo.model.entities.Order;
import com.example.yyblumerandeiheller.takeandgo.model.utils.ConstantsAndEnums;

import java.util.ArrayList;

public class PrintLists extends AppCompatActivity {

    MySQL_DB_manager factory=new MySQL_DB_manager();

    Spinner spinner;
    //TextView textView4;
    ListView ListOfItems;

    static String temp=new String("");
     ArrayAdapter<Branch> branchArrayAdapter;
    ArrayAdapter<Car> carArrayAdapter;
    ArrayAdapter<CarModel> carModelArrayAdapter;
    ArrayAdapter<Customer> customerArrayAdapter;
    ArrayAdapter<Order> orderArrayAdapter;




    static ArrayList<Branch> branchArrayList=new ArrayList<>();
    static ArrayList<Car> carArrayList=new ArrayList<>();
    static ArrayList<CarModel> carModelArrayList=new ArrayList<>();
    static ArrayList<Customer> customerArrayList=new ArrayList<>();
    static ArrayList<Order> orderArrayList=new ArrayList<>();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print_lists);

        spinner=(Spinner) findViewById(R.id.spinner);
        ListOfItems =  (ListView) findViewById( R.id.listOfItems );

        //  textView4=(TextView)findViewById(R.id.textView4);
       // textView4.setMovementMethod(new ScrollingMovementMethod());
        CreateBranchAdapter();
        CreateCarAdapter();
        CreateCarModelAdapter();
        CreateCustomerAdapter();
        CreateOrderAdapter();


        ArrayList<String> menu=new ArrayList<>();
        menu.add("Branches");
        menu.add("Cars");
        menu.add("CarModels");
        menu.add("Customers");
        menu.add("Orders");
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, menu));

    }



    @SuppressLint("StaticFieldLeak")
    private void CreateBranchAdapter() {
        branchArrayAdapter = new ArrayAdapter<Branch>(this, R.layout.branch_row, branchArrayList) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                if (convertView == null) {
                    convertView = View.inflate(PrintLists.this, R.layout.branch_row, null);
                }

                Branch branch = (Branch) this.getItem(position);
                TextView branchAddress = (TextView) convertView.findViewById(R.id.branchAddress);
                TextView capacityOfCar = (TextView) convertView.findViewById(R.id.capacityOfCar);
                TextView branchNum = (TextView) convertView.findViewById(R.id.branchNum);
                TextView administratorName = (TextView) convertView.findViewById(R.id.administratorName);

                branchAddress.setText("Branch Address:" + branch.getBranchAddress());
                capacityOfCar.setText("Capacity Of Car:" + branch.getCapacityOfCar());
                branchNum.setText("Branch Number: " + branch.getBranchNum());
                administratorName.setText("Administrator Name:" + branch.getAdministratorName());
                return convertView;
            }
        };
    }

    @SuppressLint("StaticFieldLeak")
    private void CreateCarAdapter() {
        carArrayAdapter = new ArrayAdapter<Car>(this, R.layout.car_row, carArrayList) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                if (convertView == null) {
                    convertView = View.inflate(PrintLists.this, R.layout.car_row, null);
                }


                Car car = (Car) this.getItem(position);
                TextView modelCode = (TextView) convertView.findViewById(R.id.modelCode);
                TextView productionDate = (TextView) convertView.findViewById(R.id.productionDate);
                TextView mileage = (TextView) convertView.findViewById(R.id.mileage);
                TextView licenseNumber = (TextView) convertView.findViewById(R.id.licenseNumber);
                TextView homeBranch = (TextView) convertView.findViewById(R.id.homeBranch);
                TextView averageCostPerDay = (TextView) convertView.findViewById(R.id.averageCostPerDay);
                TextView busy = (TextView) convertView.findViewById(R.id.busy);


                modelCode.setText("Model Code:" + car.getModelCode());
                productionDate.setText("Production Date:" + car.getProductionDate());
                mileage.setText("Mileage: " + car.getMileage());
                licenseNumber.setText("License Number:" + car.getLicenseNumber());
                homeBranch.setText("Home Branch:" + car.getHomeBranch());
                averageCostPerDay.setText("Average Cost Per Day: " + car.getAverageCostPerDay());
                busy.setText("Busy:" + car.getBusy());
                return convertView;
            }
        };
    }


    @SuppressLint("StaticFieldLeak")
    private void CreateCarModelAdapter() {
        carModelArrayAdapter = new ArrayAdapter<CarModel>(this, R.layout.carmodel_row, carModelArrayList) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                if (convertView == null) {
                    convertView = View.inflate(PrintLists.this, R.layout.carmodel_row, null);
                }


                CarModel carModel = (CarModel) this.getItem(position);
                TextView companyName = (TextView) convertView.findViewById(R.id.companyName);
                TextView modelName = (TextView) convertView.findViewById(R.id.modelName);
                TextView modelCode = (TextView) convertView.findViewById(R.id.modelCode);
                TextView engineVolume = (TextView) convertView.findViewById(R.id.engineVolume);
                TextView gearbox = (TextView) convertView.findViewById(R.id.gearbox);
                TextView numOfSeats = (TextView) convertView.findViewById(R.id.numOfSeats);
                TextView carKind = (TextView) convertView.findViewById(R.id.carKind);


                companyName.setText("Company Name:" + carModel.getCompanyName());
                modelName.setText("Model Name:" + carModel.getModelName());
                modelCode.setText("Model Code: " + carModel.getModelCode());
                engineVolume.setText("Engine Volume:" + carModel.getEngineVolume());
                gearbox.setText("Gearbox:" + carModel.getGearbox());
                numOfSeats.setText("Number Of Seats: " + carModel.getNumOfSeats());
                carKind.setText("Car Kind:" + carModel.getCarKind());
                return convertView;
            }
        };
    }

    @SuppressLint("StaticFieldLeak")
    private void CreateCustomerAdapter() {
        customerArrayAdapter = new ArrayAdapter<Customer>(this, R.layout.customer_row, customerArrayList) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                if (convertView == null) {
                    convertView = View.inflate(PrintLists.this, R.layout.customer_row, null);
                }


                Customer customer = (Customer) this.getItem(position);
                TextView id = (TextView) convertView.findViewById(R.id.id);
                TextView firstName = (TextView) convertView.findViewById(R.id.firstName);
                TextView lastName = (TextView) convertView.findViewById(R.id.lastName);
                TextView phoneNum = (TextView) convertView.findViewById(R.id.phoneNum);
                TextView email = (TextView) convertView.findViewById(R.id.email);
                TextView creditCardNum = (TextView) convertView.findViewById(R.id.creditCardNum);


                id.setText("Id:" + customer.getId());
                firstName.setText("First Name:" + customer.getFirstName());
                lastName.setText("Last Name: " + customer.getLastName());
                phoneNum.setText("Phone Number:" + customer.getPhoneNum());
                email.setText("Email:" + customer.getEmail());
                creditCardNum.setText("Credit Card Number: " + customer.getCreditCardNum());
                return convertView;
            }
        };
    }


    @SuppressLint("StaticFieldLeak")
    private void CreateOrderAdapter() {
        orderArrayAdapter = new ArrayAdapter<Order>(this, R.layout.order_row, orderArrayList) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                if (convertView == null) {
                    convertView = View.inflate(PrintLists.this, R.layout.order_row, null);
                }



                Order order = (Order) this.getItem(position);
                TextView customerNum = (TextView) convertView.findViewById(R.id.customerNum);
                TextView modeOfOrder = (TextView) convertView.findViewById(R.id.modeOfOrder);
                TextView carNumber = (TextView) convertView.findViewById(R.id.carNumber);
                TextView rentStartDate = (TextView) convertView.findViewById(R.id.rentStartDate);
                TextView rentEndDate = (TextView) convertView.findViewById(R.id.rentEndDate);
                TextView kilometresAtStart = (TextView) convertView.findViewById(R.id.kilometresAtStart);
                TextView kilometresAtEnd = (TextView) convertView.findViewById(R.id.kilometresAtEnd);
                TextView isInsertDelek = (TextView) convertView.findViewById(R.id.isInsertDelek);
                TextView howMuchDelekInsert = (TextView) convertView.findViewById(R.id.howMuchDelekInsert);
                TextView howMuchNeedPay = (TextView) convertView.findViewById(R.id.howMuchNeedPay);
                TextView orderNum = (TextView) convertView.findViewById(R.id.orderNum);



                customerNum.setText("Customer Number:" + order.getCustomerNum());
                modeOfOrder.setText("Mode Of Order:" + order.getModeOfOrder());
                carNumber.setText("Car Number: " + order.getCarNumber());
                rentStartDate.setText("Rent Start Date:" + order.getRentStartDate());
                rentEndDate.setText("Rent End Date:" + order.getRentEndDate());
                kilometresAtStart.setText("Kilometres At Start: " + order.getKilometresAtStart());
                kilometresAtEnd.setText("Kilometres At End:" + order.getKilometresAtEnd());
                isInsertDelek.setText("Is Insert Delek:" + order.getIsInsertDelek());
                howMuchDelekInsert.setText("How Much Delek Insert:" + order.getHowMuchDelekInsert());
                howMuchNeedPay.setText("How Much Need Pay:" + order.getHowMuchNeedPay());
                orderNum.setText("Order Number:" + order.getOrderNum());
                return convertView;
            }
        };
    }

    public void display_lists(View view)
    {
        try {
            switch (spinner.getSelectedItem().toString()) {
                case "Branches":

                    temp="";

                new  AsyncTask<Void, Void, Void>() {


                    @Override
                        protected Void doInBackground(Void... params) {
                        if(branchArrayList==null)
                            branchArrayList= new ArrayList<>();
                        branchArrayList.clear();
                        branchArrayList=FactoryMethod.getDataSource(FactoryMethod.Type.MySQL).allBranches();
                           // for (Branch item : branchArrayList) {
                          //      temp+=item.ToString();
                        //    }

                            return null;

                        }

                    @Override
                    protected void onPostExecute(Void aVoid) {
                        try {
                        super.onPostExecute(aVoid);
                            if(branchArrayList==null)
                                branchArrayList= new ArrayList<>();
                        branchArrayAdapter.notifyDataSetChanged();
                      //  textView4.setText(temp);
                            ListOfItems.setAdapter(branchArrayAdapter);
                        } catch (Exception e) {
                            Log.w(ConstantsAndEnums.Log.APP_LOG, e.getMessage() );
                            Toast.makeText( PrintLists.this, e.getMessage(), Toast.LENGTH_SHORT ).show();
                        }
                    }


                    }.execute();


                    break;

                case "Cars":

                    temp="";


                    new AsyncTask<Void, Void, Void>() {


                        @Override
                        protected Void doInBackground(Void... params) {
                            if(carArrayList==null)
                                carArrayList= new ArrayList<>();
                            carArrayList.clear();
                            carArrayList=FactoryMethod.getDataSource(FactoryMethod.Type.MySQL).allCars();
                            //for (Car item : carArrayList) {
                            //    temp+=item.ToString();
                          //  }

                            return null;

                        }


                        @Override
                        protected void onPostExecute(Void aVoid) {
                            try {
                            super.onPostExecute(aVoid);
                                if(carArrayList==null)
                                    carArrayList= new ArrayList<>();
                           // textView4.setText(temp);
                                carArrayAdapter.notifyDataSetChanged();
                                ListOfItems.setAdapter(carArrayAdapter);


                            } catch (Exception e) {
                                Log.w(ConstantsAndEnums.Log.APP_LOG, e.getMessage() );
                                Toast.makeText( PrintLists.this, e.getMessage(), Toast.LENGTH_SHORT ).show();
                            }

                        }

                    }.execute();


                    break;

                case "CarModels":

                    temp="";


                    new AsyncTask<Void, Void, Void>() {


                        @Override
                        protected Void doInBackground(Void... params) {
                            if(carModelArrayList==null)
                                carModelArrayList= new ArrayList<>();
                            carModelArrayAdapter.clear();
                            carModelArrayList=FactoryMethod.getDataSource(FactoryMethod.Type.MySQL).allCarModels();
                        //    for (CarModel item : carModelArrayList) {
                          //      temp+=item.ToString();
                           // }

                            return null;

                        }

                        @Override
                        protected void onPostExecute(Void aVoid) {
                            try {
                                super.onPostExecute(aVoid);
                                if(carModelArrayList==null)
                                    carModelArrayList= new ArrayList<>();
                                carModelArrayAdapter.notifyDataSetChanged();
                                //  textView4.setText(temp);
                                ListOfItems.setAdapter(carModelArrayAdapter);
                            } catch (Exception e) {
                                Log.w(ConstantsAndEnums.Log.APP_LOG, e.getMessage() );
                                Toast.makeText( PrintLists.this, e.getMessage(), Toast.LENGTH_SHORT ).show();
                            }
                        }


                    }.execute();


                    break;

                case "Customers":

                    temp="";


                    new AsyncTask<Void, Void, Void>() {


                        @Override
                        protected Void doInBackground(Void... params) {
                            if(customerArrayList==null)
                                customerArrayList= new ArrayList<>();
                            customerArrayList.clear();
                            customerArrayList=FactoryMethod.getDataSource(FactoryMethod.Type.MySQL).allCustomers();
                            //for (Customer item : customerArrayList) {
                            //    temp+=item.ToString();
                         ///   }

                            return null;

                        }

                        @Override
                        protected void onPostExecute(Void aVoid) {
                            try {
                                super.onPostExecute(aVoid);
                                if(customerArrayList==null)
                                    customerArrayList= new ArrayList<>();
                                customerArrayAdapter.notifyDataSetChanged();
                                //  textView4.setText(temp);
                                ListOfItems.setAdapter(customerArrayAdapter);
                            } catch (Exception e) {
                                Log.w(ConstantsAndEnums.Log.APP_LOG, e.getMessage() );
                                Toast.makeText( PrintLists.this, e.getMessage(), Toast.LENGTH_SHORT ).show();
                            }
                        }

                    }.execute();

                    break;

                case "Orders":

                    temp="";


                    new AsyncTask<Void, Void, Void>() {



                        @Override
                        protected Void doInBackground(Void... params) {
                            if(orderArrayList==null)
                                orderArrayList= new ArrayList<>();
                            orderArrayList.clear();
                            orderArrayList=FactoryMethod.getDataSource(FactoryMethod.Type.MySQL).allOrders();


                            return null;

                        }

                        @Override
                        protected void onPostExecute(Void aVoid) {
                            try {
                                super.onPostExecute(aVoid);
                                if(orderArrayList==null)
                                    orderArrayList= new ArrayList<>();
                                orderArrayAdapter.notifyDataSetChanged();
                                //  textView4.setText(temp);
                                ListOfItems.setAdapter(orderArrayAdapter);
                            } catch (Exception e) {
                                Log.w(ConstantsAndEnums.Log.APP_LOG, e.getMessage() );
                                Toast.makeText( PrintLists.this, e.getMessage(), Toast.LENGTH_SHORT ).show();
                            }
                        }


                    }.execute();

                    break;
            }


        }
        catch(Exception ex)
        {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
