package lecturemanagementdoctor.doctor.Models;

/**
 *
 * @author Saad Alenany
 */
public class Lecture {

    private int Lecture_id;
    private String lecture_name;
    private String slide_path;
    private int doctor_id;
    private int course_id;

    public Lecture(int lecture_id, String lecture_name, String slide_path, int doctor_id, int course_id) {
        this.Lecture_id = lecture_id;
        this.lecture_name = lecture_name;
        this.slide_path = slide_path;
        this.doctor_id = doctor_id;
        this.course_id = course_id;
    }

    public Lecture(String lecture_name, String slide_path, int doctor_id, int course_id) {
        this.lecture_name = lecture_name;
        this.slide_path = slide_path;
        this.doctor_id = doctor_id;
        this.course_id = course_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getLecture_id() {
        return Lecture_id;
    }

    public void setLecture_id(int Lecture_id) {
        this.Lecture_id = Lecture_id;
    }

    public String getLecture_name() {
        return lecture_name;
    }

    public void setLecture_name(String lecture_name) {
        this.lecture_name = lecture_name;
    }

    public String getSlide_path() {
        return slide_path;
    }

    public void setSlide_path(String slide_path) {
        this.slide_path = slide_path;
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    @Override
    public String toString() {
        return "Lecture{" + "lecture_id=" + Lecture_id + ", lecture_name=" + lecture_name + ", slide_path=" + slide_path + ", doctor_id=" + doctor_id + ", course_id=" + course_id + '}';
    }

}
