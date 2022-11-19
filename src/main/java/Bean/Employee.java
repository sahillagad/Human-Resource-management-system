package Bean;

import java.sql.Date;
import java.time.LocalDate;

public class Employee {

  private int  employeeId;
  private String  employee_first_name;
   private String  employee_last_name;
   private String employee_email;
   private  String employee_phone_number;
   private int employee_salary;
   private LocalDate employee_hire_date;
   private  int employee_departmentId;
   private String employee_password;
   private String employee_username;

 public Employee() {
 }



 public Employee(String employee_first_name, String employee_last_name, String employee_email, String employee_phone_number, int employee_salary, LocalDate employee_hire_date, int employee_departmentId, String employee_password, String employee_username) {
  this.employee_first_name = employee_first_name;
  this.employee_last_name = employee_last_name;
  this.employee_email = employee_email;
  this.employee_phone_number = employee_phone_number;
  this.employee_salary = employee_salary;
  this.employee_hire_date = employee_hire_date;
  this.employee_departmentId = employee_departmentId;
  this.employee_password = employee_password;
  this.employee_username = employee_username;
 }

 public Employee(int employeeId, String employee_first_name, String employee_last_name, String employee_email, String employee_phone_number, int employee_salary, LocalDate employee_hire_date, int employee_departmentId, String employee_password, String employee_username) {
  this.employeeId = employeeId;
  this.employee_first_name = employee_first_name;
  this.employee_last_name = employee_last_name;
  this.employee_email = employee_email;
  this.employee_phone_number = employee_phone_number;
  this.employee_salary = employee_salary;
  this.employee_hire_date = employee_hire_date;
  this.employee_departmentId = employee_departmentId;
  this.employee_password = employee_password;
  this.employee_username = employee_username;
 }
 public int getEmployeeId() {
  return employeeId;
 }

 public void setEmployeeId(int employeeId) {
  this.employeeId = employeeId;
 }

 public String getEmployee_first_name() {
  return employee_first_name;
 }

 public void setEmployee_first_name(String employee_first_name) {
  this.employee_first_name = employee_first_name;
 }

 public String getEmployee_last_name() {
  return employee_last_name;
 }

 public void setEmployee_last_name(String employee_last_name) {
  this.employee_last_name = employee_last_name;
 }

 public String getEmployee_email() {
  return employee_email;
 }

 public void setEmployee_email(String employee_email) {
  this.employee_email = employee_email;
 }

 public String getEmployee_phone_number() {
  return employee_phone_number;
 }

 public void setEmployee_phone_number(String employee_phone_number) {
  this.employee_phone_number = employee_phone_number;
 }

 public int getEmployee_salary() {
  return employee_salary;
 }

 public void setEmployee_salary(int employee_salary) {
  this.employee_salary = employee_salary;
 }

 public LocalDate getEmployee_hire_date() {
  return employee_hire_date;
 }

 public void setEmployee_hire_date(LocalDate employee_hire_date) {
  this.employee_hire_date = employee_hire_date;
 }

 public int getEmployee_departmentId() {
  return employee_departmentId;
 }

 public void setEmployee_departmentId(int employee_departmentId) {
  this.employee_departmentId = employee_departmentId;
 }

 public String getEmployee_password() {
  return employee_password;
 }

 public void setEmployee_password(String employee_password) {
  this.employee_password = employee_password;
 }

 public String getEmployee_username() {
  return employee_username;
 }

 public void setEmployee_username(String employee_username) {
  this.employee_username = employee_username;
 }

 @Override
 public String toString() {
  return "Employee{" +
          "employeeId=" + employeeId +
          ", employee_first_name='" + employee_first_name + '\'' +
          ", employee_last_name='" + employee_last_name + '\'' +
          ", employee_email='" + employee_email + '\'' +
          ", employee_phone_number='" + employee_phone_number + '\'' +
          ", employee_salary=" + employee_salary +
          ", employee_hire_date=" + employee_hire_date +
          ", employee_departmentId=" + employee_departmentId +
          ", employee_password='" + employee_password + '\'' +
          ", employee_username='" + employee_username + '\'' +
          '}';
 }
}
