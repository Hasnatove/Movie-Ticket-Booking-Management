/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package movieticketbookingmanagementsystem;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author User
 */
public class DashboardController implements Initializable {

    @FXML
    private Button close;
    @FXML
    private Button minimize;
    @FXML
    private Label username;
    @FXML
    private Button dashboard_btn;
    @FXML
    private Button addMovies_btn;
    @FXML
    private Button availableMovies_btn;
    @FXML
    private Button editScreening_btn;
    @FXML
    private Button customers_btn;
    @FXML
    private Label signOut;
    @FXML
    private AnchorPane dashboard_form;
    @FXML
    private AnchorPane dashboard_totalSoldTicket;
    @FXML
    private AnchorPane dashboard_totalEarnTicket;
    @FXML
    private AnchorPane dashboard_availableMovies;
    @FXML
    private AnchorPane addMovies_form;
    @FXML
    private ImageView addMovies_imageView;
    @FXML
    private Button addMovies_import;
    @FXML
    private TextField addMovies_movieTitle;
    @FXML
    private TextField addMovies_genre;
    @FXML
    private TextField addMovies_duration;
    @FXML
    private TextField addMovies_date;
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
    private TableView<?> addMovies_tableView;
    @FXML
    private TableColumn<?, ?> addMovies_Col_movieTitle;
    @FXML
    private TableColumn<?, ?> addMovies_Col_genre;
    @FXML
    private TableColumn<?, ?> addMovies_Col_duration;
    @FXML
    private TableColumn<?, ?> addMovies_Col_date;
    @FXML
    private AnchorPane availableMovies_form;
    @FXML
    private Label availableMovies_movieTitle;
    @FXML
    private Label availableMovies_genre;
    @FXML
    private Label availableMovies_date;
    @FXML
    private Button availableMovies_selectMovie;
    @FXML
    private TableView<?> availableMovies_tableView;
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
    private AnchorPane editScreening_form;
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
    private TextField editScreening_search;
    @FXML
    private TableView<?> editScreening_tableView;
    @FXML
    private TableColumn<?, ?> editScreening_Col_title;
    @FXML
    private TableColumn<?, ?> editScreening_Col_genre;
    @FXML
    private TableColumn<?, ?> editScreening_Col_duration;
    @FXML
    private TableColumn<?, ?> editScreening_Col_current;
    @FXML
    private AnchorPane customers_form;
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
    private TableView<?> customers_tableView;
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
    private TextField customers_search;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
