package Usecase;

import Bean.Admin;
import Dao.AdminDao;
import Dao.AdminDaoImpl;

import java.util.Scanner;

public class AdminRegister {
    public static void main(String[] args) {


        Scanner sc=new Scanner(System.in);

        System.out.println("Enter Admin First Name");
        String firstName= sc.next();

        System.out.println("Enter Admin Last Name");
        String lastName= sc.next();

        System.out.println("Enter Admin Email id");
        String email= sc.next();

        System.out.println("Enter Admin Phone Number");
         String phone=sc.next();

        System.out.println("Enter Admin UserName");
         String username= sc.next();

        System.out.println("Enter Admin Passward");
        String password= sc.next();


        Admin admin=new Admin(firstName,lastName,email,phone,password,username);

        AdminDao dao=new AdminDaoImpl();


        try {

           String s=dao.registerAdmin(admin);
            System.out.println(s);

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }


    }
}
