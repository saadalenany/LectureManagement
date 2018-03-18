/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturemanagementdoctor.doctor.lecture.openning;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lecturemanagementdoctor.doctor.Utility.Effect;
import lecturemanagementdoctor.doctor.Utility.LoadFXML;
import lecturemanagementdoctor.doctor.constant.Colors;
import lecturemanagementdoctor.doctor.constant.FXMLPath;
import lecturemanagementdoctor.doctor.lecture.openning.login.LoginFXMLController;

/**
 *
 * @author Amr
 */
public class OpenningController implements Initializable {

    @FXML
    private BorderPane border;

    @FXML
    private ImageView min;

    @FXML
    private ImageView max;

    @FXML
    private ImageView close;

    @FXML
    private BorderPane mainPane;

    @FXML
    void closeAction(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void maxAction(ActionEvent event) {
        Stage stage = (Stage)max.getScene().getWindow();
        if (stage.isFullScreen()) {
            stage.setFullScreen(false);
        }else{
            stage.setFullScreen(true);
        }
    }

    @FXML
    void minAction(ActionEvent event) {
        Stage stage = (Stage)max.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    void minEnter(MouseEvent event) {
        Effect.setImageColor(min, Colors.ENTER_COLOR);
    }

    @FXML
    void minExit(MouseEvent event) {
        Effect.setImageColor(min, Colors.EXIT_COLOR);
    }

    @FXML
    void maxEnter(MouseEvent event) {
        Effect.setImageColor(max, Colors.ENTER_COLOR);
    }

    @FXML
    void maxExit(MouseEvent event) {
        Effect.setImageColor(max, Colors.EXIT_COLOR);
    }

    @FXML
    void closeEnter(MouseEvent event) {
        Effect.setImageColor(close, Colors.ENTER_COLOR);
    }

    @FXML
    void closeExit(MouseEvent event) {
        Effect.setImageColor(close, Colors.EXIT_COLOR);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Effect.setImageColor(min, Colors.EXIT_COLOR);
        Effect.setImageColor(max, Colors.EXIT_COLOR);
        Effect.setImageColor(close, Colors.EXIT_COLOR);
        // ---------------------------------------------
        // load login 
        LoadFXML load = new LoadFXML();
        load.LoadFXML(FXMLPath.LOGIN);
        LoginFXMLController controller = (LoginFXMLController) load.getController();
        controller.setMainPane(mainPane);
        VBox b = (VBox) load.getParent();
        mainPane.setCenter(b);

    }

    public BorderPane getBorder() {
        return border;
    }

}
