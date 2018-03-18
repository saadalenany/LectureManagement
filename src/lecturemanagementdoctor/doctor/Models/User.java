package lecturemanagementdoctor.doctor.Models;

/**
 *
 * @author Saad Alenany
 */
public class User {

    private int User_id;
    private String user_name;
    private String user_email;
    private String user_password;
    private int user_department;
    private String user_phone;
    private boolean user_gender;
    private byte user_status;

    public User(int user_id, String user_name, String user_email, String user_password, int user_department, String user_phone, boolean user_gender, byte user_status) {
        this.User_id = user_id;
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_password = user_password;
        this.user_department = user_department;
        this.user_phone = user_phone;
        this.user_gender = user_gender;
        this.user_status = user_status;
    }

    public User(String user_name, String user_email, String user_password, int user_department, String user_phone, boolean user_gender, byte user_status) {
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_password = user_password;
        this.user_department = user_department;
        this.user_phone = user_phone;
        this.user_gender = user_gender;
        this.user_status = user_status;
    }

    public User() {
    }

    public byte getUser_status() {
        return user_status;
    }

    public void setUser_status(byte user_status) {
        this.user_status = user_status;
    }

    public int getUser_id() {
        return User_id;
    }

    public void setUser_id(int User_id) {
        this.User_id = User_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public int getUser_department() {
        return user_department;
    }

    public void setUser_department(int user_department) {
        this.user_department = user_department;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public boolean isUser_gender() {
        return user_gender;
    }

    public void setUser_gender(boolean user_gender) {
        this.user_gender = user_gender;
    }

    @Override
    public String toString() {
        return "User{" + "user_id=" + User_id + ", user_name=" + user_name + ", user_email=" + user_email + ", user_password=" + user_password + ", user_department=" + user_department + ", user_phone=" + user_phone + ", user_gender=" + user_gender + ", user_status=" + user_status + '}';
    }

}
