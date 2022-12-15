package otusanya.personal.js_restaurant;

import com.jfoenix.controls.JFXButton;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class mainController implements Initializable {

    @FXML
    private Label dateLabel;
    @FXML
    private JFXButton dashboardButton;
    @FXML
    private JFXButton inventoryButton;
    @FXML
    private JFXButton logoutButton;
    @FXML
    private Label mainMenuButton;
    @FXML
    private JFXButton menuButton;
    @FXML
    private Label menuClose;
    @FXML
    private Label nameLabel;
    @FXML
    private JFXButton orderButton;
    @FXML
    private JFXButton performanceButton;
    @FXML
    private JFXButton personnelButton;
    @FXML
    private JFXButton seatingButton;
    @FXML
    private AnchorPane slider;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // label to display current date and time
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy hh:mm a");
        dateLabel.setText(formatter.format(now));

        // returns to log in screen when Log Out button is clicked
        logoutButton.setOnMouseClicked(e -> {
            try {
                Main.setRoot("login");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        // function to control side panel
        mainMenuButton.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);

            slide.setToX(0);
            slide.play();

            slider.setTranslateX(-176);

            slide.setOnFinished((ActionEvent e)-> {
                mainMenuButton.setVisible(false);
                menuClose.setVisible(true);
            });
        });

        menuClose.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);

            slide.setToX(-176);
            slide.play();

            slider.setTranslateX(0);

            slide.setOnFinished((ActionEvent e)-> {
                mainMenuButton.setVisible(true);
                menuClose.setVisible(false);
            });
        });

        dashboardButton.setOnMouseClicked(e -> {
            try {
                Main.setRoot("dashboard");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        menuButton.setOnMouseClicked(e -> {
            try {
                Main.setRoot("menu");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        orderButton.setOnMouseClicked(e -> {
            try {
                Main.setRoot("order");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        performanceButton.setOnMouseClicked(e -> {
            try {
                Main.setRoot("performance");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        personnelButton.setOnMouseClicked(e -> {
            try {
                Main.setRoot("Personnel");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);

            slide.setToX(-176);
            slide.play();

            slider.setTranslateX(0);

            });

        inventoryButton.setOnMouseClicked(e -> {
            try {
                Main.setRoot("inventory");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        seatingButton.setOnMouseClicked(e -> {
            try {
                Main.setRoot("seating");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

    }

}