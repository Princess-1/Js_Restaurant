package personnel;

import com.jfoenix.controls.JFXButton;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import otusanya.personal.js_restaurant.Main;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class perController implements Initializable {

    @FXML
    private Button addEmployee;
    @FXML
    private JFXButton dashboardButton;
    @FXML
    private Label dateLabel;
    @FXML
    private Button editEmployee;
    @FXML
    private JFXButton inventoryButton;
    @FXML
    private Button logHours;
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
    @FXML
    private TableView<Personnel> tableView;
    @FXML
    private TableColumn<Personnel, SimpleIntegerProperty> employeeIdColumn;
    @FXML
    private TableColumn<Personnel, SimpleStringProperty> firstNameColumn;
    @FXML
    private TableColumn<Personnel, SimpleStringProperty> lastNameColumn;
    @FXML
    private TableColumn<Personnel, SimpleStringProperty> jobTitleColumn;
    @FXML
    private TableColumn<Personnel, SimpleStringProperty> addressColumn;
    @FXML
    private TableColumn<Personnel, SimpleStringProperty> phoneNumberColumn;
    @FXML
    private TableColumn<Personnel, SimpleIntegerProperty> hoursWorkedColumn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // set up the columns in the table
        employeeIdColumn.setCellValueFactory(new PropertyValueFactory<Personnel, SimpleIntegerProperty>("employeeId"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Personnel, SimpleStringProperty>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Personnel, SimpleStringProperty>("lastName"));
        jobTitleColumn.setCellValueFactory(new PropertyValueFactory<Personnel, SimpleStringProperty>("jobTitle"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<Personnel, SimpleStringProperty>("address"));
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<Personnel, SimpleStringProperty>("phoneNumber"));
        hoursWorkedColumn.setCellValueFactory(new PropertyValueFactory<Personnel, SimpleIntegerProperty>("hoursWorked"));


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
