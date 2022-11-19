package Bean;

public class Department {

    private int departmentId;
    private String department_name ;
    private String department_location;

    public Department(int departmentId, String department_name, String department_location) {
        this.departmentId = departmentId;
        this.department_name = department_name;
        this.department_location = department_location;
    }

    public Department(String department_name, String department_location) {
        this.department_name = department_name;
        this.department_location = department_location;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
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
        return "Department{" +
                "departmentId=" + departmentId +
                ", department_name='" + department_name + '\'' +
                ", department_location='" + department_location + '\'' +
                '}';
    }
}
