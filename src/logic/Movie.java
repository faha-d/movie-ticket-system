package logic;

import java.util.ArrayList;

public class Movie {

	private String title;
	private String genre;
	private double ratings;
	private int duration;
	private int price;
	private ArrayList<Showtime> showtimes;

	public Movie(String title, String genre, double ratings, int duration, int price) {
		this.title = title;
		this.genre = genre;
		this.ratings = ratings;
		this.duration = duration;
		this.price = price;
		this.showtimes = new ArrayList<>();
	}

	public class Showtime {
		private String time;
		private int screenNum;
		private boolean[] seats;

		public Showtime(String time, int screenNum) {
			this.time = time;
			this.screenNum = screenNum;
			this.seats = new boolean[10];
		}

		public String getTime() {
			return time;
		}

		public int getScreenNum() {
			return screenNum;
		}

		public boolean[] getSeats() {
			return seats;
		}

		public void displaySeats() {
			System.out.println("Seats: ");
			for (int i = 0; i < seats.length; i++) {
				if (seats[i]) {
					System.out.print("[X] ");
				} else {
					System.out.print("[" + (i + 1) + "] ");
				}
			}
			System.out.println();
		}
	}

	public void addShowtime(String time, int screenNum) {

		Showtime showtime = new Showtime(time, screenNum);
		showtimes.add(showtime);
	}

	public void displayDetails() {
		System.out.println("\nTitle: " + title);
		System.out.println("Genre: " + genre);
		System.out.println("Rating: " + ratings);
		System.out.println("Duration: " + duration + " mins");
		System.out.println("Ticket Price: " + price);

		if (showtimes.size() > 0) {
			System.out.println();
			System.out.println("Showtimes:");

			for (int i = 0; i < showtimes.size(); i++) {
				Showtime show = showtimes.get(i);
				System.out.println("  " + (i + 1) + ". Time: " + show.getTime() + ", Screen: " + show.getScreenNum());
			}

		} else {
			System.out.println();
			System.out.println("No showtimes available.");
			System.out.println();
		}
	}

	public String getTitle() {
		return title;
	}

	public int getPrice() {
		return price;
		
	}
	
	public String getGenre() {
		return genre;
		
	}

	public double getRating() {
	return ratings;
	
	}

	public int getDuration() {
	return duration;
	
	}

	public ArrayList<Showtime> getShows() {
		return showtimes;
	}
}
