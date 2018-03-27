/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturemanagementdoctor.doctor.lecture.main;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import lecturemanagementdoctor.doctor.Styles;
import lecturemanagementdoctor.doctor.Utility.Effect;
import lecturemanagementdoctor.doctor.animation.openCloseList.OpenCloseList;
import lecturemanagementdoctor.doctor.constant.Colors;
import lecturemanagementdoctor.doctor.constant.Path;

/**
 * FXML Controller class
 *
 * @author Amr
 */
public class MainFXMLController implements Initializable {

    @FXML
    private ImageView msg;

    @FXML
    private ImageView request;

    @FXML
    private VBox list_box;

    @FXML
    private ImageView min;

    @FXML
    private ImageView arrow;

    @FXML
    private ImageView max;

    @FXML
    private ImageView profile;

    @FXML
    private ImageView close;

    @FXML
    private ImageView setting;

    @FXML
    private BorderPane Border;

    @FXML
    private BorderPane ListBordePane;

    @FXML
    private ScrollPane dynamicScroller;

    //------------------------------------------
    private OpenCloseList ListAnim;

    //------------------------------------------
    public static Pane[] Sessions = new Pane[5];

    @FXML
    void requestAction(ActionEvent event) {

    }

    @FXML
    void LectureClick(ActionEvent event) {
        setSession(0, "lecture/create/createLecture_fragment.fxml");
    }

    @FXML
    void statClick(ActionEvent event) {
        setSession(1, "stat/statFXML.fxml");
    }

    @FXML
    void QuizClick(ActionEvent event) {
        setSession(2, "quiz/quizFXML.fxml");
    }

    @FXML
    void AbsenseClick(ActionEvent event) {
        setSession(3, "absence/absenceFXML.fxml");
    }

    @FXML
    void chatClick(ActionEvent event) {
        setSession(4, "chat/chatFXML.fxml");
    }

    @FXML
    void msgAction(ActionEvent event) {

    }

    @FXML
    void arrowAction(ActionEvent event) {

        if (ListAnim.isClosed()) {
            ListAnim.StartOpenList();
        } else {
            ListAnim.StartCloseList();
        }
        ListAnim.setAfterAnimationListener(() -> {

            if (ListAnim.isClosed()) {
                arrow.setImage(new Image(Path.close_list));
            } else {
                arrow.setImage(new Image(Path.open_list));
            }

        });

    }

    @FXML
    void profileAction(ActionEvent event) {

    }

    @FXML
    void settingAction(ActionEvent event) {

    }

    //--------------------------------------------
    @FXML
    void iconEnter(MouseEvent event) {
        JFXButton src = (JFXButton) event.getSource();
        ImageView graphic = (ImageView) src.getGraphic();
        Effect.setImageColor(graphic, Color.web(Styles.colorIconHover));
    }

    @FXML
    void iconExit(MouseEvent event) {
        JFXButton src = (JFXButton) event.getSource();
        ImageView graphic = (ImageView) src.getGraphic();
        Effect.setImageColor(graphic, Color.web(Styles.colorWhite));
    }

    @FXML
    void arrowEntered(MouseEvent event) {
        Effect.setImageColor(arrow, Color.web(Styles.colorArrowHover));
    }

    @FXML
    void arrowExit(MouseEvent event) {
        Effect.setImageColor(arrow, Color.web(Styles.colorPrimary));
    }

    @FXML
    void closeAction(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void maxAction(ActionEvent event) {
        Stage stage = (Stage) max.getScene().getWindow();
        if (stage.isFullScreen()) {
            stage.setFullScreen(false);
        } else {
            stage.setFullScreen(true);
        }
    }

    @FXML
    void minAction(ActionEvent event) {
        Stage stage = (Stage) min.getScene().getWindow();
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

    }

    @FXML
    void closeExit(MouseEvent event) {

    }

    @FXML
    void onPlay(MouseEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        colorizeAllPics();

        ObservableList<Node> children = list_box.getChildren();
        JFXButton[] buttonList = new JFXButton[children.size()];
        for (int i = 0; i < children.size(); i++) {
            buttonList[i] = (JFXButton) children.get(i);
        }
        ListAnim = new OpenCloseList(buttonList, ListBordePane);
    }

    public Parent getBorder() {
        return Border;
    }

    private void colorizeAllPics() {
        Effect.setImageColor(msg, Color.web(Styles.colorWhite));
        Effect.setImageColor(request, Color.web(Styles.colorWhite));
        Effect.setImageColor(max, Color.web(Styles.colorWhite));
        Effect.setImageColor(min, Color.web(Styles.colorWhite));
        Effect.setImageColor(profile, Color.web(Styles.colorWhite));
        Effect.setImageColor(request, Color.web(Styles.colorWhite));
        Effect.setImageColor(setting, Color.web(Styles.colorWhite));

        Effect.setImageColor(close, Color.web(Styles.colorClose));
    }

    public void setSession(int index, String name) {
        if (Sessions[index] == null) {
            try {
                Sessions[index] = FXMLLoader.load(getClass().getResource(Path.sessions_path + name));
            } catch (IOException ex) {
                Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        dynamicScroller.setContent(Sessions[index]);
    }

    public ScrollPane getDynamicScroller() {
        return dynamicScroller;
    }

}
