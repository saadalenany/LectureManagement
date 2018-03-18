/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturemanagementdoctor.doctor.lecture.openning.login;

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
import lecturemanagementdoctor.doctor.Utility.Stage.undecoratedStage.StageStyle;
import lecturemanagementdoctor.doctor.animation.fade.Fade;
import lecturemanagementdoctor.doctor.animation.fade.FadeIn;
import lecturemanagementdoctor.doctor.animation.fade.FadeOut;
import lecturemanagementdoctor.doctor.constant.Container;
import lecturemanagementdoctor.doctor.constant.FXMLPath;
import lecturemanagementdoctor.doctor.lecture.main.MainFXMLController;
import lecturemanagementdoctor.doctor.lecture.openning.signup.first.FirstSignupFXMLController;

/**
 * FXML Controller class
 *
 * @author Amr
 */
public class LoginFXMLController implements Initializable {

    @FXML
    private VBox LoginPane;
    @FXML
    private Label SignUpText;
    @FXML
    private Label forgotPassword;
    // ------------------------ 
    private Parent firstSignUp;

    private BorderPane mainPane;

    @FXML
    void LoginAction(ActionEvent event) {
        // load main
        LoadFXML load = new LoadFXML();
        load.LoadFXML(FXMLPath.MAIN);
        MainFXMLController controller = (MainFXMLController) load.getController();
        mainPane.getScene().setRoot(load.getParent());
        StageStyle.undecoratedStageOptions(Container.MAIN_STAGE, controller.getBorder());
    }

    @FXML
    void SignUpEnter(MouseEvent event) {
        SignUpText.setTextFill(Color.web(Styles.colorSecondary));
    }

    @FXML
    void SignUpExit(MouseEvent event) {
        SignUpText.setTextFill(Color.web(Styles.colorPrimary));
    }

    @FXML
    void forgotPasswordEnter(MouseEvent event) {
        forgotPassword.setTextFill(Color.web(Styles.colorSecondary));
    }

    @FXML
    void forgotPasswordExit(MouseEvent event) {
        forgotPassword.setTextFill(Color.web(Styles.colorGrey));
    }

    @FXML
    void SignUpRelease(MouseEvent event) {
        LoadFirstSignUp();
        FadeOut fadeout = new FadeOut(LoginPane, Fade.FADE_DOWN);
        fadeout.start();
        fadeout.setAfterAnimationListener(() -> {
            mainPane.setCenter(null);
            mainPane.setCenter(firstSignUp);
            FadeIn fadein = new FadeIn(firstSignUp, Fade.FADE_UP);
            fadein.start();
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        LoginPane.setStyle("-fx-background-color: rgba(150, 150, 150, 0.5); -fx-background-radius: 10;");

    }

    private void LoadFirstSignUp() {
        LoadFXML load = new LoadFXML();
        load.LoadFXML(FXMLPath.FIRST_SIGNUP);
        FirstSignupFXMLController controller = (FirstSignupFXMLController) load.getController();
        controller.setMainPane(mainPane);
        firstSignUp = load.getParent();
    }

    public void setMainPane(BorderPane mainPane) {
        this.mainPane = mainPane;
    }

}
