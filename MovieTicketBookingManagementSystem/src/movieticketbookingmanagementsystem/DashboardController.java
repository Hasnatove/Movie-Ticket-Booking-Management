package movieticketbookingmanagementsystem;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

    import java.sql.Date;
    import java.text.SimpleDateFormat;

public class DashboardController implements Initializable {

    @FXML
    private Button close, minimize, dashboard_btn, addMovies_btn, availableMovies_btn, editScreening_btn, customers_btn;
    @FXML
    private Label username, signOut;
    @FXML
    private AnchorPane dashboard_form, addMovies_form, availableMovies_form, editScreening_form, customers_form;
    @FXML
    private TableView<?> addMovies_tableView, availableMovies_tableView, editScreening_tableView, customers_tableView;
    @FXML
    private TextField customers_search, editScreening_search, addMovies_movieTitle, addMovies_genre, addMovies_duration, addMovies_date;
    @FXML
    private AnchorPane dashboard_totalSoldTicket;
    @FXML
    private AnchorPane dashboard_totalEarnTicket;
    @FXML
    private AnchorPane dashboard_availableMovies;
    @FXML
    private ImageView addMovies_imageView;
    @FXML
    private Button addMovies_import;
    @FXML
    private Button addMovies_insertBtn;
    @FXML
    private Button addMovies_updateBtn;
    @FXML
    private Button addMovies_deleteBtn;
    @FXML
    private Button addMovies_clearBtn;
    @FXML
    private AnchorPane addMovies_search;
    @FXML
    private TableColumn<?, ?> addMovies_Col_movieTitle;
    @FXML
    private TableColumn<?, ?> addMovies_Col_genre;
    @FXML
    private TableColumn<?, ?> addMovies_Col_duration;
    @FXML
    private TableColumn<?, ?> addMovies_Col_date;
    @FXML
    private Label availableMovies_movieTitle;
    @FXML
    private Label availableMovies_genre;
    @FXML
    private Label availableMovies_date;
    @FXML
    private Button availableMovies_selectMovie;
    @FXML
    private TableColumn<?, ?> availableMovies_Col_movieTitle;
    @FXML
    private TableColumn<?, ?> availableMovies_Col_genre;
    @FXML
    private TableColumn<?, ?> availableMovies_Col_showingDate;
    @FXML
    private ImageView availableMovies_imageView;
    @FXML
    private Label availableMovies_title;
    @FXML
    private Spinner<?> availableMovies_specialClass_quantity;
    @FXML
    private Spinner<?> availableMovies_normalClass_quantity;
    @FXML
    private Label availableMovies_specialClass_price;
    @FXML
    private Label availableMovies_normalClass_price;
    @FXML
    private Label availableMovies_total;
    @FXML
    private Button availableMovies_ReceitBtn;
    @FXML
    private Button availableMovies_buyBtn;
    @FXML
    private Button availableMovies_clearBtn;
    @FXML
    private ImageView editScreening_imageView;
    @FXML
    private Label editScreening_title;
    @FXML
    private ComboBox<?> editScreening_current;
    @FXML
    private Button editScreening_updateBtn;
    @FXML
    private Button editScreening_deleteBtn;
    @FXML
    private TableColumn<?, ?> editScreening_Col_title;
    @FXML
    private TableColumn<?, ?> editScreening_Col_genre;
    @FXML
    private TableColumn<?, ?> editScreening_Col_duration;
    @FXML
    private TableColumn<?, ?> editScreening_Col_current;
    @FXML
    private Label customers_ticketNumber;
    @FXML
    private Label customers_movieTitle;
    @FXML
    private Label customers_genre;
    @FXML
    private Label customers_date;
    @FXML
    private Label customers_time;
    @FXML
    private Button customers_clearBtn;
    @FXML
    private Button customers_deleteBtn;
    @FXML
    private TableColumn<?, ?> customers_Col_ticketNumber;
    @FXML
    private TableColumn<?, ?> customers_Col_movieTitle;
    @FXML
    private TableColumn<?, ?> customers_Col_genre;
    @FXML
    private TableColumn<?, ?> customers_Col_date;
    @FXML
    private TableColumn<?, ?> customers_Col_time;
    @FXML
    private AnchorPane mainform;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setupButtonActions();
    }

    // Setup button actions
    private void setupButtonActions() {
        if (close != null) {
            close.setOnAction(event -> {
                Stage stage = (Stage) close.getScene().getWindow();
                stage.close();
            });
        }

        if (minimize != null) {
            minimize.setOnAction(event -> {
                Stage stage = (Stage) minimize.getScene().getWindow();
                stage.setIconified(true);
            });
        }

        if (signOut != null) {
            signOut.setOnMouseClicked(event -> {
                try {
                    Stage stage = (Stage) signOut.getScene().getWindow();
                    stage.close();

                    Stage loginStage = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));

                    Scene scene = new Scene(root);
                    loginStage.setScene(scene);
                    loginStage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error loading login screen.");
                }
            });
        }

        // Form switching
        dashboard_btn.setOnAction(event -> switchForm(dashboard_form));
        addMovies_btn.setOnAction(event -> switchForm(addMovies_form));
        availableMovies_btn.setOnAction(event -> switchForm(availableMovies_form));
        editScreening_btn.setOnAction(event -> switchForm(editScreening_form));
        customers_btn.setOnAction(event -> switchForm(customers_form));
    }

    // Switch between forms
    private void switchForm(AnchorPane form) {
        dashboard_form.setVisible(false);
        addMovies_form.setVisible(false);
        availableMovies_form.setVisible(false);
        editScreening_form.setVisible(false);
        customers_form.setVisible(false);

        form.setVisible(true);
        form.setManaged(true);
    }


@FXML
private void addMovieInsert(ActionEvent event) {
    String title = addMovies_movieTitle.getText();
    String genre = addMovies_genre.getText();
    String duration = addMovies_duration.getText();
    String dateString = addMovies_date.getText();

    // Validate the fields are not empty
    if (title.isEmpty() || genre.isEmpty() || duration.isEmpty() || dateString.isEmpty()) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("All fields must be filled!");
        alert.showAndWait();
        return;
    }

    
    java.sql.Date date = null;
    try {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date parsedDate = sdf.parse(dateString);
        date = new java.sql.Date(parsedDate.getTime());
    } catch (Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Invalid date format! Please use yyyy-MM-dd.");
        alert.showAndWait();
        return;
    }

    
    String sql = "INSERT INTO movies (title, genre, duration, date) VALUES (?, ?, ?, ?)";

    try (Connection conn = database.connectDb(); PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, title);
        stmt.setString(2, genre);
        stmt.setString(3, duration);
        stmt.setDate(4, date); // Set the date parameter as java.sql.Date

        int rowsInserted = stmt.executeUpdate();
        if (rowsInserted > 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Movie added successfully!");
            alert.showAndWait();
        }

        

    } catch (SQLException e) {
        e.printStackTrace();
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Database Error");
        alert.setHeaderText(null);
        alert.setContentText("An error occurred while adding the movie.");
        alert.showAndWait();
    }
}


    private void clearFields() {
        addMovies_movieTitle.setText("");
        addMovies_genre.setText("");
        addMovies_duration.setText("");
        addMovies_date.setText("");
    }

    @FXML
    private void addMovieUpdate(ActionEvent event) {
    }

    @FXML
    private void addMovieDelete(ActionEvent event) {
    }

    @FXML
    private void addMovieClear(ActionEvent event) {
    }
}
