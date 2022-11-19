package Usecase;

import Dao.AdminDao;
import Dao.AdminDaoImpl;

import java.util.Scanner;

public class DeleteDepartment {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Department ID");
        int departmentId=sc.nextInt();

        AdminDao dao=new AdminDaoImpl();

        try {

        String s=dao.deleteDepartment(departmentId);
            System.out.println(s);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
