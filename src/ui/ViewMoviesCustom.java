package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logic.Movie;
import logic.MovieManager;

public class ViewMoviesCustom {

	public static void show(Stage stage, MovieManager movieManager) {
        Label title = new Label("All Available Movies");
        title.setFont(Font.font("Segoe UI", 22));
        title.setStyle("-fx-text-fill: #2c3e50;");

        VBox cardContainer = new VBox(18);
        cardContainer.setPadding(new Insets(15, 0, 15, 0));
        cardContainer.setAlignment(Pos.TOP_CENTER);

        if (movieManager.getMovies().isEmpty()) {
            VBox noMoviesBox = new VBox(10);
            noMoviesBox.setAlignment(Pos.CENTER);
            noMoviesBox.setPadding(new Insets(30, 0, 30, 0));
            noMoviesBox.setStyle(
                "-fx-background-color: white;" +
                "-fx-background-radius: 12px;" +
                "-fx-effect: dropshadow(gaussian, #b0bec5, 10, 0.15, 0, 2);"
            );

            Label noMovies = new Label("No movies available.");
            noMovies.setFont(Font.font("Segoe UI", 16));
            noMovies.setStyle("-fx-text-fill:rgb(212, 70, 34);");

            noMoviesBox.getChildren().add(noMovies);
            cardContainer.getChildren().add(noMoviesBox);
        } else {
            for (Movie movie : movieManager.getMovies()) {
                VBox card = createMovieCard(movie);
                cardContainer.getChildren().add(card);
            }
        }

        ScrollPane scrollPane = new ScrollPane(cardContainer);
        scrollPane.setFitToWidth(true);
        scrollPane.setPadding(new Insets(5));
        scrollPane.setStyle("-fx-background: transparent; -fx-background-color: transparent;");

        Button backBtn = new Button("← Back");
        backBtn.setFont(Font.font("Segoe UI", 13));
        backBtn.setStyle(
            "-fx-background-radius: 20px;" +
            "-fx-background-color: linear-gradient(to right, #2196F3, #21CBF3);" +
            "-fx-text-fill: white;" +
            "-fx-font-size: 14px;" +
            "-fx-font-weight: bold;" +
            "-fx-cursor: hand;"
        );
        backBtn.setOnMouseEntered(e -> backBtn.setStyle(
            "-fx-background-radius: 20px;" +
            "-fx-background-color: linear-gradient(to right, #21CBF3, #2196F3);" +
            "-fx-text-fill: white;" +
            "-fx-font-size: 14px;" +
            "-fx-font-weight: bold;" +
            "-fx-cursor: hand;"
        ));
        backBtn.setOnMouseExited(e -> backBtn.setStyle(
            "-fx-background-radius: 20px;" +
            "-fx-background-color: linear-gradient(to right, #2196F3, #21CBF3);" +
            "-fx-text-fill: white;" +
            "-fx-font-size: 14px;" +
            "-fx-font-weight: bold;" +
            "-fx-cursor: hand;"
        ));
        backBtn.setOnAction(e -> CustomerDashboard.show(stage, movieManager));

        VBox layout = new VBox(20, title, scrollPane, backBtn);
        layout.setPadding(new Insets(25, 30, 25, 30));
        layout.setAlignment(Pos.TOP_CENTER);
        layout.setStyle("-fx-background-color: linear-gradient(to bottom right, #e3f2fd, #bbdefb, #e0e0e0);");

        Scene scene = new Scene(layout, 650, 500);
        stage.setTitle("View Movies");
        stage.setScene(scene);
        stage.show();
    }

    private static VBox createMovieCard(Movie movie) {
        Label title = new Label(movie.getTitle());
        title.setFont(Font.font("Segoe UI", 18));
        title.setStyle("-fx-font-weight: bold; -fx-text-fill: #1976d2;");

        Label genre = new Label("Genre: " + movie.getGenre());
        genre.setFont(Font.font("Segoe UI", 14));
        genre.setStyle("-fx-text-fill: #333;");

        Label rating = new Label("Rating: " + movie.getRating());
        rating.setFont(Font.font("Segoe UI", 14));
        rating.setStyle("-fx-text-fill: #333;");

        Label duration = new Label("Duration: " + movie.getDuration() + " mins");
        duration.setFont(Font.font("Segoe UI", 14));
        duration.setStyle("-fx-text-fill: #333;");

        Label price = new Label("Price: Rs " + movie.getPrice());
        price.setFont(Font.font("Segoe UI", 14));
        price.setStyle("-fx-text-fill: #388e3c; -fx-font-weight: bold;");

        VBox showtimeList = new VBox(4);
        if (movie.getShows().isEmpty()) {
            Label noShow = new Label("No showtimes available.");
            noShow.setFont(Font.font("Segoe UI", 13));
            noShow.setStyle("-fx-text-fill: #b71c1c;");
            showtimeList.getChildren().add(noShow);
        } else {
            Label showLabel = new Label("Showtimes:");
            showLabel.setFont(Font.font("Segoe UI", 13));
            showLabel.setStyle("-fx-text-fill: #607d8b;");
            showtimeList.getChildren().add(showLabel);
            for (Movie.Showtime s : movie.getShows()) {
                Label show = new Label(s.getTime() + " on Screen " + s.getScreenNum());
                show.setFont(Font.font("Segoe UI", 13));
                show.setStyle("-fx-text-fill: #333;");
                showtimeList.getChildren().add(show);
            }
        }

        VBox card = new VBox(7, title, genre, rating, duration, price, showtimeList);
        card.setPadding(new Insets(18, 22, 18, 22));
        card.setAlignment(Pos.TOP_LEFT);
        card.setStyle(
            "-fx-background-color: white;" +
            "-fx-background-radius: 12px;" +
            "-fx-effect: dropshadow(gaussian, #b0bec5, 10, 0.15, 0, 2);"
        );
        return card;
    }

}
