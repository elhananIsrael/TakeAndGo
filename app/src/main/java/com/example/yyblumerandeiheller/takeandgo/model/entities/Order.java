package com.example.yyblumerandeiheller.takeandgo.model.entities;

import java.util.Date;
import com.example.yyblumerandeiheller.takeandgo.model.utils.ConstantsAndEnums.orderMode;


public class Order {

    protected String customerNum;
    protected orderMode modeOfOrder;
    protected String carNumber;
    protected Date rentStartDate;
    protected Date rentEndDate;
    protected int kilometresAtStart;
    protected int kilometresAtEnd;
    protected boolean isInsertDelek;
    protected int howMuchDelekInsert;
    protected int howMuchNeedPay;
    protected String orderNum;

    public Order(String customerNum, orderMode modeOfOrder, String carNumber, Date rentStartDate,
                 Date rentEndDate, int kilometresAtStart, int kilometresAtEnd, boolean isInsertDelek,
                 int howMuchDelekInsert, int howMuchNeedPay, String orderNum){

        this.customerNum = customerNum;
        this.modeOfOrder = modeOfOrder;
        this.carNumber = carNumber;
        this.rentStartDate = rentStartDate;
        this.rentEndDate = rentEndDate;
        this.kilometresAtStart = kilometresAtStart;
        this.kilometresAtEnd = kilometresAtEnd;
        this.isInsertDelek = isInsertDelek;
        this.howMuchDelekInsert = howMuchDelekInsert;
        this.howMuchNeedPay = howMuchNeedPay;
        this.orderNum = orderNum;
    }

    public Order() {

    }

    public String getCustomerNum() {
        return customerNum;
    }

    public void setCustomerNum(String customerNum) {
        this.customerNum = customerNum;
    }

    public orderMode getModeOfOrder() {
        return modeOfOrder;
    }

    public void setModeOfOrder(orderMode modeOfOrder) {
        this.modeOfOrder = modeOfOrder;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public Date getRentStartDate() {
        return rentStartDate;
    }

    public void setRentStartDate(Date rentStartDate) {
        this.rentStartDate = rentStartDate;
    }

    public Date getRentEndDate() {
        return rentEndDate;
    }

    public void setRentEndDate(Date rentEndDate) {
        this.rentEndDate = rentEndDate;
    }

    public int getKilometresAtStart() {
        return kilometresAtStart;
    }

    public void setKilometresAtStart(int kilometresAtStart) {
        this.kilometresAtStart = kilometresAtStart;
    }

    public int getKilometresAtEnd() {
        return kilometresAtEnd;
    }

    public void setKilometresAtEnd(int kilometresAtEnd) {
        this.kilometresAtEnd = kilometresAtEnd;
    }

    public boolean getIsInsertDelek() {
        return isInsertDelek;
    }

    public void setIsInsertDelek(boolean isInsertDelek) {
        this.isInsertDelek= isInsertDelek;
    }

    public int getHowMuchDelekInsert() {
        return howMuchDelekInsert;
    }

    public void setHowMuchDelekInsert(int howMuchDelekInsert) {
        this.howMuchDelekInsert = howMuchDelekInsert;
    }

    public int getHowMuchNeedPay() {
        return howMuchNeedPay;
    }

    public void setHowMuchNeedPay(int howMuchNeedPay) {
        this.howMuchNeedPay = howMuchNeedPay;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }


    public void ToString()
    {
        System.out.println("\n"+customerNum +"\n"+modeOfOrder+"\n"+carNumber+"\n"+rentStartDate+"\n"+rentEndDate +"\n"+kilometresAtStart+"\n"+kilometresAtEnd+"\n"+isInsertDelek+"\n"+howMuchDelekInsert+"\n"+howMuchNeedPay+"\n"+orderNum+"\n");
    }

}
