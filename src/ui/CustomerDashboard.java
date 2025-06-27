package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import logic.MovieManager;

public class CustomerDashboard {
	public static void show(Stage stage, MovieManager movieManager) {

		Label adminLink = new Label("Are you an admin? Sign in");
		adminLink.setPadding(new Insets(10));
		adminLink.setFont(Font.font("Arial", 12));
		adminLink.setTextFill(Color.web("#000"));
		adminLink.setStyle("-fx-underline: true;");
		adminLink.setOnMouseClicked((MouseEvent e) -> {
			AdminLoginScreen.show(stage, movieManager);
		});

		Text title = new Text("Book your movies online!");
		title.setFont(Font.font("Segoe UI", 22));
		title.setStyle("-fx-fill: #2c3e50;");

		HBox topBar = new HBox(adminLink);
		topBar.setAlignment(Pos.TOP_RIGHT);
		topBar.setPadding(new Insets(10, 5, 0, 0));

		VBox card1 = createCard("View Movies", () -> {
			ViewMoviesCustom.show(stage, movieManager);
		});

		VBox card2 = createCard("Book Ticket", () -> {
			System.out.println("TODO: Show booking screen");
		});

		HBox cardRow = new HBox(40, card1, card2);
		cardRow.setAlignment(Pos.CENTER);

		VBox centerBox = new VBox(30, title, cardRow);
		centerBox.setAlignment(Pos.CENTER);

		BorderPane mainLayout = new BorderPane();
		mainLayout.setTop(topBar);
		mainLayout.setCenter(centerBox);
		mainLayout.setStyle("-fx-background-color: linear-gradient(to bottom right, #e3f2fd, #bbdefb, #e0e0e0);");
		BorderPane.setMargin(centerBox, new Insets(10, 0, 0, 0));

		Scene scene = new Scene(mainLayout, 600, 400);
		stage.setScene(scene);
		stage.setTitle("Customer Menu");
		stage.show();
	}

	private static VBox createCard(String title, Runnable action) {
		Label label = new Label(title);
		label.setFont(Font.font("Arial", 16));
		label.setTextFill(Color.web("#333"));

		Button button = new Button("Open");
		button.setStyle("-fx-background-color: #42a5f5; -fx-text-fill: white; -fx-font-size: 13;");
		button.setOnAction(e -> action.run());

		VBox card = new VBox(15);
		card.setPadding(new Insets(20));
		card.setAlignment(Pos.CENTER);
		card.setStyle(
				"-fx-background-color: white; -fx-background-radius: 10; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 8, 0.5, 2, 2);");
		card.getChildren().addAll(label, button);
		card.setMinWidth(200);
		card.setMinHeight(120);

		return card;
	}
}
