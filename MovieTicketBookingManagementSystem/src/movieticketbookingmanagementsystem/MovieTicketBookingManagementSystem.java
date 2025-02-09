package movieticketbookingmanagementsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MovieTicketBookingManagementSystem extends Application {

    private double x = 0;
    private double y = 0;

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/movieticketbookingmanagementsystem/FXMLDocument.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            scene.setFill(null); // Required for transparent window

            // Enable window dragging
            root.setOnMousePressed((MouseEvent event) -> {
                x = event.getSceneX();
                y = event.getSceneY();
            });

            root.setOnMouseDragged((MouseEvent event) -> {
                stage.setX(event.getScreenX() - x);
                stage.setY(event.getScreenY() - y);
            });

            stage.initStyle(StageStyle.TRANSPARENT); // Set transparent stage

            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error loading FXML file. Make sure the file path is correct.");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
