package com.example.yyblumerandeiheller.takeandgo.model.entities;

import java.sql.Time;
import com.example.yyblumerandeiheller.takeandgo.model.utils.ConstantsAndEnums.orderMode;


public class Order {

    protected String CustomerNum;
    protected orderMode ModeOfOrder;
    protected String CarNumber;
    protected Time RentStartDate;
    protected Time RentEndDate;
    protected int KilometresAtStart;
    protected int KilometresAtEnd;
    protected boolean IsInsertDelek;
    protected int HowMuchDelekInsert;
    protected int HowMuchNeedPay;
    protected String OrderNum;

    public Order(String customerNum, orderMode modeOfOrder, String carNumber, Time rentStartDate,
                 Time rentEndDate, int kilometresAtStart, int kilometresAtEnd, boolean isInsertDelek,
                 int howMuchDelekInsert, int howMuchNeedPay, String orderNum){

        this.CustomerNum = customerNum;
        this.ModeOfOrder = modeOfOrder;
        this.CarNumber = carNumber;
        this.RentStartDate = rentStartDate;
        this.RentEndDate = rentEndDate;
        this.KilometresAtStart = kilometresAtStart;
        this.KilometresAtEnd = kilometresAtEnd;
        this.IsInsertDelek = isInsertDelek;
        this.HowMuchDelekInsert = howMuchDelekInsert;
        this.HowMuchNeedPay = howMuchNeedPay;
        this.OrderNum = orderNum;
    }

    public String getCustomerNum() {
        return CustomerNum;
    }

    public void setCustomerNum(String customerNum) {
        this.CustomerNum = customerNum;
    }

    public orderMode getModeOfOrder() {
        return ModeOfOrder;
    }

    public void setModeOfOrder(orderMode modeOfOrder) {
        this.ModeOfOrder = modeOfOrder;
    }

    public String getCarNumber() {
        return CarNumber;
    }

    public void setCarNumber(String carNumber) {
        this.CarNumber = carNumber;
    }

    public Time getRentStartDate() {
        return RentStartDate;
    }

    public void setRentStartDate(Time rentStartDate) {
        this.RentStartDate = rentStartDate;
    }

    public Time getRentEndDate() {
        return RentEndDate;
    }

    public void setRentEndDate(Time rentEndDate) { this.RentEndDate = rentEndDate; }

    public int getKilometresAtStart() {
        return KilometresAtStart;
    }

    public void setKilometresAtStart(int kilometresAtStart) { this.KilometresAtStart = kilometresAtStart; }

    public int getKilometresAtEnd() { return KilometresAtEnd;
    }

    public void setKilometresAtEnd(int kilometresAtEnd) {
        this.KilometresAtEnd = kilometresAtEnd;
    }

    public boolean getIsInsertDelek() {
        return IsInsertDelek;
    }

    public void setIsInsertDelek(boolean isInsertDelek) {
        this.IsInsertDelek= isInsertDelek;
    }

    public int getHowMuchDelekInsert() { return HowMuchDelekInsert; }

    public void setHowMuchDelekInsert(int howMuchDelekInsert) { this.HowMuchDelekInsert = howMuchDelekInsert; }

    public int getHowMuchNeedPay() { return HowMuchNeedPay;
    }

    public void setHowMuchNeedPay(int howMuchNeedPay) {
        this.HowMuchNeedPay = howMuchNeedPay;
    }

    public String getOrderNum() {
        return OrderNum;
    }

    public void setOrderNum(String orderNum) {
        this.OrderNum = orderNum;
    }
}
