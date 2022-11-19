package Bean;

public class Admin {

   private int adminId;
   private String admin_first_name;
   private String  admin_last_name;
   private String admin_email;
   private String admin_phone_number;
   private String admin_password;
    private String admin_username;

    public Admin() {
    }

    public Admin(String admin_first_name, String admin_last_name, String admin_email, String admin_phone_number, String admin_password, String admin_username) {
        this.admin_first_name = admin_first_name;
        this.admin_last_name = admin_last_name;
        this.admin_email = admin_email;
        this.admin_phone_number = admin_phone_number;
        this.admin_password = admin_password;
        this.admin_username = admin_username;
    }

    public Admin(int adminId, String admin_first_name, String admin_last_name, String admin_email, String admin_phone_number, String admin_password, String admin_username) {
        this.adminId = adminId;
        this.admin_first_name = admin_first_name;
        this.admin_last_name = admin_last_name;
        this.admin_email = admin_email;
        this.admin_phone_number = admin_phone_number;
        this.admin_password = admin_password;
        this.admin_username = admin_username;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAdmin_first_name() {
        return admin_first_name;
    }

    public void setAdmin_first_name(String admin_first_name) {
        this.admin_first_name = admin_first_name;
    }

    public String getAdmin_last_name() {
        return admin_last_name;
    }

    public void setAdmin_last_name(String admin_last_name) {
        this.admin_last_name = admin_last_name;
    }

    public String getAdmin_email() {
        return admin_email;
    }

    public void setAdmin_email(String admin_email) {
        this.admin_email = admin_email;
    }

    public String getAdmin_phone_number() {
        return admin_phone_number;
    }

    public void setAdmin_phone_number(String admin_phone_number) {
        this.admin_phone_number = admin_phone_number;
    }

    public String getAdmin_password() {
        return admin_password;
    }

    public void setAdmin_password(String admin_password) {
        this.admin_password = admin_password;
    }

    public String getAdmin_username() {
        return admin_username;
    }

    public void setAdmin_username(String admin_username) {
        this.admin_username = admin_username;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", admin_first_name='" + admin_first_name + '\'' +
                ", admin_last_name='" + admin_last_name + '\'' +
                ", admin_email='" + admin_email + '\'' +
                ", admin_phone_number='" + admin_phone_number + '\'' +
                ", admin_password='" + admin_password + '\'' +
                ", admin_username='" + admin_username + '\'' +
                '}';
    }
}
