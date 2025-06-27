package view;

import javafx.animation.FadeTransition;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import logic.MovieManager;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Welcome {

	public static void show(Stage stage, MovieManager movieManager) {

		ImageView logo = new ImageView(new Image(
				"https://img.freepik.com/premium-vector/movie-ticket-logo-template-design_20029-891.jpg",
				80, 80, true, true));	

		logo.setSmooth(true);

		Text title = new Text("Welcome to Movie Ticket Booking System");
		title.setFont(Font.font("Segoe UI", 20));
		title.setStyle("-fx-fill: #607d8b;");
		Text subtitle = new Text("Book your favorite movies easily and quickly!");
		subtitle.setFont(Font.font("Segoe UI", 16));
		subtitle.setStyle("-fx-fill: #607d8b;");

		FadeTransition fade = new FadeTransition(Duration.seconds(1), title);
		fade.setFromValue(0);
		fade.setToValue(1);
		fade.play();

		Button continueBtn = new Button("Continue to App →");
		continueBtn.setMinWidth(220);
		continueBtn.setMinHeight(40);
		continueBtn.setStyle(
				"-fx-background-radius: 25px;" +
						"-fx-background-color: linear-gradient(to right, #2196F3, #21CBF3);" +
						"-fx-text-fill: white;" +
						"-fx-font-size: 15px;" +
						"-fx-font-weight: bold;" +
						"-fx-cursor: hand;");
		continueBtn.setOnMouseEntered(e -> continueBtn.setStyle(
				"-fx-background-radius: 25px;" +
						"-fx-background-color: linear-gradient(to right, #21CBF3, #2196F3);" +
						"-fx-text-fill: white;" +
						"-fx-font-size: 15px;" +
						"-fx-font-weight: bold;" +
						"-fx-cursor: hand;"));
		continueBtn.setOnMouseExited(e -> continueBtn.setStyle(
				"-fx-background-radius: 25px;" +
						"-fx-background-color: linear-gradient(to right, #2196F3, #21CBF3);" +
						"-fx-text-fill: white;" +
						"-fx-font-size: 15px;" +
						"-fx-font-weight: bold;" +
						"-fx-cursor: hand;"));
		continueBtn.setOnAction(e -> {
			CustomerDashboard.show(stage, movieManager);
		});

		VBox card = new VBox(15);
		card.setAlignment(Pos.CENTER);
		card.getChildren().addAll(logo, title, subtitle, continueBtn);
		card.setStyle(
				"-fx-background-color: white;" +
						"-fx-background-radius: 18px;" +
						"-fx-padding: 40px 30px;" +
						"-fx-effect: dropshadow(gaussian, #b0bec5, 20, 0.2, 0, 4);");

		VBox layout = new VBox();
		layout.setAlignment(Pos.CENTER);
		layout.getChildren().add(card);
		layout.setStyle(
				"-fx-background-color: linear-gradient(to bottom right, #e3f2fd, #bbdefb, #e0e0e0);");

		Scene scene = new Scene(layout, 520, 370);
		stage.setScene(scene);
		stage.setTitle("Welcome");
		stage.show();

	}

}
