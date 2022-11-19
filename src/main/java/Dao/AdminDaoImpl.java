package Dao;

import Bean.Admin;
import Bean.Department;
import Bean.Employee;

import Exception.*;
import Exception.PasswordException;
import Utility.DBUtility;
import dnl.utils.text.table.TextTable;

import java.sql.*;
import java.time.LocalDate;


public class AdminDaoImpl implements AdminDao {


    @Override
    public String registerAdmin(Admin admin) throws AdminException {
        String result = "Admin Is Not Created...";


        try (Connection conn = DBUtility.provideConnection()) {

            PreparedStatement ps1 = conn.prepareStatement("select * from admin where  admin_email=? OR admin_phone_number=?");
            ps1.setString(1, admin.getAdmin_email());
            ps1.setString(2, admin.getAdmin_phone_number());


            ResultSet rs = ps1.executeQuery();

            if (rs.next() == false) {
                PreparedStatement ps = conn.prepareStatement("insert into admin(admin_first_name,admin_last_name,admin_email,admin_phone_number,admin_password,admin_username)  values(?,?,?,?,?,?)");
                ps.setString(1, admin.getAdmin_first_name());
                ps.setString(2, admin.getAdmin_last_name());
                ps.setString(3, admin.getAdmin_email());
                ps.setString(4, admin.getAdmin_phone_number());
                ps.setString(5,admin.getAdmin_password());
                ps.setString(6, admin.getAdmin_username());

                int x = ps.executeUpdate();

                if (x > 0) {

                    result = "Admin Is Created Successfully...";
                }

            } else {
                AdminException adminException = new AdminException("Please Check Admin is Already Present");
                throw adminException;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return result;
    }

    @Override
    public String loginAdmin(String username, String password) throws PasswordException {
        String result = "Login Failed Due To Some Error...";


        try (Connection conn = DBUtility.provideConnection()) {

            PreparedStatement ps1 = conn.prepareStatement("select * from admin where  admin_username=? AND admin_password=?");
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

    @Override
    public String registerEmployee(Employee employee) throws EmployeeException {
        String result = "Employee Is Not Created...";


        try (Connection conn = DBUtility.provideConnection()) {

            PreparedStatement ps1 = conn.prepareStatement("select * from employee where  employee_email=? OR employee_phone_number =?");
            ps1.setString(1, employee.getEmployee_email());
            ps1.setString(2, employee.getEmployee_phone_number());


            ResultSet rs = ps1.executeQuery();

            if (rs.next() == false) {
                PreparedStatement ps = conn.prepareStatement("insert into employee(employee_first_name, employee_last_name,employee_email,employee_phone_number,employee_salary,employee_hire_date,employee_departmentId,employee_password,employee_username)  values(?,?,?,?,?,?,?,?,?)");
                ps.setString(1, employee.getEmployee_first_name());
                ps.setString(2, employee.getEmployee_last_name());
                ps.setString(3, employee.getEmployee_email());
                ps.setString(4, employee.getEmployee_phone_number());
                ps.setInt(5, employee.getEmployee_salary());
                ps.setDate(6, Date.valueOf(employee.getEmployee_hire_date()));
                ps.setInt(7, employee.getEmployee_departmentId());
                ps.setString(8, employee.getEmployee_password());
                ps.setString(9, employee.getEmployee_username());


                int x = ps.executeUpdate();

                if (x > 0) {

                    result = "Employee Is Created Successfully...";
                }

            } else {

                EmployeeException employeeException = new EmployeeException("Please Check Employee is Already Present");
                throw employeeException;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return result;
    }

    @Override
    public String addDepartment(Department department) throws DepartmentException {

        String result = "Department Is Not Created...";


        try (Connection conn = DBUtility.provideConnection()) {

            PreparedStatement ps1 = conn.prepareStatement("select * from department where  department_name=? AND department_location=?");
            ps1.setString(1, department.getDepartment_name());
            ps1.setString(2, department.getDepartment_location());


            ResultSet rs = ps1.executeQuery();

            if (rs.next() == false) {
                PreparedStatement ps = conn.prepareStatement("insert into department(department_name,department_location)  values(?,?)");
                ps.setString(1, department.getDepartment_name());
                ps.setString(2, department.getDepartment_location());


                int x = ps.executeUpdate();

                if (x > 0) {

                    result = "Department Is Created Successfully...";
                }

            } else {
                DepartmentException departmentException = new DepartmentException("this department is Already Present");
                throw departmentException;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return result;


    }

    @Override
    public String transferDepartment(int EmployeeId, int DepartmentId) throws EmployeeException, UpdateException {
        String result = "Employee Department Update Failed.....";


        try (Connection conn = DBUtility.provideConnection()) {

            PreparedStatement ps1 = conn.prepareStatement("select * from employee where  employeeId=?");
            ps1.setInt(1, EmployeeId);

            ResultSet rs = ps1.executeQuery();

            if (rs.next()) {

                try {

                    PreparedStatement ps = conn.prepareStatement("UPDATE employee set employee_departmentId=? where employeeId=?");
                    ps.setInt(1, DepartmentId);
                    ps.setInt(2, EmployeeId);

                    int i = ps.executeUpdate();
                    if (i > 0) {

                        result = "Employee Department Update Successfully.....";
                    } else {
                        UpdateException exception = new UpdateException("Employee Department Transfer Failed.....");
                        throw exception;
                    }


                } catch (SQLException e) {

                    throw new RuntimeException(e);

                }


            } else {
                EmployeeException employeeException = new EmployeeException("Employee Is Not Found By Given Employee Id...");
                throw employeeException;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return result;
    }

    @Override
    public String leaveRequestEmployeeId(int EmployeeId) throws LeaveApplicationException, EmployeeException {
        String result = "Something's Gone Wrong!";
        try (Connection conn = DBUtility.provideConnection()) {

            PreparedStatement ps1 = conn.prepareStatement("select * from employee where  employeeId=?");
            ps1.setInt(1, EmployeeId);

            ResultSet resultSet = ps1.executeQuery();

            if (resultSet.next()) {


                PreparedStatement ps = conn.prepareStatement("select * from leave_application where  employeeId=?");
                ps.setInt(1, EmployeeId);
                ResultSet rs = ps.executeQuery();

                PreparedStatement ps5 = conn.prepareStatement("select count(*) from leave_application");
                //Executing the query
                ResultSet rs5 = ps5.executeQuery();
                //Retrieving the result
                rs5.next();
                int count = rs5.getInt(1);

                if (count > 0) {
                    String[] columnNames = {
                            "applicationId",
                            "leave_type",
                            "from_date",
                            "to_date",
                            "total_days",
                            "remark",
                            "status",
                            "note"
                    };

//


                    Object[][] data = new Object[count][7];
                    int index = 0;
                    while (rs.next()) {


                        int application1 = rs.getInt("application");
                        int employeeid1 = rs.getInt("employeeId");
                        String leave_type1 = rs.getString("leave_type");
                        LocalDate from_date1 = rs.getDate("from_date").toLocalDate();
                        LocalDate to_date1 = rs.getDate("to_date").toLocalDate();
                        int total_days1 = rs.getInt("total_days");

                        String remark1 = rs.getString("remark");
                        String status1 = rs.getString("status");
                        String note1 = rs.getString("note");

//                        System.out.println(application1 + " " + leave_type1 + " " + from_date1);

                        Object[] obj = {application1, leave_type1, from_date1, to_date1, total_days1, remark1, status1, note1};
                        data[index] = obj;
                        index = index + 1;
                    }

                    TextTable tt = new TextTable(columnNames, data);
                    tt.setAddRowNumbering(true);
                    tt.setSort(0);
                    tt.printTable();

                    result = "\nNOTE : " +
                            "\nThis are all Leave application for Employee " +
                            "\n(if accepted Leave application than status show true otherwise false)";
                } else {

                    LeaveApplicationException applicationException = new LeaveApplicationException("Leave Application Is Not Found This Employee Id");

                    throw applicationException;


                }

            } else {
                EmployeeException employeeException = new EmployeeException("Employee Is Not Found By Given Employee Id...");
                throw employeeException;

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return result;
    }

    @Override
    public String updateLeaveRequestLeaveApplicationId(int leaveApplicationId) throws LeaveApplicationException {
        String result = "Leave Application Not Update.....";

        try (Connection conn = DBUtility.provideConnection()) {
            PreparedStatement ps = conn.prepareStatement("select * from leave_application where  application=?");
            ps.setInt(1, leaveApplicationId);

            ResultSet rs = ps.executeQuery();


            if (rs.next()) {
                String statu = rs.getString("status");


                if (statu.equals("false")) {

                    PreparedStatement ps2 = conn.prepareStatement("Update leave_application set status=? where  application=?");
                    ps2.setString(1, "true");
                    ps2.setInt(2, leaveApplicationId);
                    int x = ps2.executeUpdate();
                    if (x > 0) {
                        result = "Leave Application Is Updated....";
                    } else {

                        LeaveApplicationException applicationException1 = new LeaveApplicationException("Leave Application Is Not Update...");
                        throw applicationException1;

                    }


                } else {

                    LeaveApplicationException applicationException2 = new LeaveApplicationException("Leave Application Is Already Accepted...");
                    throw applicationException2;
                }
            } else {
                LeaveApplicationException applicationException = new LeaveApplicationException("Invalid Leave Application Id Please Give Proper Application Id");
                throw applicationException;
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public String deleteEmployee(int EmployeeId) throws EmployeeException, UpdateException {

        String result = "Employee Delete is Failed.....";


        try (Connection conn = DBUtility.provideConnection()) {

            PreparedStatement ps1 = conn.prepareStatement("select * from employee where  employeeId=?");
            ps1.setInt(1, EmployeeId);

            ResultSet rs = ps1.executeQuery();

            if (rs.next()) {
                PreparedStatement ps2 = conn.prepareStatement("Delete from employee where employeeId=?");
                ps2.setInt(1, EmployeeId);
                int x = ps2.executeUpdate();

                PreparedStatement ps3 = conn.prepareStatement("Delete from leave_application where  employeeId=?");
                ps3.setInt(1, EmployeeId);
                int y = ps3.executeUpdate();

                if (x > 0) {

                    result = "Employee is Delete successfully...";

                } else {

                    UpdateException exception1 = new UpdateException("Employee Data Base Update Is Failed...");
                    throw exception1;

                }


            } else {
                EmployeeException employeeException = new EmployeeException("Employee Is Not Found By Given Employee Id...");
                throw employeeException;

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }


    @Override
    public String deleteDepartment(int DepartmentId) throws DepartmentException, UpdateException {

        String result = "Employee Delete is Failed.....";
        try (Connection conn = DBUtility.provideConnection()) {

            PreparedStatement ps1 = conn.prepareStatement("select * from department where  departmentId=?");
            ps1.setInt(1, DepartmentId);

            ResultSet rs = ps1.executeQuery();

            if (rs.next()) {
                PreparedStatement ps2 = conn.prepareStatement("Delete from department where departmentId=?");
                ps2.setInt(1, DepartmentId);

                int x = ps2.executeUpdate();

                if (x > 0) {

                    result = "Department is Delete successfully...";

                } else {

                    UpdateException exception1 = new UpdateException("Department Data Base Update Is Failed...");
                    throw exception1;

                }


            } else {
                DepartmentException departmentException = new DepartmentException("Department Is Not Found By Given  Department Id...");
                throw departmentException;


            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public Employee findEmployee(int EmployeeId) throws EmployeeException {

        Employee employee;

        try (Connection conn = DBUtility.provideConnection()) {

            PreparedStatement ps1 = conn.prepareStatement("select * from employee where  employeeId=?");
            ps1.setInt(1, EmployeeId);

            ResultSet resultSet = ps1.executeQuery();

            if (resultSet.next()) {

                int employeeId1 = resultSet.getInt("employeeId");
                String firstName = resultSet.getString("employee_first_name");
                String lastName = resultSet.getString("employee_last_name");
                String email = resultSet.getString("employee_email");
                String phoneNumber = resultSet.getString("employee_phone_number");
                int salary = resultSet.getInt("employee_salary");
                LocalDate date = resultSet.getDate("employee_hire_date").toLocalDate();
                int departmentId = resultSet.getInt("employee_departmentId");
                String passward = resultSet.getString("employee_password");
                String username = resultSet.getString("employee_username");

                employee = new Employee(employeeId1, firstName, lastName, email, phoneNumber, salary, date, departmentId, passward, username);

            } else {

                EmployeeException employeeException = new EmployeeException("Employee is not found By Given Employee Id...");
                throw employeeException;
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return employee;
    }

    @Override
    public Department findDepartment(int DepartmentId) throws DepartmentException {

        Department department = null;
        try (Connection conn = DBUtility.provideConnection()) {

            PreparedStatement ps1 = conn.prepareStatement("select * from department where  departmentId=?");
            ps1.setInt(1, DepartmentId);

            ResultSet resultSet = ps1.executeQuery();

            if (resultSet.next()) {

                int departmentId = resultSet.getInt("departmentId");
                String departmentName = resultSet.getString("department_name");
                String departmentLocation = resultSet.getString("department_location");

                department = new Department(departmentId, departmentName, departmentLocation);


            } else {

                DepartmentException departmentException = new DepartmentException("Department is not Find by Given Department Id....");
                throw departmentException;

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return department;
    }

    @Override
    public void getAllEmployee() throws EmployeeException {

        try (Connection conn = DBUtility.provideConnection()) {

            PreparedStatement ps5 = conn.prepareStatement("select count(*) from employee");
            ResultSet rs5 = ps5.executeQuery();
            rs5.next();
            int count = rs5.getInt(1);


            if (count > 0) {
                PreparedStatement ps1 = conn.prepareStatement("select * from employee");
                ResultSet resultSet = ps1.executeQuery();

                String[] columnNames = {
                        "employeeId",
                        "employee_first_name",
                        "employee_last_name",
                        "employee_email",
                        "employee_phone_number",
                        "employee_hire_date",
                        "mployee_departmentId"
                };
                Object[][] data = new Object[count][7];
                int index = 0;


                while (resultSet.next()) {
                    int employeeId1 = resultSet.getInt("employeeId");
                    String firstName = resultSet.getString("employee_first_name");
                    String lastName = resultSet.getString("employee_last_name");
                    String email = resultSet.getString("employee_email");
                    String phoneNumber = resultSet.getString("employee_phone_number");
                    int salary = resultSet.getInt("employee_salary");
                    LocalDate date = resultSet.getDate("employee_hire_date").toLocalDate();
                    int departmentId = resultSet.getInt("employee_departmentId");

                    Object[] obj = {employeeId1,firstName,lastName,email,phoneNumber,salary,date,departmentId};
                    data[index] = obj;
                    index = index + 1;
                }

                TextTable tt = new TextTable(columnNames, data);
                tt.setAddRowNumbering(true);
                tt.setSort(0);
                tt.printTable();

            }
            else{

                EmployeeException employeeException=new EmployeeException("Employee DataBase Is Empty....");
                throw employeeException;

            }
            }catch(SQLException e){
                throw new RuntimeException(e);
            }

        }






    @Override
    public void getAllDepartment() throws DepartmentException {
        try (Connection conn = DBUtility.provideConnection()) {

            PreparedStatement ps5 = conn.prepareStatement("select count(*) from department");
            ResultSet rs5 = ps5.executeQuery();
            rs5.next();
            int count = rs5.getInt(1);


            if (count > 0) {
                PreparedStatement ps1 = conn.prepareStatement("select * from department");
                ResultSet resultSet = ps1.executeQuery();

                String[] columnNames = {
                        "departmentId",
                        "department_name",
                        "department_location"

                };
                Object[][] data = new Object[count][3];
                int index = 0;


                while (resultSet.next()) {
                    int departmentId = resultSet.getInt("departmentId");
                    String departmentName = resultSet.getString("department_name");
                    String departmentLocation = resultSet.getString("department_location");



                    Object[] obj = {departmentId, departmentName, departmentLocation};
                    data[index] = obj;
                    index = index + 1;
                }

                TextTable tt = new TextTable(columnNames, data);
                tt.setAddRowNumbering(true);
                tt.setSort(0);
                tt.printTable();

            }
            else{

                DepartmentException departmentException=new DepartmentException("Department DataBase Is Empty....");
                throw departmentException;

            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }

    }
}
