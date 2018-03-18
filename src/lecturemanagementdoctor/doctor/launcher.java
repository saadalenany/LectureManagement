/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturemanagementdoctor.doctor;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import lecturemanagementdoctor.doctor.Utility.LoadFXML;
import lecturemanagementdoctor.doctor.constant.FXMLPath;
import lecturemanagementdoctor.doctor.Utility.Stage.undecoratedStage.StageStyle;
import lecturemanagementdoctor.doctor.constant.Container;
import lecturemanagementdoctor.doctor.constant.Path;
import lecturemanagementdoctor.doctor.lecture.openning.OpenningController;

/**
 *
 * @author Amr
 */
public class launcher extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        LoadFXML load = new LoadFXML();
        load.LoadFXML(FXMLPath.OPENNING);
        OpenningController controller = (OpenningController) load.getController();
        Pane p = (Pane) load.getParent();

        stage.initStyle(javafx.stage.StageStyle.UNDECORATED);
        Scene scene = new Scene(load.getParent(), 900, 600);
        stage.setScene(scene);
        stage.show();
        StageStyle.undecoratedStageOptions(stage, controller.getBorder());
        Container.MAIN_STAGE = stage;
        p.setStyle("-fx-background-image: url('" + Path.BACKGROUND + "');"
                + "-fx-background-position: center center;"
                + "-fx-background-repeat : stretch;"
                + "-fx-background-size: cover;");

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
