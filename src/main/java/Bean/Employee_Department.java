package Bean;

import java.time.LocalDate;

public class Employee_Department {
    private int  employeeId;
    private String  employee_first_name;
    private String  employee_last_name;
    private String employee_email;
    private  int employee_phone_number;
    private int employee_salary;

    private int departmentId;
    private  int  department_name;
    private  String  department_location;


    public Employee_Department(int employeeId, String employee_first_name, String employee_last_name, String employee_email, int employee_phone_number, int employee_salary, int departmentId, int department_name, String department_location) {
        this.employeeId = employeeId;
        this.employee_first_name = employee_first_name;
        this.employee_last_name = employee_last_name;
        this.employee_email = employee_email;
        this.employee_phone_number = employee_phone_number;
        this.employee_salary = employee_salary;
        this.departmentId = departmentId;
        this.department_name = department_name;
        this.department_location = department_location;
    }

    public Employee_Department() {
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

    public int getEmployee_phone_number() {
        return employee_phone_number;
    }

    public void setEmployee_phone_number(int employee_phone_number) {
        this.employee_phone_number = employee_phone_number;
    }

    public int getEmployee_salary() {
        return employee_salary;
    }

    public void setEmployee_salary(int employee_salary) {
        this.employee_salary = employee_salary;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(int department_name) {
        this.department_name = department_name;
    }

    public String getDepartment_location() {
        return department_location;
    }

    public void setDepartment_location(String department_location) {
        this.department_location = department_location;
    }

    @Override
    public String toString() {
        return "Employee_Department{" +
                "employeeId=" + employeeId +
                ", employee_first_name='" + employee_first_name + '\'' +
                ", employee_last_name='" + employee_last_name + '\'' +
                ", employee_email='" + employee_email + '\'' +
                ", employee_phone_number=" + employee_phone_number +
                ", employee_salary=" + employee_salary +
                ", departmentId=" + departmentId +
                ", department_name=" + department_name +
                ", department_location='" + department_location + '\'' +
                '}';
    }
}
