/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */

package movieticketbookingmanagementsystem;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
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
    
    public void switchForm(ActionEvent event){
         if (event.getSource() == signin_createAccount){
            signin_form.setVisible(false);
            signUp_form.setVisible(true);
             
         }else if(event.getSource() == signUp_alreadyHaveAccount){
             signin_form.setVisible(true);
            signUp_form.setVisible(false);
         }
         
     }

   @FXML
    public void signin_close(){
        System.exit(0);
    }
   
   @FXML
    public void  signIn_minimize(){
        
        Stage stage = (Stage)signin_form.getScene().getWindow();
        stage.setIconified(true);
    }
    
  
    
    
   @FXML
     public void signUp_close(){
        System.exit(0);
    }
   @FXML
    public void  signUp_minimize(){
        
        Stage stage = (Stage)signUp_form.getScene().getWindow();
        stage.setIconified(true);
    }

     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
}
 