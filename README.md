# Movie Ticket Booking System

## Installation

1. Clone the repository:
```
git clone https://github.com/your-username/movie-ticket-system.git
```
2. Open the project in your preferred Java IDE.
3. Ensure you have JavaFX installed and configured in your IDE.
4. Build and run the `MovieTicketSystem.java` file to start the application.

## Usage

1. When the application starts, you will see the main menu with three options:
   - Login as Admin
   - Continue as Customer
   - Exit

2. **Admin Menu**:
   - Add Movie with Showtimes
   - View All Movies
   - View All Bookings
   - Logout

3. **Customer Menu**:
   - View Movies
   - Book Ticket
   - Go Back

4. **Admin Login**:
   - The default admin password is `admin123`.

5. **Booking Tickets**:
   - Select a movie from the list.
   - Choose a showtime and available seat.
   - Enter your name to complete the booking.

## Classes Used

The application consists of the following main classes:

- `Customer`: Represents a customer with a unique ID.
- `Movie`: Represents a movie with details like title, genre, rating, duration, and price.
- `MovieManager`: Handles the management of movies, including adding, viewing, and retrieving movies.
- `TicketManager`: Manages the booking of tickets, including adding and viewing tickets.
- `MovieTicketSystem`: The main entry point of the application, handling the user interface and flow.

## Contributing

If you would like to contribute to the project, please follow these steps:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Implement your changes and ensure the application is working as expected.
4. Submit a pull request with a detailed description of your changes.

## License

This project is licensed under the [MIT License](LICENSE).
