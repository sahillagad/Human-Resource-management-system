package Dao;

import Bean.Employee;
import Bean.Leave_Application;
import  Exception.*;
import Utility.DBUtility;

import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

public class EmployeeDaoImpl implements EmployeeDao{

    @Override
    public String updateProfile(int EmployeeId) throws EmployeeException {

        String result="Employee Profile Update is failed.....";

        try(Connection conn= DBUtility.provideConnection()) {

            PreparedStatement ps = conn.prepareStatement("select * from employee where employeeId=?");
            ps.setInt(1,EmployeeId);

           ResultSet resultSet=ps.executeQuery();





           if(resultSet.next()){
               int employeeId1 = resultSet.getInt("employeeId");
               String firstName = resultSet.getString("employee_first_name");
               String lastName = resultSet.getString("employee_last_name");
               String email = resultSet.getString("employee_email");
               int salary=resultSet.getInt("employee_salary");
               String phoneNumber = resultSet.getString("employee_phone_number");
               LocalDate date = resultSet.getDate("employee_hire_date").toLocalDate();
               int departmentId = resultSet.getInt("employee_departmentId");
               String passward = resultSet.getString("employee_password");
               String username = resultSet.getString("employee_username");

              Employee  employee = new Employee(employeeId1, firstName, lastName, email, phoneNumber, salary, date, departmentId, passward, username);

               Scanner sc=new Scanner(System.in);
               while (true){
                   System.out.println("Enter 1 For Update the First Name");
                   System.out.println("Enter 2 For Update the Last Name");
                   System.out.println("Enter 3 For Update the Email");
                   System.out.println("Enter 4 For Update the Phone Number");
                   System.out.println("Enter 5 For Exit");

                   int output=sc.nextInt();
                   if(output==1){
                       System.out.println("Enter First Name");
                       String fName=sc.next();
                       employee.setEmployee_first_name(fName);
                   }
                   else if (output==2){
                       System.out.println("Enter Last Name");
                       String lName=sc.next();
                       employee.setEmployee_last_name(lName);
                   }
                   else if(output==3){
                       System.out.println("Enter Email");
                       String eEmail=sc.next();
                       employee.setEmployee_email(eEmail);
                   }
                   else if(output==4){
                       System.out.println("Enter Phone Number");
                       String ePhone= sc.next();
                       employee.setEmployee_phone_number(ePhone);
                   }
                   else if(output==5){
                       System.out.println("Update Process Start....");
                          break;
                   }

                   else if(output>1 || output<5){
                       System.out.println("Please Enter Valid Input...");
                   }
               }

               PreparedStatement ps1 = conn.prepareStatement("Update employee set employee_first_name=?,employee_last_name=?,employee_email=?,employee_phone_number=? where employeeId=?");
               ps1.setString(1,employee.getEmployee_first_name());
               ps1.setString(2,employee.getEmployee_last_name());
               ps1.setString(3,employee.getEmployee_email());
               ps1.setString(4,employee.getEmployee_phone_number());
               ps1.setInt(5,EmployeeId);
              int x= ps1.executeUpdate();
              if(x>0){
                  result="Employee Profile Update successfully";
              }
              else {
                  UpdateException updateException=new UpdateException("Employee Profile Update is Failed due to Some Error");
              }

           }else{

               EmployeeException employeeException=new EmployeeException("Employee Is Not Found By Given Employee Id....");
               throw employeeException;
           }







        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return result;
    }


    public Employee chackPassword(String phoneNumber1, String Username1) throws PasswordException, EmployeeException {
     Employee employee=null;
        try(Connection conn= DBUtility.provideConnection()) {

            PreparedStatement ps = conn.prepareStatement("select * from employee where employee_phone_number=? AND employee_username=?");
            ps.setString(1, phoneNumber1);
            ps.setString(2,Username1);

            ResultSet resultSet = ps.executeQuery();


            if (resultSet.next()) {
                int employeeId1 = resultSet.getInt("employeeId");
                String firstName = resultSet.getString("employee_first_name");
                String lastName = resultSet.getString("employee_last_name");
                String email = resultSet.getString("employee_email");
                int salary = resultSet.getInt("employee_salary");
                String phoneNumber = resultSet.getString("employee_phone_number");
                LocalDate date = resultSet.getDate("employee_hire_date").toLocalDate();
                int departmentId = resultSet.getInt("employee_departmentId");
                String passward = resultSet.getString("employee_password");
                String username = resultSet.getString("employee_username");

                 employee = new Employee(employeeId1, firstName, lastName, email, phoneNumber, salary, date, departmentId, passward, username);

            }
            else {

                EmployeeException employeeException=new EmployeeException("Employee is Not Available for Given PhoneNumber And employee_username");
                throw  employeeException;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

      return  employee;
    }

    @Override
    public String changePassword(String passward,int EmployeeId) throws PasswordException, UpdateException {

        String result="Password  Change Faild Due To Some Error";
        try(Connection conn= DBUtility.provideConnection()) {

            PreparedStatement ps = conn.prepareStatement("Update employee set employee_password=? where EmployeeId=?");
            ps.setString(1, passward);
            ps.setInt(2, EmployeeId);

            int x=ps.executeUpdate();

            if(x>0){

                 result="Password Change successfully";
            }
            else{

                UpdateException updateException=new UpdateException("Passward Update Is failed...");
                throw  updateException;
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

            return  result;
    }

    @Override
    public String leaveRequest(int EmployeeId,Leave_Application leave_application) throws LeaveApplicationException ,EmployeeException{
        String result="Employee leave Request application is failed.....";

        try(Connection conn= DBUtility.provideConnection()) {

            PreparedStatement ps = conn.prepareStatement("select * from employee where employeeId=?");
            ps.setInt(1, EmployeeId);

            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {

                String query="insert into leave_application(employeeId,leave_type,from_date,to_date,total_days,remark,status,note) values(?,?,?,?,?,?,?,?) ";
                PreparedStatement ps1 = conn.prepareStatement(query);
                ps1.setInt(1,leave_application.getEmployeeId());
                ps1.setString(2,leave_application.getLeave_type());
                ps1.setDate(3, Date.valueOf(leave_application.getFrom_date()));
                ps1.setDate(4,Date.valueOf(leave_application.getTo_date()));
                ps1.setInt(5,leave_application.getTotal_days());
                ps1.setString(6,leave_application.getRemark());
                ps1.setString(7,leave_application.getStatus());
                ps1.setString(8,leave_application.getNote());


               int x= ps1.executeUpdate();

               if(x>0){
                   result="Employee leave Request application successfully Raise";

               }
               else{
                   LeaveApplicationException applicationException=new LeaveApplicationException("Leave Application Not Filled Due To Some Error");
                   throw  applicationException;
               }



            }
            else{
                EmployeeException employeeException=new EmployeeException("Employee Is Not Found By Given Employee Id....");
                throw employeeException;
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return  result;

    }

    @Override
    public String loginEmployee(String username, String password) throws PasswordException {
        String result = "Login Failed Due To Some Error...";


        try (Connection conn = DBUtility.provideConnection()) {

            PreparedStatement ps1 = conn.prepareStatement("select * from employee where  employee_username=? AND employee_password=?");
            ps1.setString(1, username);
            ps1.setString(2, password);


            ResultSet rs = ps1.executeQuery();

            if (rs.next()) {

                result = "Login Successfully";

            } else {

                PasswordException password1 = new PasswordException("Invaild UserName and Password");
                throw password1;

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return result;
    }
}
