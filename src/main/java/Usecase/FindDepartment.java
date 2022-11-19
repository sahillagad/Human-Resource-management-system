package Usecase;

import Bean.Department;
import Bean.Employee;
import Dao.AdminDao;
import Dao.AdminDaoImpl;

import java.util.Scanner;

public class FindDepartment {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Department Id");
        int departmentId=sc.nextInt();

        AdminDao dao=new AdminDaoImpl();

        try {

            Department department = dao.findDepartment(departmentId);
            if (department != null) {
                System.out.println("Department Id          : " +department.getDepartmentId());
                System.out.println("Department Name        : " + department.getDepartment_name());
                System.out.println("Department Location    : " + department.getDepartment_location());

            }
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }


    }
}