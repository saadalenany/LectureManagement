/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturemanagementdoctor.doctor.lecture.main.quiz;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.util.ArrayList;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import lecturemanagementdoctor.doctor.Models.ChoiceData;
import lecturemanagementdoctor.doctor.Models.QuizQuestion;

/**
 *
 * @author Saad Alenany
 */
public class QuizDataOrganizer {

    String quizname ;
    int noc;
    int tpm;
    boolean selected;
    VBox scrollcontent;

    public QuizDataOrganizer(String quizname, int noc, int tpm, boolean selected, VBox scrollcontent) {
        this.quizname = quizname;
        this.noc = noc;
        this.tpm = tpm;
        this.selected = selected;
        this.scrollcontent = scrollcontent;

        //extract Quiz data
        boolean returned = extractQuizData();
        if (!returned) {
            System.out.println("Quiz data not filled");
        }else{
            System.out.println("Quiz created successfully");
        }
    }

    private boolean extractQuizData() {
        ArrayList<QuizQuestion> quizQuestions = new ArrayList<>();
        for (Node child : scrollcontent.getChildren()) {
            String questionContent = "";
            int rightAns = -1;
            ArrayList<ChoiceData> arrayOfChoices = new ArrayList<>();
            if (child instanceof VBox) {
                questionContent = ((JFXTextField) ((VBox) child).getChildren().get(0)).getText();
                VBox choicesBox = (VBox) ((VBox) child).getChildren().get(1);
                for (int i=0 ; i<choicesBox.getChildren().size() ; i++) {
                    Node ch = choicesBox.getChildren().get(i);
                    if (ch instanceof HBox) {
                        JFXRadioButton radioButton = (JFXRadioButton) ((HBox) ch).getChildren().get(0);
                        if (radioButton.isSelected()) {
                            rightAns = i;
                        }
                        JFXTextField choiceAns = (JFXTextField) ((HBox) ch).getChildren().get(1);
                        String choiceData = choiceAns.getText();
                        if (!choiceData.equals("")) {
                            arrayOfChoices.add(new ChoiceData(choiceData,0));
                        }else{
                            return false;
                        }
                    }
                }
            }
            QuizQuestion quizQuestion = new QuizQuestion(noc, questionContent, rightAns, 0);
            quizQuestions.add(quizQuestion);
        }
        System.out.println("Quiz Questions "+quizQuestions);
        return true;
    }

}
