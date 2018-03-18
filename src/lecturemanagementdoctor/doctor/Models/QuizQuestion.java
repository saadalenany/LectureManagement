package lecturemanagementdoctor.doctor.Models;

/**
 *
 * @author Saad Alenany
 */
public class QuizQuestion {

    private int QuizQuestion_id;
    private int numberOfChoices;
    private String question_data;
    private int right_answer;
    private int quiz_id;

    public QuizQuestion(int question_id, int numberOfChoices, String question_data, int right_answer, int quiz_id) {
        this.QuizQuestion_id = question_id;
        this.numberOfChoices = numberOfChoices;
        this.question_data = question_data;
        this.right_answer = right_answer;
        this.quiz_id = quiz_id;
    }

    public QuizQuestion(int numberOfChoices, String question_data, int right_answer, int quiz_id) {
        this.numberOfChoices = numberOfChoices;
        this.question_data = question_data;
        this.right_answer = right_answer;
        this.quiz_id = quiz_id;
    }

    public int getQuiz_id() {
        return quiz_id;
    }

    public void setQuiz_id(int quiz_id) {
        this.quiz_id = quiz_id;
    }

    public int getQuizQuestion_id() {
        return QuizQuestion_id;
    }

    public void setQuizQuestion_id(int QuizQuestion_id) {
        this.QuizQuestion_id = QuizQuestion_id;
    }

    public int getNumberOfChoices() {
        return numberOfChoices;
    }

    public void setNumberOfChoices(int numberOfChoices) {
        this.numberOfChoices = numberOfChoices;
    }

    public String getQuestion_data() {
        return question_data;
    }

    public void setQuestion_data(String question_data) {
        this.question_data = question_data;
    }

    public int getRight_answer() {
        return right_answer;
    }

    public void setRight_answer(int right_answer) {
        this.right_answer = right_answer;
    }

    @Override
    public String toString() {
        return "QuizQuestion{" + "question_id=" + QuizQuestion_id + ", numberOfChoices=" + numberOfChoices + ", question_data=" + question_data + ", right_answer=" + right_answer + ", quiz_id=" + quiz_id + '}';
    }

}
