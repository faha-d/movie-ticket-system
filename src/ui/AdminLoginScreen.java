package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logic.MovieManager;
import javafx.scene.paint.Color;

public class AdminLoginScreen {

	private static final String ADMIN_PASSWORD = "admin123";

	public static void show(Stage stage, MovieManager movieManager) {
	    Label heading = new Label("🔐 Admin Login");
	    heading.setFont(Font.font("Arial", 18));
	    heading.setTextFill(Color.web("#333"));

	    PasswordField passwordField = new PasswordField();
	    passwordField.setPromptText("Enter admin password");
	    passwordField.setMaxWidth(200);
		passwordField.setStyle("-fx-background-radius: 8; -fx-padding: 8;");

	    Button loginBtn = new Button("Login");
	    loginBtn.setStyle("-fx-background-radius: 18; -fx-background-color: #43a047; -fx-text-fill: white; -fx-font-size: 15px; -fx-font-weight: bold;");
	    loginBtn.setOnAction(e -> {
	        String entered = passwordField.getText();
	        if (entered.equals(ADMIN_PASSWORD)) {
	            AdminDashboard.show(stage, movieManager);
	        } else {
	            showAlert("Incorrect Password", "Please try again.");
	        }
	    });

	    VBox card = new VBox(15);
	    card.setPadding(new Insets(20));
	    card.setAlignment(Pos.CENTER);
	    card.setStyle("-fx-background-color: white; -fx-background-radius: 10; "
	            + "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 10, 0.5, 2, 2);");
	    card.getChildren().addAll(heading, passwordField, loginBtn);
	    card.setMinWidth(300);
	    card.setMinHeight(180);

	    BorderPane layout = new BorderPane();
	    layout.setCenter(card);
	    layout.setStyle("-fx-background-color: linear-gradient(to bottom, #fefefe, #e0e0e0);");

	    Scene scene = new Scene(layout, 500, 300);
	    stage.setScene(scene);
	    stage.setTitle("Admin Login");
	    stage.show();
	}

	private static void showAlert(String title, String message) {
	    Alert alert = new Alert(Alert.AlertType.ERROR);
	    alert.setTitle(title);
	    alert.setHeaderText(null);
	    alert.setContentText(message);
	    alert.showAndWait();
	}

}
