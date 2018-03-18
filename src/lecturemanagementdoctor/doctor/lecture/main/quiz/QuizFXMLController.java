/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturemanagementdoctor.doctor.lecture.main.quiz;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Separator;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import lecturemanagementdoctor.doctor.Styles;
import lecturemanagementdoctor.doctor.controllers.Validator;

/**
 *
 * @author Saad Alenany
 */
public class QuizFXMLController implements Initializable {

    @FXML
    VBox scrollcontent;

    @FXML
    JFXTextField numberOfChoices , quiz_name , timePerMinute;

    @FXML
    JFXButton add , remove , send;

    @FXML
    JFXCheckBox allowmarks;

    int noc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        new Validator().ValidateNumber(numberOfChoices);
    }

    @FXML
    protected void onAdd(){
        noc = 0;
        try {
            noc = Integer.parseInt(numberOfChoices.getText());
        } catch (NumberFormatException numberFormatException) {}

        if (noc > 0) {
            numberOfChoices.setEditable(false);
            scrollcontent.getChildren().add(generateField());
        }else {}

    }

    @FXML
    protected void onRemove(){
        if (scrollcontent.getChildren().size() > 0) {
            scrollcontent.getChildren().remove(scrollcontent.getChildren().size()-1);
        }
    }

    @FXML
    protected void onSend(){
        String quizname = quiz_name.getText();
        int tpm = 0;
        try {
            tpm = Integer.parseInt(timePerMinute.getText());
        } catch (NumberFormatException numberFormatException) {
        }
        if (!quizname.equals("") && tpm > 0) {
            QuizDataOrganizer qdo = new QuizDataOrganizer(quizname,noc,tpm,allowmarks.isSelected(),scrollcontent);
        }else{
            System.err.println("checkout Quiz name or time per minute");
        }
    }

    private VBox generateField(){
        VBox questionBox = new VBox(20);
        questionBox.setPadding(new Insets(20, 5, 5, 5));
        questionBox.setStyle("-fx-border-color:"+Styles.colorPrimary+" ;");
        questionBox.setAlignment(Pos.CENTER);

        JFXTextField questionContent = new JFXTextField();
        questionContent.setPromptText("Type the Question");
        questionContent.setLabelFloat(true);

        questionBox.getChildren().addAll(questionContent,generateChoices());

        return questionBox;
    }

    private VBox generateChoices(){
        VBox choicesBox = new VBox(15);
        choicesBox.setAlignment(Pos.CENTER);
        choicesBox.setPadding(new Insets(0, 0, 0, 20));

        ToggleGroup toggleGroup = new ToggleGroup();
        for (int i = 0; i < noc; i++) {
            HBox choiceHBox = new HBox(5);

            JFXRadioButton radioButton = new JFXRadioButton();
            radioButton.setToggleGroup(toggleGroup);

            JFXTextField choiceField = new JFXTextField();
            choiceField.setPromptText("Click to type answer "+(i+1));
            choiceField.setLabelFloat(true);

            choiceHBox.getChildren().addAll(radioButton,choiceField);
            choicesBox.getChildren().add(choiceHBox);
        }

        return choicesBox;
    }

    private Separator generateSeparator(){
        Separator separator = new Separator(Orientation.HORIZONTAL);
        return separator;
    }

}
