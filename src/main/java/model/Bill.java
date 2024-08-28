/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author DANGKHOA
 */
public class Bill {
    private int id;
    private String customerName;
    private double amount;
    private Date dueDate;
    private boolean isPaid;
    public Bill() {
    }

    public Bill(int id, String customerName, double amount, Date dueDate,boolean isPaid) {
        this.id = id;
        this.customerName = customerName;
        this.amount = amount;
        this.dueDate = dueDate;
        this.isPaid=isPaid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isIsPaid() {
        return isPaid;
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    @Override
    public String toString() {
        SimpleDateFormat df=new SimpleDateFormat("dd/MM/yyyy");
        return "Bill{" + "id=" + id + ", customerName=" + customerName + ", amount=" + amount + ", dueDate=" + String.format(df.format(dueDate)) + ", isPaid="+isPaid +'}';
    }
    
    
}
