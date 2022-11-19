package Usecase;

import Dao.AdminDao;
import Dao.AdminDaoImpl;

import java.util.Scanner;

public class AdminLogin {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Admin Username");
        String username=sc.next();

        System.out.println("Enter Admin Password");
        String password=sc.next();


        AdminDao dao=new AdminDaoImpl();
        try {
            String s=dao.loginAdmin(username,password);
            System.out.println(s);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
