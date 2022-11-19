package Usecase;

import Bean.Employee;
import Dao.AdminDao;
import Dao.AdminDaoImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class EmployeeRegister {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Employee First Name");
        String firstName = sc.next();

        System.out.println("Enter Employee Last Name");
        String lastName = sc.next();

        System.out.println("Enter Employee Email id");
        String email = sc.next();

        System.out.println("Enter Employee Phone Number");
        String phone = sc.next();

        System.out.println("Enter Employee Salary");
        int salary=sc.nextInt();

        System.out.println("Enter Employee Hire Date in form of (dd/mm/yyyy)");
       String hireDate=sc.next();

        LocalDate  date=LocalDate.parse(hireDate,DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.println("Enter Employee Department Id");
        int departmentId=sc.nextInt();



        System.out.println("Enter Employee UserName");
        String username = sc.next();

        System.out.println("Enter Employee Passward");
        String password = sc.next();


        Employee employee=new Employee(firstName,lastName,email,phone,salary,date,departmentId,password,username);
        AdminDao dao=new AdminDaoImpl();

        try {

            String result=dao.registerEmployee(employee);
            System.out.println(result);



        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
    }
