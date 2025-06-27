package logic;

import java.util.ArrayList;
import java.util.Scanner;

public class MovieManager {

	private ArrayList<Movie> movies;

	public MovieManager() {
		movies = new ArrayList<>();
	}

	public void addMovie(Scanner scanner) {

		if (movies.size() >= 10) {
			System.out.println("❌ Cannot add more than 10 movies.");
			return;
		}

		System.out.println("\nEnter Movie Title: ");
		String title = scanner.nextLine();
		System.out.println();

		System.out.println("Enter Genre: ");
		String genre = scanner.nextLine();
		System.out.println();

		System.out.println("Enter Rating (out of 10): ");
		double ratings = scanner.nextDouble();

		if (ratings < 0 || ratings > 10) {
			System.out.println("❌ Invalid rating. Please enter a value between 0 and 10.");
			System.out.println();
			scanner.nextLine();
			return;
		}

		scanner.nextLine();
		System.out.println();

		System.out.println("Enter duration (in minutes): ");
		int duration = scanner.nextInt();

		if (duration <= 0 || duration > 200) {
			System.out.println("❌ Invalid duration. Please enter a value between 1 and 200 minutes. ");
			System.out.println();
			scanner.nextLine();
			return;
		}
		scanner.nextLine();
		System.out.println();

		System.out.println("Enter Ticket Price: ");
		int price = scanner.nextInt();

		if (price <= 0 || price > 1500) {
			System.out.println("❌ Invalid price. Please enter a value between 1000 to 1500. ");
			System.out.println();
			scanner.nextLine();
			return;
		}

		scanner.nextLine();
		System.out.println();

		Movie movie = new Movie(title, genre, ratings, duration, price);

		System.out.print("How many showtimes do you want to add? ");
		int numShowtimes = scanner.nextInt();

		if (numShowtimes <= 0 || numShowtimes > 5) {
			System.out.println("❌ Invalid number of showtimes. Please enter a value between 1 and 5.");
			scanner.nextLine();
			return;
		}

		scanner.nextLine();
		System.out.println();

		for (int i = 0; i < numShowtimes; i++) {
			System.out.println("Showtime #" + (i + 1));
			System.out.print("Enter time (e.g., 12:00 PM): ");
			String time = scanner.nextLine();

			if (!time.matches("\\d{1,2}:\\d{2} [AP]M")) {
				System.out.println("❌ Invalid time format. Please use HH:MM AM/PM format.");
				System.out.println();
				return;
			}

			System.out.println();
			System.out.print("Enter screen number: ");
			int screen = scanner.nextInt();

			if (screen <= 0 || screen > 5) {
				System.out.println("❌ Invalid screen number. Please enter a value between 1 and 5.");
				System.out.println();
				scanner.nextLine();
				return;
			}

			scanner.nextLine();
			System.out.println();
			movie.addShowtime(time, screen);
		}

		movies.add(movie);
		System.out.println("✅ Movie added successfully!\n");
	}

	public void viewMovies() {
		if (movies.isEmpty()) {
			System.out.println();
			System.out.println("❌ No movies found.");
			return;
		}

		System.out.println();
		System.out.println("Movies List:");
		System.out.println();

		for (int i = 0; i < movies.size(); i++) {
			System.out.println("Movie #" + (i + 1));
			movies.get(i).displayDetails();
			System.out.println();
		}
	}

	public ArrayList<Movie> getMovies() {
		return movies;
	}
	
	public void addMovieFromGUI(String title, String genre, double ratings, int duration, int price,
			ArrayList<String> showtimes, ArrayList<Integer> screens) {
			Movie movie = new Movie(title, genre, ratings, duration, price);
			
			for (int i = 0; i < showtimes.size(); i++) {
			    movie.addShowtime(showtimes.get(i), screens.get(i));
			}
			movies.add(movie);
	}
}
