package Usecase;

import Bean.Employee;
import Dao.AdminDao;
import Dao.AdminDaoImpl;

import java.util.Scanner;

public class FindEmployeeById {
    public static void main(String[] args) {


        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Employee Id");
        int employeeId=sc.nextInt();

        AdminDao dao=new AdminDaoImpl();

        try {

           Employee employee= dao.findEmployee(employeeId);
   if(employee!=null){

       System.out.println("Employee Id           : " + employee.getEmployeeId());
       System.out.println("Employee First Name   : " + employee.getEmployee_first_name());
       System.out.println("Employee Last Name    : " + employee.getEmployee_last_name());
       System.out.println("Employee Email        : " + employee.getEmployee_email());
       System.out.println("Employee Phone Number : " + employee.getEmployee_phone_number());
       System.out.println("Employee Salary       : " + employee.getEmployee_salary());
       System.out.println("Employee Hire Date    : " + employee.getEmployee_hire_date());
       System.out.println("Employee DepartmentId : " + employee.getEmployee_departmentId());
   }



        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
