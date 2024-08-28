/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view_controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ListBill;

/**
 *
 * @author DANGKHOA
 */
public class BillManagement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        ListBill lb = new ListBill();
        String title = "Electricity Bills Management";
        String[] mchon = {"1.Load data", "2.Add new bill", "3.Delete a bill", "4.Largest amount", "5.Unpaid list", "6.Quit"};
        Menu m;
        m = new Menu(title, mchon) {
            @Override
            public void execute(int ch) {
                switch (ch) {
                    case 1:
//                        lb.loadFromFile("electricitybill.txt");
                        lb.listAll();
                        break;
                    case 2:
                        int id = 0;
                        System.out.println("Enter id:");
                        while (true) {
                            try {
                                id = Integer.parseInt(sc.nextLine());
                                break;
                            } catch (Exception e) {
                                System.out.println("Enter again:");
                            }
                        }
                        System.out.println("Enter name:");
                        String name = sc.nextLine();
                        System.out.println("Enter amount:");
                        double amount = 0;
                        while (true) {
                            try {
                                amount = Double.parseDouble(sc.nextLine());
                                break;
                            } catch (Exception e) {
                                System.out.println("Enter again:");
                            }
                        }
                        System.out.println("Enter due date: ");
                        String day = sc.nextLine();
                        Date date1 = null;
                        try {
                            date1 = df.parse(day);
                        } catch (Exception e) {

                        }
                        System.out.println("Enter is paid:");
                        boolean isPaid = Boolean.parseBoolean(sc.nextLine());
                        lb.addNewBill(id, name, amount, date1, isPaid);
                        break;
                    case 3:
                        System.out.println("Delete choice");
                        System.out.println("-----------------");
                        System.out.println("1.Delete by id");
                        System.out.println("2.Delete by customer name");
                        System.out.println("3.Delete by due date");
                        System.out.println("------------------");
                        System.out.println("Enter chocie:");
                        int choice1 = Integer.parseInt(sc.nextLine());
                        switch (choice1) {
                            case 1:
                                System.out.println("Enter id:");
                                int id1 = Integer.parseInt(sc.nextLine());
                                lb.deleteBillByID(id1);
                                break;
                            case 2:
                                System.out.println("Enter customer name:");
                                String name1 = sc.nextLine();
                                lb.deleteBillByName(name1);
                                break;
                            case 3:
                                System.out.println("Enter due date:");
                                String day2 = sc.nextLine();
                                Date date2 = null;
                                try {
                                    date2 = df.parse(day2);
                                } catch (ParseException ex) {
                                    Logger.getLogger(BillManagement.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                lb.deleteBillByDate(date2);
                                break;
                        }
                        break;
                    case 4:
                        double largestAmount=lb.largestAmount();
                        System.out.println("Largest amount: "+largestAmount);
                        break;
                    case 5:
                        lb.listUnpaid();
                        break;
                    case 6:
                        System.exit(0);
                }
            }
        };
        m.run();

    }

}
