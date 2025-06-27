package logic;

import java.util.Scanner;

public class MovieTicketSystem {

	private static final String ADMIN_PASSWORD = "admin123";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		MovieManager movieManager = new MovieManager();
		TicketManager ticketManager = new TicketManager();

		boolean running = true;

		System.out.println();
		System.out.println("Welcome to the Movie Ticket Booking System! ");
		System.out.println();

		while (running) {
			System.out.println("1. Login as Admin");
			System.out.println("2. Continue as Customer");
			System.out.println("3. Exit");
			System.out.println();
			System.out.print("Choose option: ");

			int loginChoice;
			while (!scanner.hasNextInt()) {
				scanner.next();
				System.out.println();
				System.out.println("❌ Invalid input. Please enter a valid integer:");
				System.out.println();
				scanner.nextLine();
			}

			loginChoice = scanner.nextInt();
			scanner.nextLine();

			switch (loginChoice) {
				case 1:
					System.out.println();
					System.out.print("Enter admin password: ");
					String inputPassword = scanner.nextLine();
					if (inputPassword.equals(ADMIN_PASSWORD)) {
						showAdminMenu(scanner, movieManager, ticketManager);
					} else {
						System.out.println();
						System.out.println("❌ Incorrect password.");
						System.out.println();
					}
					break;

				case 2:
					showCustomerMenu(scanner, movieManager, ticketManager);
					break;

				case 3:
					running = false;
					System.out.println();
					System.out.println("Exiting system. Goodbye!");
					break;

				default:
				System.out.println();
				System.out.println("❌ Invalid choice.");
				System.out.println();
			}
		}

		scanner.close();
	}

	private static void showAdminMenu(Scanner scanner, MovieManager movieManager, TicketManager ticketManager) {
		boolean adminMenu = true;

		while (adminMenu) {
			System.out.println("\n====== ADMIN MENU ======");
			System.out.println();
			System.out.println("1. Add Movie with Showtimes");
			System.out.println("2. View All Movies");
			System.out.println("3. View All Bookings");
			System.out.println("4. Logout");
			System.out.println();
			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
				case 1:
					System.out.println();
					movieManager.addMovie(scanner);
					System.out.println();
					break;
				case 2:
					System.out.println();
					movieManager.viewMovies();
					System.out.println();
					break;

				case 3:
					System.out.println();
					ticketManager.viewAllTickets();
					System.out.println();
					break;
				case 4:
					adminMenu = false;
					System.out.println();
					System.out.println("Logging out from Admin...");
					System.out.println();
					break;
				default:
					System.out.println();
					System.out.println("❌ Invalid option.");
					System.out.println();
			}
		}
	}

	private static void showCustomerMenu(Scanner scanner, MovieManager movieManager, TicketManager ticketManager) {
		boolean customerMenu = true;

		while (customerMenu) {
			System.out.println("\n====== CUSTOMER MENU ======");
			System.out.println("1. View Movies");
			System.out.println("2. Book Ticket");
			System.out.println("3. Go Back");
			System.out.println();
			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
				case 1:
					movieManager.viewMovies();
					break;
				case 2:
					bookTicket(scanner, movieManager, ticketManager);
					break;
				case 3:
					customerMenu = false;
					break;
				default:
					System.out.println("❌ Invalid option.");
			}
		}
	}

	// Ticket booking logic
	private static void bookTicket(Scanner scanner, MovieManager movieManager, TicketManager ticketManager) {
		if (movieManager.getMovies().isEmpty()) {
			System.out.println();
			System.out.println("No movies available.");
			System.out.println();
			return;
		}

		System.out.println();
		System.out.print("Enter your name: ");
		String name = scanner.nextLine();
		Customer customer = new Customer(name);

		System.out.print("Choose movie number: ");
		int movieIndex = scanner.nextInt();

		if (movieIndex < 1 || movieIndex > movieManager.getMovies().size()) {
			System.out.println();
			System.out.println("Invalid movie choice.");
			return;
		}

		scanner.nextLine();
		System.out.println();

		Movie selectedMovie = movieManager.getMovies().get(movieIndex - 1);
		if (selectedMovie.getShows().isEmpty()) {
			System.out.println();
			System.out.println("No showtimes for this movie.");
			return;

		}

		System.out.println(" Movie: " + selectedMovie.getTitle());
		System.out.println();
		System.out.println("Available showtimes:");
		for (int i = 0; i < selectedMovie.getShows().size(); i++) {
			Movie.Showtime s = selectedMovie.getShows().get(i);
			System.out.println((i + 1) + ". Time: " + s.getTime() + ", Screen: " + s.getScreenNum());
		}

		System.out.println();
		System.out.print("Choose showtime number: ");
		int showIndex = scanner.nextInt();

		if (showIndex < 1 || showIndex > selectedMovie.getShows().size()) {
			System.out.println("Invalid showtime choice.");
			return;
		}

		Movie.Showtime selectedShow = selectedMovie.getShows().get(showIndex - 1);
		selectedShow.displaySeats();

		System.out.print("Choose seat number (1–10): ");
		int seatNumber = scanner.nextInt();
		scanner.nextLine();

		if (seatNumber < 1 || seatNumber > selectedShow.getSeats().length) {
			System.out.println("Invalid seat number.");
			return;
		}

		if (selectedShow.getSeats()[seatNumber - 1]) {
			System.out.println();
			System.out.println("Seat already booked.");
			return;
		}

		selectedShow.getSeats()[seatNumber - 1] = true;

		Ticket ticket = new Ticket(customer, selectedMovie, selectedShow, seatNumber - 1);
		ticketManager.addTicket(ticket);

		System.out.println();
		System.out.println("Thank you for your booking!");
		ticket.printTicket();
	}

}
