package logic;

public class Ticket {

	private Customer customer;
	private Movie movie;
	private Movie.Showtime showtime;
	private int seatNum;

	public Ticket(Customer customer, Movie movie, Movie.Showtime showtime, int seatNum) {
		this.customer = customer;
		this.movie = movie;
		this.showtime = showtime;
		this.seatNum = seatNum;
	}

	public void printTicket() {
		System.out.println("\n ====== Ticket ======");
		System.out.println();
		System.out.println("Name: " + customer.getName());
		System.out.println("Movie: " + movie.getTitle());
		System.out.println("Showtime: " + showtime.getTime());
		System.out.println("Screen: " + showtime.getScreenNum());
		System.out.println("Ticket Price: " + movie.getPrice());
		System.out.println("Seat #: " + seatNum);
		System.out.println("=======================");

	}
}
