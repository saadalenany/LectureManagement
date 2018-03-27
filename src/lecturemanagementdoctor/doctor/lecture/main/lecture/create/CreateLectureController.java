/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturemanagementdoctor.doctor.lecture.main.lecture.create;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXProgressBar;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import lecturemanagementdoctor.doctor.Utility.LoadFXML;
import lecturemanagementdoctor.doctor.Utility.Stage.undecoratedStage.StageStyle;
import lecturemanagementdoctor.doctor.controllers.PDFViewer;
import lecturemanagementdoctor.doctor.controllers.SlideConvertor;
import lecturemanagementdoctor.doctor.lecture.main.MainFXMLController;
import lecturemanagementdoctor.doctor.lecture.main.lecture.view.ViewLectureController;

/**
 *
 * @author Saad Alenany
 */
public class CreateLectureController implements Initializable {

    // create lecture FXML Components
    @FXML
    SplitPane splitPane;

    @FXML
    ListView listOfNewFiles;

    @FXML
    ListView listOfOldFiles;

    @FXML
    JFXProgressBar newBar;

    @FXML
    JFXProgressBar oldBar;

    @FXML
    Circle startButton;

    @FXML
    JFXButton startOldButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    protected void onUploadNewFiles() {
        System.out.println("onUploadNewFiles");
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Upload New Files");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Files", "*.*"),
                new FileChooser.ExtensionFilter("PPT", "*.ppt"),
                new FileChooser.ExtensionFilter("PPTX", "*.pptx"),
                new FileChooser.ExtensionFilter("PDF", "*.pdf")
        );
        List<File> files = fileChooser.showOpenMultipleDialog(new Stage());
        System.out.println("files " + files);

        if (files != null) {
            listOfNewFiles.getItems().addAll(files);
        }
    }

    @FXML
    protected void onStartLectureWithOldFiles() {
        startOldButton.setDisable(true);
        System.out.println("onStartLectureWithOldFiles");
    }

    @FXML
    protected void onStart(MouseEvent mouseEvent) {
        startButton.setDisable(true);
        newBar.setVisible(true);

        Stage createStage = new Stage();
        if (listOfNewFiles.getSelectionModel().getSelectedIndex() > -1) {
            if (!createStage.isShowing()) {
                String filename = String.valueOf(listOfNewFiles.getSelectionModel().getSelectedItem());
                if (getFileExtension(filename).equals("ppt") || getFileExtension(filename).equals("pptx")) {
                    showPPT(filename, createStage);
                } else if (getFileExtension(filename).equals("pdf")) {
                    showPDF(filename);
                }
            }
        }
    }

    public SplitPane getParent() {
        return splitPane;
    }

    private void showPPT(String filename, Stage createStage) {
        final ArrayList<Image>[] images = new ArrayList[1];
        LoadFXML load = new LoadFXML();
        load.LoadFXML("/lecturemanagementdoctor/doctor/lecture/main/lecture/view/viewLecture_fragment.fxml");
        ViewLectureController controller = (ViewLectureController) load.getController();
        Runnable runnable = () -> {
            try {
                images[0] = new SlideConvertor().readImage(filename);

                controller.setImages(images[0]);
                controller.process();

                Platform.runLater(() -> {
                    createStage.initStyle(javafx.stage.StageStyle.UNDECORATED);
                    Scene scene = new Scene(load.getParent(), 600, 400);
                    createStage.setScene(scene);
                    createStage.show();
                    StageStyle.undecoratedStageOptions(createStage, controller.getParent());
                    if (newBar.isVisible()) {
                        newBar.setVisible(false);
                    }
                    if (oldBar.isVisible()) {
                        oldBar.setVisible(false);
                    }
                    if (!startButton.isDisabled()) {
                        startButton.setDisable(false);
                    }
                    if (!startOldButton.isDisabled()) {
                        startOldButton.setDisable(false);
                    }
                });

            } catch (IOException ex) {
                Logger.getLogger(CreateLectureController.class.getName()).log(Level.SEVERE, null, ex);
            }
        };

        Thread t = new Thread(runnable);
        t.start();

    }

    private void showPDF(String filename) {
        Runnable runnable;
        runnable = () -> {
            File file = new File(filename);
            final Node node = PDFViewer.showPDF(file);

            Platform.runLater(() -> {
                ScrollPane scrollPane = new ScrollPane(node);
                scrollPane.setFitToHeight(true);
                scrollPane.setFitToWidth(true);
                scrollPane.setPannable(true);

                Scene s = new Scene(scrollPane);
                Stage stage = new Stage();
                stage.setScene(s);
                stage.show();
                if (newBar.isVisible()) {
                    newBar.setVisible(false);
                }
                if (oldBar.isVisible()) {
                    oldBar.setVisible(false);
                }
                if (!startButton.isDisabled()) {
                    startButton.setDisable(false);
                }
                if (!startOldButton.isDisabled()) {
                    startOldButton.setDisable(false);
                }
            });
        };

        Thread t = new Thread(runnable);
        t.start();
    }

    private String getFileExtension(String fileName) {
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        } else {
            return "";
        }
    }

    /**
     * Runs the specified {@link Runnable} on the JavaFX application thread and
     * waits for completion.
     *
     * @param action the {@link Runnable} to run
     * @throws NullPointerException if {@code action} is {@code null}
     */
    public void runAndWait(Runnable action) {
        if (action == null) {
            throw new NullPointerException("action");
        }

        // run synchronously on JavaFX thread
        if (Platform.isFxApplicationThread()) {
            action.run();
            return;
        }

        // queue on JavaFX thread and wait for completion
        final CountDownLatch doneLatch = new CountDownLatch(1);
        Platform.runLater(() -> {
            try {
                action.run();
            } finally {
                doneLatch.countDown();
            }
        });

        try {
            doneLatch.await();
        } catch (InterruptedException e) {
            // ignore exception
        }
    }
}
