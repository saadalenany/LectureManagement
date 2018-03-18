/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturemanagementdoctor.doctor.lecture.openning.signup.first;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import lecturemanagementdoctor.doctor.Styles;
import lecturemanagementdoctor.doctor.Utility.LoadFXML;
import lecturemanagementdoctor.doctor.animation.fade.Fade;
import lecturemanagementdoctor.doctor.animation.fade.FadeIn;
import lecturemanagementdoctor.doctor.animation.fade.FadeOut;
import lecturemanagementdoctor.doctor.constant.FXMLPath;
import lecturemanagementdoctor.doctor.lecture.openning.login.LoginFXMLController;
import lecturemanagementdoctor.doctor.lecture.openning.signup.second.SecSignupFXMLController;

/**
 * FXML Controller class
 *
 * @author Amr
 */
public class FirstSignupFXMLController implements Initializable {

    @FXML
    private JFXPasswordField password;

    @FXML
    private VBox FirstSignUpPane;

    @FXML
    private JFXPasswordField re_password;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXTextField username;

    @FXML
    private Label LoginText;

    // ------------------------------------
    VBox LoginPane;

    private BorderPane mainPane;

    private Parent SecSignUp;

    @FXML
    void NextAction(ActionEvent event) {
        LoadSecSignUp();
        FadeOut fadeout = new FadeOut(FirstSignUpPane, Fade.FADE_DOWN);
        fadeout.start();
        fadeout.setAfterAnimationListener(() -> {
            mainPane.setCenter(null);
            mainPane.setCenter(SecSignUp);
            FadeIn fadein = new FadeIn(SecSignUp, Fade.FADE_UP);
            fadein.start();
        });

    }

    @FXML
    void enterLogin(MouseEvent event) {
        LoginText.setTextFill(Color.web(Styles.colorPrimary));
    }

    @FXML
    void exitLogin(MouseEvent event) {
        LoginText.setTextFill(Color.web(Styles.colorGrey));
    }

    @FXML
    void LoginRelease(MouseEvent event) {
        LoadLogin();
        FadeOut fadeout = new FadeOut(FirstSignUpPane, Fade.FADE_UP);
        fadeout.start();
        fadeout.setAfterAnimationListener(() -> {
            mainPane.setCenter(null);
            mainPane.setCenter(LoginPane);
            FadeIn fadein = new FadeIn(LoginPane, Fade.FADE_DOWN);
            fadein.start();
        });

    }

    private void LoadLogin() {
        LoadFXML load = new LoadFXML();
        load.LoadFXML(FXMLPath.LOGIN);
        LoginFXMLController controller = (LoginFXMLController) load.getController();
        controller.setMainPane(mainPane);
        LoginPane = (VBox) load.getParent();
    }

    public void LoadSecSignUp() {
        LoadFXML load = new LoadFXML();
        load.LoadFXML(FXMLPath.SEC_SIGNUP);
        SecSignupFXMLController controller = (SecSignupFXMLController) load.getController();
        controller.setMainPane(mainPane);
        SecSignUp = load.getParent();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FirstSignUpPane.setStyle("-fx-background-color: rgba(150, 150, 150, 0.5); -fx-background-radius: 10;");

    }

    public void setMainPane(BorderPane mainPane) {
        this.mainPane = mainPane;
    }

}
