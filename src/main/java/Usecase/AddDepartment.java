package Usecase;

import Bean.Department;
import Dao.AdminDao;
import Dao.AdminDaoImpl;

import java.util.Scanner;

public class AddDepartment {

    public static void main(String[] args) {


        Scanner sc=new Scanner(System.in);

        System.out.println("Enter Department Name");
        String departmentName= sc.next();


        System.out.println("Enter Department Location");
        String departmentLocation=sc.next();


        Department department=new Department(departmentName,departmentLocation);

        AdminDao dao=new AdminDaoImpl();



        try {
        String  output = dao.addDepartment(department);
            System.out.println(output);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }






    }
}
