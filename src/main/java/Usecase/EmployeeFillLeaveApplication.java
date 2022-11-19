package Usecase;

import Bean.Leave_Application;
import Dao.EmployeeDao;
import Dao.EmployeeDaoImpl;
import  Exception.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class EmployeeFillLeaveApplication {

    public static void main(String[] args) throws LeaveApplicationException {

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Employee Id");
        int EmployeeId=sc.nextInt();
        System.out.println("\n-----------Leave Type--------" +
                "\nPrivilege Leave Than Enter PL  " +
                " \nEarned Leave Than Enter EL " +
                "\nAnnual Leave Than Enter AL ");



        System.out.println("\nEnter LeaveType");
        String leaveType=sc.next();
        if(leaveType.equals("PL") || leaveType.equals("EL") || leaveType.equals("AL")){

        }
        else{

         LeaveApplicationException applicationException=new LeaveApplicationException("Invalid Leave Type Is Enter");
         throw applicationException;

        }


        System.out.println("Enter From Date (Date Write  In Form of DD/MM/YYYY)");
        String fromDate=sc.next();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate from_date1=LocalDate.parse(fromDate,formatter);




        System.out.println("Enter To Date (Date Write  In Form of DD/MM/YYYY)");
        String toDate=sc.next();
        LocalDate to_date1=LocalDate.parse(toDate,formatter);


        int total_days1=to_date1.compareTo(from_date1);

        System.out.println("Enter Remark (Reason of Leave)");
        String remark=sc.next();

        Leave_Application leave_application=new Leave_Application(EmployeeId,leaveType,from_date1,to_date1,total_days1,remark,"false",null);
        EmployeeDao dao=new EmployeeDaoImpl();

        try {
          String s= dao.leaveRequest(EmployeeId,leave_application);
            System.out.println(s);
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }


    }
}
