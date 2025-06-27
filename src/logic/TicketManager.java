package logic;

import java.util.ArrayList;

public class TicketManager {

	private ArrayList<Ticket> ticketList;

	public TicketManager() {
		this.ticketList = new ArrayList<>();
	}

	public void addTicket(Ticket ticket) {
		ticketList.add(ticket);
	}

	public void viewAllTickets() {
		if (ticketList.isEmpty()) {
			System.out.println();
			System.out.println("❌ No tickets booked yet.");
			return;
		}

		System.out.println();
		System.out.println("All Booked Tickets:");

		for (Ticket ticket : ticketList) {
			ticket.printTicket();
			System.out.println();
		}
	}

	public int getTotalTickets() {
		return ticketList.size();
	}
}
