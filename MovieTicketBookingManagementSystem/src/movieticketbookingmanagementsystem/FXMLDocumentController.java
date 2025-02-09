package movieticketbookingmanagementsystem;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;
import javafx.stage.StageStyle;

public class FXMLDocumentController implements Initializable {

    @FXML
    private Button signUp_Btn;

    @FXML
    private Hyperlink signUp_alreadyHaveAccount;

    @FXML
    private Button signin_close;

    @FXML
    private Button signin_minimize;

    @FXML
    private Button signUp_close;

    @FXML
    private Button signUp_minimize;

    @FXML
    private TextField signUp_email;

    @FXML
    private AnchorPane signUp_form;

    @FXML
    private PasswordField signUp_password;

    @FXML
    private TextField signUp_username;

    @FXML
    private Hyperlink signin_createAccount;

    @FXML
    private AnchorPane signin_form;

    @FXML
    private Button signin_loginBtn;

    @FXML
    private PasswordField signin_password;

    @FXML
    private TextField signin_username;

    // Method to switch between login and signup forms
    public void switchForm(ActionEvent event) {
        if (event.getSource() == signin_createAccount) {
            signin_form.setVisible(false);
            signUp_form.setVisible(true);
        } else if (event.getSource() == signUp_alreadyHaveAccount) {
            signin_form.setVisible(true);
            signUp_form.setVisible(false);
        }
    }

    // Close the application
    @FXML
    public void signin_close() {
        System.exit(0);
    }

    // Minimize the application window
    @FXML
    public void signIn_minimize() {
        Stage stage = (Stage) signin_form.getScene().getWindow();
        stage.setIconified(true);
    }

    // Close the application
    @FXML
    public void signUp_close() {
        System.exit(0);
    }

    // Minimize the application window
    @FXML
    public void signUp_minimize() {
        Stage stage = (Stage) signUp_form.getScene().getWindow();
        stage.setIconified(true);
    }

    // Handle user registration
    @FXML
    public void signUp(ActionEvent event) {
        String username = signUp_username.getText();
        String email = signUp_email.getText();
        String password = signUp_password.getText();

        if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            showAlert(AlertType.ERROR, "Error", "All fields are required!");
            return;
        }

        Connection conn = database.connectDb();
        if (conn == null) {
            showAlert(AlertType.ERROR, "Error", "Database connection failed!");
            return;
        }

        String query = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, email);
            pstmt.setString(3, password); // TODO: Hash the password before storing

            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                showAlert(AlertType.INFORMATION, "Success", "User registered successfully!");
            } else {
                showAlert(AlertType.ERROR, "Error", "Registration failed!");
            }

            pstmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
            showAlert(AlertType.ERROR, "Error", "An error occurred during registration.");
        }
    }

    // Handle user login
    @FXML
    public void signIn(ActionEvent event) {
        String username = signin_username.getText();
        String password = signin_password.getText();

        if (username.isEmpty() || password.isEmpty()) {
            showAlert(AlertType.ERROR, "Error", "Username and password are required!");
            return;
        }

        Connection conn = database.connectDb();
        if (conn == null) {
            showAlert(AlertType.ERROR, "Error", "Database connection failed!");
            return;
        }

        String query = "SELECT * FROM users WHERE username = ? AND password = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // Login successful
                showAlert(AlertType.INFORMATION, "Success", "Login successful! Welcome, " + username);

                // Close the login window
                signin_loginBtn.getScene().getWindow().hide();

                // Load the dashboard
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);

                    stage.initStyle(StageStyle.TRANSPARENT);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                    showAlert(AlertType.ERROR, "Error", "Failed to load dashboard!");
                }
            } else {
                // Login failed
                showAlert(AlertType.ERROR, "Error", "Invalid username or password!");
            }

            rs.close();
            pstmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
            showAlert(AlertType.ERROR, "Error", "An error occurred during login.");
        }
    }

    // Helper method to show alerts
    private void showAlert(AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialization logic (if needed)
    }

    @FXML
    private void signIn(KeyEvent event) {
    }

    
}