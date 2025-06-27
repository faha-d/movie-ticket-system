package view;

import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logic.Movie;
import logic.MovieManager;
import logic.TicketManager;

//import java.util.ArrayList;

public class BookTicketScreen {

    public static void show(Stage stage, MovieManager movieManager, TicketManager ticketManager) {
    Label heading = new Label("🎟️ Book Your Ticket");
    heading.setFont(Font.font("Arial", 20));

    TextField nameField = new TextField();
    nameField.setPromptText("Enter your name");

    ComboBox<Movie> movieCombo = new ComboBox<>();
    ComboBox<Movie.Showtime> showtimeCombo = new ComboBox<>();
    ComboBox<Integer> seatCombo = new ComboBox<>();

    // Load movies
    movieCombo.setItems(FXCollections.observableArrayList(movieManager.getMovies()));
    movieCombo.setPromptText("Select Movie");

    movieCombo.setOnAction(e -> {
        Movie selectedMovie = movieCombo.getValue();
        if (selectedMovie != null) {
            showtimeCombo.setItems(FXCollections.observableArrayList(selectedMovie.getShows()));
            showtimeCombo.getSelectionModel().clearSelection();
            seatCombo.getItems().clear();
        }
    });

    showtimeCombo.setPromptText("Select Showtime");

    showtimeCombo.setOnAction(e -> {
        seatCombo.getItems().clear();
        Movie.Showtime show = showtimeCombo.getValue();
        if (show != null) {
            boolean[] seats = show.getSeats();
            for (int i = 0; i < seats.length; i++) {
                if (!seats[i]) {
                    seatCombo.getItems().add(i);
                }
            }
        }
    });

    seatCombo.setPromptText("Select Seat (0–9)");

    Button bookBtn = new Button("Book Ticket");
    bookBtn.setStyle("-fx-background-color: #2e7d32; -fx-text-fill: white;");

    bookBtn.setOnAction(e -> {
        String name = nameField.getText().trim();
        Movie movie = movieCombo.getValue();
        Movie.Showtime show = showtimeCombo.getValue();
        Integer seatIndex = seatCombo.getValue();

        if (name.isEmpty() || movie == null || show == null || seatIndex == null) {
            showAlert("Validation Error", "Please fill in all fields.");
            return;
        }

        // Book seat
        boolean[] seats = show.getSeats();
        if (seats[seatIndex]) {
            showAlert("Error", "Seat already booked. Please choose another.");
            return;
        }

        seats[seatIndex] = true;

        // Create Customer + store ticket (you may already have this logic)
        // Ticket ticket = new Ticket(name, movie.getTitle(), show.getTime(), show.getScreenNum(), seatIndex);
        // ticketManager.addTicket(ticket);

        showAlert("Success ✅", "Ticket booked successfully for " + movie.getTitle());

        // Reset
        nameField.clear();
        movieCombo.getSelectionModel().clearSelection();
        showtimeCombo.getItems().clear();
        seatCombo.getItems().clear();
    });

    Button backBtn = new Button("← Back");
    backBtn.setOnAction(e -> CustomerDashboard.show(stage, movieManager));

    VBox form = new VBox(12,
            new Label("👤 Name:"), nameField,
            new Label("🎬 Movie:"), movieCombo,
            new Label("🕒 Showtime:"), showtimeCombo,
            new Label("💺 Seat:"), seatCombo,
            bookBtn
    );

    form.setPadding(new Insets(15));
    form.setAlignment(Pos.CENTER_LEFT);

    VBox layout = new VBox(20, heading, form, backBtn);
    layout.setPadding(new Insets(25));
    layout.setStyle("-fx-background-color: linear-gradient(to bottom, #ffffff, #eeeeee);");

    Scene scene = new Scene(layout, 500, 500);
    stage.setScene(scene);
    stage.setTitle("Book Ticket");
    stage.show();
}

private static void showAlert(String title, String msg) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(msg);
    alert.showAndWait();
}

    
}
