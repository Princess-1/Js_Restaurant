package otusanya.personal.js_restaurant;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class loginController {

    @FXML
    private Button exitButton;
    @FXML
    private TextField idField;
    @FXML
    private PasswordField pinField;
    @FXML
    private Label loginMessage;

    // method to exit program when Exit button is clicked
    public void exitButtonOnAction(ActionEvent e) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    // method to log into application
    public void loginButtonOnAction(ActionEvent e) {

        // if input detected call validate method, else print error message asking for input
        if(!idField.getText().isBlank() && !pinField.getText().isBlank()) {
            validateLogin();
        } else {
            loginMessage.setText("Please enter EmployeeID and Pin");
        }

    }

    // method to connect to restaurant database and verify login information
    private void validateLogin() {

        // connect to database
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        // get user input from console
        String verifyLogin = "SELECT count(1) FROM Personnel WHERE EmployeeID = '" + idField.getText() + "' AND EmployeePin = '" + pinField.getText() + "' ";

        try{

            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            // verify login
            while(queryResult.next()) {
                if(queryResult.getInt(1) == 1) {
                    switchScene(); // switch scene to application main scene if user input matches database information
                } else {
                    loginMessage.setText("Invalid Login. Please try again!"); // print error message if no match is found in database
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // method to switch scene after login information has been validated
    public void switchScene() throws IOException {
        Main.setRoot("dashboard");
    }

}