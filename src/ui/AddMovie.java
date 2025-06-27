package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logic.MovieManager;
import javafx.scene.Node;
import java.util.ArrayList;

public class AddMovie {

	private static VBox showtimeBox = new VBox(10);
	private static MovieManager movieManager;

	public static void show(Stage stage, MovieManager manager) {
		movieManager = manager;

		Label title = new Label("Add New Movie");
		title.setFont(Font.font("Arial", 20));
		TextField titleField = new TextField();

		titleField.setPromptText("Movie title");

		TextField genreField = new TextField();
		genreField.setPromptText("Genre");

		TextField ratingField = new TextField();
		ratingField.setPromptText("Rating (0–10)");

		TextField durationField = new TextField();
		durationField.setPromptText("Duration (mins)");

		TextField priceField = new TextField();
		priceField.setPromptText("Ticket price");

		VBox movieInfoBox = new VBox(10, titleField, genreField, ratingField, durationField, priceField);
		movieInfoBox.setPadding(new Insets(10));

		Label showtimeLabel = new Label("Add Showtimes:");
		Button addShowtimeBtn = new Button("+ Add Showtime");
		addShowtimeBtn.setOnAction(e -> showtimeBox.getChildren().add(createShowtimeFields()));

		showtimeBox.getChildren().clear();
		showtimeBox.getChildren().add(createShowtimeFields());

		VBox showtimeSection = new VBox(10, showtimeLabel, showtimeBox, addShowtimeBtn);
		showtimeSection.setPadding(new Insets(10));

		Button submitBtn = new Button("Add Movie");
		submitBtn.setStyle("-fx-background-color: #2e7d32; -fx-text-fill: white;");
		submitBtn.setOnAction(e -> {
			try {
				String titleText = titleField.getText().trim();
				String genreText = genreField.getText().trim();
				String ratingText = ratingField.getText().trim();
				String durationText = durationField.getText().trim();
				String priceText = priceField.getText().trim();

				if (titleText.isEmpty() || genreText.isEmpty() || ratingText.isEmpty()
						|| durationText.isEmpty() || priceText.isEmpty()) {
					showAlert("Error", "All fields must be filled out.");
					return;
				}

				double rating = Double.parseDouble(ratingText);
				int duration = Integer.parseInt(durationText);
				int price = Integer.parseInt(priceText);

				if (rating < 0 || rating > 10) {
					showAlert("Error", "Rating must be between 0 and 10.");
					return;
				}

				if (duration <= 0 || duration > 300) {
					showAlert("Error", "Duration must be a positive number and less than 300 minutes.");
					return;
				}

				if (price <= 0 || price > 1500) {
					showAlert("Error", "Price must be a positive number and less than 1500.");
					return;
				}

				ArrayList<String> showtimes = new ArrayList<>();
				ArrayList<Integer> screens = new ArrayList<>();

				for (Node node : showtimeBox.getChildren()) {
					if (node instanceof HBox sh) {
						TextField timeField = (TextField) sh.getChildren().get(0);
						TextField screenField = (TextField) sh.getChildren().get(1);

						String time = timeField.getText().trim();
						String screenText = screenField.getText().trim();

						if (time.isEmpty() || screenText.isEmpty()) {
							showAlert("Error", "All showtimes must be filled.");
							return;
						}

						int screen = Integer.parseInt(screenText);
						showtimes.add(time);
						screens.add(screen);
					}
				}

				if (showtimes.isEmpty()) {
					showAlert("Error", "Please add at least one showtime.");
					return;
				}

				movieManager.addMovieFromGUI(titleText, genreText, rating, duration, price, showtimes, screens);
				showAlert("Movie Added", "Movie added successfully!");

				titleField.clear();
				genreField.clear();
				ratingField.clear();
				durationField.clear();
				priceField.clear();
				showtimeBox.getChildren().clear();
				showtimeBox.getChildren().add(createShowtimeFields());

			} catch (NumberFormatException nfe) {
				showAlert("Error", "Please enter valid numeric values for rating, duration, screen, and price.");
			} catch (Exception ex) {
				showAlert("Unexpected Error", "Something went wrong. Please try again.");
				ex.printStackTrace();
			}
		});

		// Back button
		Button backBtn = new Button("← Back");
		backBtn.setOnAction(e -> AdminDashboard.show(stage, movieManager));

		HBox buttons = new HBox(10, backBtn, submitBtn);
		buttons.setAlignment(Pos.CENTER_RIGHT);

		VBox mainLayout = new VBox(15, title, movieInfoBox, showtimeSection, buttons);
        mainLayout.setPadding(new Insets(20));
        mainLayout.setStyle("-fx-background-color: linear-gradient(to bottom right, #e3f2fd, #bbdefb, #e0e0e0);");

		Scene scene = new Scene(mainLayout, 600, 500);
		stage.setScene(scene);
		stage.setTitle("Add Movie");
		stage.show();
	}

	private static HBox createShowtimeFields() {
		TextField timeField = new TextField();
		timeField.setPromptText("Showtime (e.g., 3:00 PM)");

		TextField screenField = new TextField();
		screenField.setPromptText("Screen #");

		HBox hbox = new HBox(10, timeField, screenField);
		hbox.setAlignment(Pos.CENTER_LEFT);
		return hbox;
	}

	private static void showAlert(String title, String message) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}
}
