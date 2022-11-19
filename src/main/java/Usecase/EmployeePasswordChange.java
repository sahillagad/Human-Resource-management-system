package Usecase;

import Bean.Employee;
import Dao.EmployeeDao;
import Dao.EmployeeDaoImpl;

import java.util.Scanner;

public class EmployeePasswordChange {

    public static void main(String[] args) {
      EmployeeDaoImpl dao=new EmployeeDaoImpl();

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Employee Phone Number");
        String phoneNumber=sc.next();

        System.out.println("Enter Employee UserName");
        String userName=sc.next();


        try {
          Employee employee= dao.chackPassword(phoneNumber,userName);

          if(employee !=null){

              System.out.println("Enter New Password");
              String password=sc.next();
              String s=dao.changePassword(password,employee.getEmployeeId());
              System.out.println(s);


          }




        } catch (Exception e) {

            System.out.println(e.getMessage());

        }



    }

}
