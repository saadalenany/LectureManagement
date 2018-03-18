package lecturemanagementdoctor.doctor.Models;

/**
 *
 * @author Saad Alenany
 */
public class Student extends User{

    private int Student_id;
    private int academic_year;

    public Student(int student_id,String user_name, String user_email, String user_password, int user_department, String user_phone, boolean user_gender, byte user_status, int academic_year) {
        super(student_id, user_name, user_email, user_password, user_department, user_phone, user_gender, user_status);
        this.Student_id = student_id;
        this.academic_year = academic_year;
    }

    public Student(int student_id, int academic_year) {
        this.Student_id = student_id;
        this.academic_year = academic_year;
    }

    public int getAcademic_year() {
        return academic_year;
    }

    public void setAcademic_year(int academic_year) {
        this.academic_year = academic_year;
    }

    public int getStudent_id() {
        return Student_id;
    }

    public void setStudent_id(int Student_id) {
        this.Student_id = Student_id;
    }

    @Override
    public String toString() {
        return "Student{" + "student_id=" + Student_id + ", academic_year=" + academic_year + '}';
    }

}
