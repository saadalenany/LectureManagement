package lecturemanagementdoctor.doctor.Models;

/**
 *
 * @author Saad Alenany
 */
public class Courses {

    private int Courses_id;
    private String course_name;

    public Courses(int course_id, String course_name) {
        this.Courses_id = course_id;
        this.course_name = course_name;
    }

    public Courses(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public int getCourses_id() {
        return Courses_id;
    }

    public void setCourses_id(int Courses_id) {
        this.Courses_id = Courses_id;
    }

    @Override
    public String toString() {
        return "Courses{" + "course_id=" + Courses_id + ", course_name=" + course_name + '}';
    }

}
