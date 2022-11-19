package Dao;

import Bean.Employee;
import Bean.Leave_Application;
import Exception.*;
public interface EmployeeDao {

    public String updateProfile(int EmployeeId) throws EmployeeException;
    public String changePassword(String passward,int EmployeeId) throws PasswordException,UpdateException;

    public String leaveRequest(int EmployeeId,Leave_Application leave_application) throws LeaveApplicationException ,EmployeeException;

    public  String loginEmployee(String username,String password)throws PasswordException;

}
