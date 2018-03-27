package lecturemanagementdoctor.doctor.Database;

/**
 *
 * @author Saad Alenany
 */
public class StaticsQueries {

    public static final String CREATE_DEPARTMENT = "CREATE TABLE IF NOT EXISTS Department (\n"
            + "	Department_id integer PRIMARY KEY AUTOINCREMENT,\n"
            + "	department_name integer\n"
            + ");";

    public static final String CREATE_ACADEMIC_YEAR = "CREATE TABLE IF NOT EXISTS Academic_Year (\n"
            + "	Academic_Year_id integer PRIMARY KEY AUTOINCREMENT,\n"
            + "	academic_year integer\n"
            + ");";

    public static final String CREATE_COURSES = "CREATE TABLE IF NOT EXISTS Courses (\n"
            + "	Courses_id integer PRIMARY KEY AUTOINCREMENT,\n"
            + "	course_name text\n"
            + ");";

    public static final String CREATE_USER = "CREATE TABLE IF NOT EXISTS User (\n"
            + "	User_id integer PRIMARY KEY AUTOINCREMENT,\n"
            + "	user_name text,\n"
            + "	user_email text,\n"
            + "	user_password text,\n"
            + "	user_department integer,\n"
            + "	user_phone text,\n"
            + "	user_gender boolean,\n"
            + "	user_status binary,\n"
            + "        FOREIGN KEY (user_department) REFERENCES Department(Department_id)\n"
            + ");";

    public static final String CREATE_STUDENT = "CREATE TABLE IF NOT EXISTS Student (\n"
            + "	Student_id integer,\n"
            + "	academic_year integer,\n"
            + "        FOREIGN KEY (student_id) REFERENCES User(User_id)\n"
            + ");";

    public static final String CREATE_DOCTOR = "CREATE TABLE IF NOT EXISTS Doctor (\n"
            + "	Doctor_id integer,\n"
            + "	numberOfQuizes integer,\n"
            + "	doctor_course integer,\n"
            + "        FOREIGN KEY (doctor_id) REFERENCES User(User_id),\n"
            + "		FOREIGN KEY (doctor_course) REFERENCES Courses(Courses_id)\n"
            + ");";

    public static final String CREATE_LECTURE = "CREATE TABLE IF NOT EXISTS Lecture (\n"
            + "	Lecture_id integer PRIMARY KEY AUTOINCREMENT,\n"
            + "	lecture_name text,\n"
            + "	doctor_id integer,\n"
            + "	course_id integer,\n"
            + "		FOREIGN KEY (doctor_id) REFERENCES Doctor(Doctor_id),\n"
            + "		FOREIGN KEY (course_id) REFERENCES Courses(Courses_id)\n"
            + ");";

    public static final String CREATE_QUIZ = "CREATE TABLE IF NOT EXISTS Quiz (\n"
            + "	Quiz_id integer PRIMARY KEY AUTOINCREMENT,\n"
            + "	quiz_name text,\n"
            + "	course_id integer,\n"
            + "		FOREIGN KEY (course_id) REFERENCES Courses(Courses_id)\n"
            + ");";

    public static final String CREATE_QUIZQUESTION = "CREATE TABLE IF NOT EXISTS QuizQuestion (\n"
            + "	QuizQuestion_id integer PRIMARY KEY AUTOINCREMENT,\n"
            + "	numberofchoices integer,\n"
            + "	question_data text,\n"
            + "	right_answer integer,\n"
            + "	quiz_id integer,\n"
            + "		FOREIGN KEY (quiz_id) REFERENCES Quiz(Quiz_id)\n"
            + ");";

    public static final String CREATE_CHAT = "CREATE TABLE IF NOT EXISTS Chat (\n"
            + "	Chat_id integer PRIMARY KEY AUTOINCREMENT,\n"
            + "	sender_id integer,\n"
            + "	reciever_id integer,\n"
            + "	message_content text,\n"
            + "	message_date date,\n"
            + "	message_lecture integer,\n"
            + "		FOREIGN KEY (sender_id) REFERENCES User(User_id),\n"
            + "		FOREIGN KEY (reciever_id) REFERENCES User(User_id),\n"
            + "		FOREIGN KEY (message_lecture) REFERENCES Lecture(Lecture_id)\n"
            + ");";

    public static final String CREATE_CHOICEDATA = "CREATE TABLE ChoiceData (\n"
            + "	choice_id integer PRIMARY KEY AUTOINCREMENT,\n"
            + "	choice_content text,\n"
            + "	question_id integer,\n"
            + "		FOREIGN KEY (question_id) REFERENCES QuizQuestion(QuizQuestion_id)\n"
            + ");";

    public static final String CREATE_SLIDE = "CREATE TABLE Slide (\n"
            + "	slide_id integer PRIMARY KEY AUTOINCREMENT,\n"
            + "	slide_path string,\n"
            + "	lecture_id integer,\n"
            + "		FOREIGN KEY (slide_id) REFERENCES Lecture(Lecture_id)\n"
            + ");";

    public static String DROP_USER = "DROP TABLE User;";
    public static String DROP_DEPARTMENT = "DROP TABLE Department;";
    public static String DROP_ACADEMIC_YEAR = "DROP TABLE Academic_Year;";
    public static String DROP_COURSES = "DROP TABLE Courses;";
    public static String DROP_STUDENT = "DROP TABLE Student;";
    public static String DROP_DOCTOR = "DROP TABLE Doctor;";
    public static String DROP_LECTURE = "DROP TABLE Lecture;";
    public static String DROP_QUIZ = "DROP TABLE Quiz;";
    public static String DROP_QUIZQUESTION = "DROP TABLE QuizQuestion;";
    public static String DROP_CHAT = "DROP TABLE Chat;";
    public static String DROP_CHOICEDATA = "DROP TABLE ChoiceData;";
    public static String DROP_SLIDE = "DROP TABLE Slide;";

}
