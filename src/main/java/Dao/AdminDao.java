package Dao;

import Bean.Admin;
import Bean.Department;
import Bean.Employee;
import Exception.*;

public interface AdminDao {

    public String registerAdmin(Admin admin) throws AdminException;
    public  String loginAdmin(String username,String password)throws PasswordException;
    public String registerEmployee(Employee employee) throws EmployeeException;
    public String addDepartment(Department department) throws  DepartmentException;
    public String transferDepartment(int EmployeeId,int DepartmentId)throws EmployeeException,UpdateException;
    public String leaveRequestEmployeeId(int EmployeeId) throws  LeaveApplicationException,EmployeeException;
    public String updateLeaveRequestLeaveApplicationId(int leaveApplicationId) throws  LeaveApplicationException;
    public String deleteEmployee(int EmployeeId) throws EmployeeException,UpdateException;
    public String deleteDepartment(int DepartmentId) throws  DepartmentException,UpdateException;
    public Employee findEmployee(int EmployeeId) throws  EmployeeException;
    public Department findDepartment(int DepartmentId) throws DepartmentException;
    public void getAllEmployee() throws EmployeeException;
    public void getAllDepartment() throws DepartmentException;



}
