package Usecase;

import Dao.EmployeeDao;
import Dao.EmployeeDaoImpl;

import java.util.Scanner;

public class EmployeeProfileUpdate {
    public static void main(String[] args) {


        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Employee Id");
        int EmployeeId= sc.nextInt();

        EmployeeDao dao=new EmployeeDaoImpl();

        try {
           String s=dao.updateProfile(EmployeeId);
            System.out.println(s);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
