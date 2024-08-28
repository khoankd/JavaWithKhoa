/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 *
 * @author DANGKHOA
 */
public class ListBill {
    private List<Bill> b;

    public ListBill() {
        this.b=new ArrayList<>();
        loadFromFile("electricitybill.txt");
    }
    public void addNewBill(int id,String name,double amount,Date dueDate,boolean isPaid){
        boolean flag=true;
        for (Bill bill : b) {
            if(bill.getId()==id){
                flag=false;
            }
        }
        if(flag=true){
            this.b.add(new Bill(id, name, amount, dueDate, isPaid));
        }
    }
    
    public void deleteBillByID(int id){
        for (Bill bill : b) {
            if(bill.getId()==id){
                b.remove(bill);
            }
        }
    }
    
    public void deleteBillByName(String name){
        for (Bill bill : b) {
            if(bill.getCustomerName().equals(name)){
                b.remove(bill);
            }
        }
    }
    
    public void deleteBillByDate(Date date1){
        for (Bill bill : b) {
            if(bill.getDueDate().equals(date1)){
                b.remove(bill);
            }
        }
    }
    
    public void listUnpaid(){
        for (Bill bill : b) {
            if(bill.isIsPaid()==false){
                System.out.println(bill);
            }
        }
    }
    
    public void listAll(){
        
        for (Bill bill : b) {
            System.out.println(bill);
        }
    }
    
    public double largestAmount(){
        Collections.sort(b,Comparator.comparingDouble(Bill::getAmount).reversed());
        double max=b.get(0).getAmount();
        return max;
    }
    
    public void loadFromFile(String filename){
        try {
            FileReader fr=new FileReader(filename);
            BufferedReader br=new BufferedReader(fr);
            while(true){
                String data=br.readLine();
                if(data==null){
                    break;
                }
                else{
                    
                    String[] sp=data.split(",");
                    int id=Integer.parseInt(sp[0].trim());
                    String name=sp[1].trim();
                    double amount=Double.parseDouble(sp[2].trim());
                    String day=sp[3].trim();
                    SimpleDateFormat df=new SimpleDateFormat("dd/MM/yyyy");
                    Date date1=df.parse(day);
                    boolean isPaid=Boolean.parseBoolean(sp[4].trim());
                    this.b.add(new Bill(id, name, amount, date1,isPaid));
                }
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
