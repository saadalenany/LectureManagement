package lecturemanagementdoctor.doctor.Models;

/**
 *
 * @author Saad Alenany
 */
public class Quiz {

    private int Quiz_id;
    private String quiz_name;
    private int course_id;

    public Quiz(int quiz_id, String quiz_name, int course_id) {
        this.Quiz_id = quiz_id;
        this.quiz_name = quiz_name;
        this.course_id = course_id;
    }

    public Quiz(String quiz_name, int course_id) {
        this.quiz_name = quiz_name;
        this.course_id = course_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getQuiz_id() {
        return Quiz_id;
    }

    public void setQuiz_id(int Quiz_id) {
        this.Quiz_id = Quiz_id;
    }

    public String getQuiz_name() {
        return quiz_name;
    }

    public void setQuiz_name(String quiz_name) {
        this.quiz_name = quiz_name;
    }

    @Override
    public String toString() {
        return "Quiz{" + "quiz_id=" + Quiz_id + ", quiz_name=" + quiz_name + ", course_id=" + course_id + '}';
    }

}
