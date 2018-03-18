/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturemanagementdoctor.doctor.lecture.openning.signup.second;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import lecturemanagementdoctor.doctor.Styles;
import lecturemanagementdoctor.doctor.Utility.LoadFXML;
import lecturemanagementdoctor.doctor.animation.fade.Fade;
import lecturemanagementdoctor.doctor.animation.fade.FadeIn;
import lecturemanagementdoctor.doctor.animation.fade.FadeOut;
import lecturemanagementdoctor.doctor.constant.FXMLPath;
import lecturemanagementdoctor.doctor.lecture.openning.signup.first.FirstSignupFXMLController;

/**
 * FXML Controller class
 *
 * @author Amr
 */
public class SecSignupFXMLController implements Initializable {

    @FXML
    private JFXTextField Academic_ID;

    @FXML
    private JFXTextField phone;

    @FXML
    private JFXRadioButton genderRadio;

    @FXML
    private VBox SecSignUpPane;

    @FXML
    private JFXTextField department;

    @FXML
    private Text BackText;

    //---------------------------------------
    private Parent firstSignUp;
    private BorderPane mainPane;

    @FXML
    void SignUpAction(ActionEvent event) {

    }

    @FXML
    void BackEnter(MouseEvent event) {
        BackText.setFill(Color.web(Styles.colorPrimary));
    }

    @FXML
    void BackExit(MouseEvent event) {
        BackText.setFill(Color.web(Styles.colorGrey));
    }

    @FXML
    void releaseBack(MouseEvent event) {
        LoadFirstSignUp();
        FadeOut fadeout = new FadeOut(SecSignUpPane, Fade.FADE_UP);
        fadeout.start();
        fadeout.setAfterAnimationListener(() -> {
            mainPane.setCenter(null);
            mainPane.setCenter(firstSignUp);
            FadeIn fadein = new FadeIn(firstSignUp, Fade.FADE_DOWN);
            fadein.start();
        });
    }

    private void LoadFirstSignUp() {
        LoadFXML load = new LoadFXML();
        load.LoadFXML(FXMLPath.FIRST_SIGNUP);
        FirstSignupFXMLController controller = (FirstSignupFXMLController) load.getController();
        controller.setMainPane(mainPane);
        firstSignUp = load.getParent();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SecSignUpPane.setStyle("-fx-background-color: rgba(150, 150, 150, 0.5); -fx-background-radius: 10;");
    }

    public void setMainPane(BorderPane mainPane) {
        this.mainPane = mainPane;
    }

}
