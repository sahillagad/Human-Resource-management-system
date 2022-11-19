package Usecase;

import Dao.AdminDao;
import Dao.AdminDaoImpl;

import java.util.Scanner;

public class DeleteEmployee {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee Id");
        int employeeId= sc.nextInt();

        AdminDao dao=new AdminDaoImpl();
        try {

            String s=dao.deleteEmployee(employeeId);
            System.out.println(s);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
