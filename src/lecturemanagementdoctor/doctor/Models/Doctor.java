package lecturemanagementdoctor.doctor.Models;

/**
 *
 * @author Saad Alenany
 */
public class Doctor extends User {

    private int Doctor_id;
    private int numberOfQuizes;
    private int doctor_course;

    public Doctor(int doctor_id, int numberOfQuizes, int doctor_course, String user_name, String user_email, String user_password, int user_department, String user_phone, boolean user_gender, byte user_status) {
        super(doctor_id,user_name, user_email, user_password, user_department, user_phone, user_gender, user_status);
        this.Doctor_id = doctor_id;
        this.numberOfQuizes = numberOfQuizes;
        this.doctor_course = doctor_course;
    }

    public Doctor(int doctor_id, int numberOfQuizes, int doctor_course) {
        this.Doctor_id = doctor_id;
        this.numberOfQuizes = numberOfQuizes;
        this.doctor_course = doctor_course;
    }

    public int getDoctor_course() {
        return doctor_course;
    }

    public void setDoctor_course(int doctor_course) {
        this.doctor_course = doctor_course;
    }

    public int getDoctor_id() {
        return Doctor_id;
    }

    public void setDoctor_id(int Doctor_id) {
        this.Doctor_id = Doctor_id;
    }

    public int getNumberOfQuizes() {
        return numberOfQuizes;
    }

    public void setNumberOfQuizes(int numberOfQuizes) {
        this.numberOfQuizes = numberOfQuizes;
    }

    @Override
    public String toString() {
        return "Doctor{" + "doctor_id=" + Doctor_id + ", numberOfQuizes=" + numberOfQuizes + ", doctor_course=" + doctor_course + '}';
    }

}
