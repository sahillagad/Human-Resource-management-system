package Usecase;

import Dao.AdminDao;
import Dao.AdminDaoImpl;

import java.util.Scanner;

public class UpdateEmployeeDepartment {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter Employee Id");
        int employeeId=sc.nextInt();

        System.out.println("Enter Employee Department Id");
        int departmentId=sc.nextInt();

        AdminDao dao=new AdminDaoImpl();

        try {

            String output= dao.transferDepartment(employeeId,departmentId);
            System.out.println(output);
        } catch (Exception e) {

            System.out.println(e);

        }


    }
}
