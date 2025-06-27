package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logic.MovieManager;

public class AdminDashboard {

	public static void show(Stage stage, MovieManager movieManager) {
        Label title = new Label("Admin Dashboard");
        title.setFont(Font.font("Segoe UI", 24));
        title.setStyle("-fx-text-fill: #2c3e50;");

        VBox card1 = createCard("Add Movie", () -> {
             AddMovie.show(stage, movieManager);
        });

        VBox card2 = createCard("View Movies", () -> {
            ViewMovie.show(stage, movieManager);
        });

        VBox card3 = createCard("View Bookings", () -> {
            System.out.println("TODO: Show Ticket List");
            // e.g., TicketListScreen.show(stage);
        });

        VBox card4 = createCard("Logout", () -> {
            CustomerDashboard.show(stage, movieManager);
        });

        HBox row1 = new HBox(30, card1, card2);
        row1.setAlignment(Pos.CENTER);
        HBox row2 = new HBox(30, card3, card4);
        row2.setAlignment(Pos.CENTER);

        VBox layout = new VBox(28);
        layout.setAlignment(Pos.TOP_CENTER);
        layout.setPadding(new Insets(36, 30, 36, 30));
        layout.getChildren().addAll(title, row1, row2);
        layout.setStyle("-fx-background-color: linear-gradient(to bottom right, #e3f2fd, #bbdefb, #e0e0e0);");

        Scene scene = new Scene(layout, 650, 400);
        stage.setTitle("Admin Dashboard");
        stage.setScene(scene);
        stage.show();
    }

    private static VBox createCard(String labelText, Runnable action) {
        Label label = new Label(labelText);
        label.setFont(Font.font("Segoe UI", 16));
        label.setStyle("-fx-text-fill: #1976d2;");

        Button button = new Button("Open");
        button.setStyle("-fx-background-radius: 18; -fx-background-color: #1976D2; -fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold;");
        button.setOnMouseEntered(e -> button.setStyle("-fx-background-radius: 18; -fx-background-color: #2196F3; -fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold;"));
        button.setOnMouseExited(e -> button.setStyle("-fx-background-radius: 18; -fx-background-color: #1976D2; -fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold;"));
        button.setOnAction(e -> action.run());

        VBox card = new VBox(14, label, button);
        card.setAlignment(Pos.CENTER);
        card.setPadding(new Insets(18));
        card.setStyle("-fx-background-color: white; -fx-background-radius: 12; "
                    + "-fx-effect: dropshadow(gaussian, #b0bec5, 12, 0.15, 0, 2);");
        card.setMinWidth(200);
        card.setMinHeight(120);

        return card;
    }

}
