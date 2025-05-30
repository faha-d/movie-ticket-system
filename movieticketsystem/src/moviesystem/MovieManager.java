package moviesystem;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieManager {

	private ArrayList<Movie> movies;
	
	public MovieManager() {
		movies = new ArrayList<>();
	}
	
	public void addMovie(Scanner scanner) {
	    System.out.println("\nEnter movie title: ");
	    String title = scanner.nextLine();

	    System.out.println("Enter genre: ");
	    String genre = scanner.nextLine();

	    System.out.println("Enter rating (out of 10): ");
	    double ratings = scanner.nextDouble();

	    System.out.println("Enter duration (in minutes): ");
	    int duration = scanner.nextInt();
	    scanner.nextLine();
	    
	    Movie movie = new Movie(title, genre, ratings, duration);
	    
	    System.out.print("How many showtimes do you want to add? ");
	    int numShowtimes = scanner.nextInt();
	    scanner.nextLine();
	    
	    for (int i = 0; i < numShowtimes; i++) {
	        System.out.println("Showtime #" + (i + 1));
	        System.out.print("Enter time (e.g., 12:00 PM): ");
	        String time = scanner.nextLine();

	        System.out.print("Enter screen number: ");
	        int screen = scanner.nextInt();
	        scanner.nextLine();

	        movie.addShowtime(time, screen);
	    }
	    
	    movies.add(movie);
	    System.out.println("✅ Movie added successfully!\n");
	}
	
	public void viewMovies() {
	    if (movies.isEmpty()) {
	        System.out.println("❌ No movies found.");
	        return;
	    }

	    System.out.println("\n🎬 Movies List:");
	    for (int i = 0; i < movies.size(); i++) {
	        System.out.println("Movie #" + (i + 1));
	        movies.get(i).displayDetails();
	    }
	}
}
