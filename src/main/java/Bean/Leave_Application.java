package Bean;

import java.time.LocalDate;

public class Leave_Application {

   private int application;
   private int employeeId;
   private String leave_type;
   private LocalDate  from_date;
   private LocalDate to_date;
   private int total_days;
   private String  remark;
   private String status="false";
   private String note;


    public Leave_Application(int application, int employeeId, String leave_type, LocalDate from_date, LocalDate to_date, int total_days, String remark, String status, String note) {
        this.application = application;
        this.employeeId = employeeId;
        this.leave_type = leave_type;
        this.from_date = from_date;
        this.to_date = to_date;
        this.total_days = total_days;
        this.remark = remark;
        this.status = status;
        this.note = note;
    }

    public Leave_Application() {
    }

    public Leave_Application(int employeeId, String leave_type, LocalDate from_date, LocalDate to_date, int total_days, String remark, String status, String note) {
        this.employeeId = employeeId;
        this.leave_type = leave_type;
        this.from_date = from_date;
        this.to_date = to_date;
        this.total_days = total_days;
        this.remark = remark;
        this.status = status;
        this.note = note;
    }

    public int getApplication() {
        return application;
    }

    public void setApplication(int application) {
        this.application = application;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getLeave_type() {
        return leave_type;
    }

    public void setLeave_type(String leave_type) {
        this.leave_type = leave_type;
    }

    public LocalDate getFrom_date() {
        return from_date;
    }

    public void setFrom_date(LocalDate from_date) {
        this.from_date = from_date;
    }

    public LocalDate getTo_date() {
        return to_date;
    }

    public void setTo_date(LocalDate to_date) {
        this.to_date = to_date;
    }

    public int getTotal_days() {
        return total_days;
    }

    public void setTotal_days(int total_days) {
        this.total_days = total_days;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Leave_Application{" +
                "application=" + application +
                ", employeeId=" + employeeId +
                ", leave_type='" + leave_type + '\'' +
                ", from_date=" + from_date +
                ", to_date=" + to_date +
                ", total_days=" + total_days +
                ", remark='" + remark + '\'' +
                ", status='" + status + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
