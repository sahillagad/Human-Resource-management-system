package Usecase;

import Dao.AdminDao;
import Dao.AdminDaoImpl;
import Dao.EmployeeDao;
import Dao.EmployeeDaoImpl;

import java.util.Scanner;

public class EmployeeLogin {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Employee UserName");
        String username=sc.next();

        System.out.println("Enter Employee Password");
        String password=sc.next();


        EmployeeDao dao=new EmployeeDaoImpl();

        try {
           String s= dao.loginEmployee(username,password);
            System.out.println(s);
        } catch (Exception e) {

            System.out.println(e.getMessage());

        }


    }
}
