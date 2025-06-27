# Movie Ticket Booking System

A JavaFX-based application for booking movie tickets, managing movies, and handling showtimes and bookings for both customers and admins.

## Features

- **Admin Panel**
  - Add new movies with multiple showtimes and screens.
  - View all movies and their details.
  - View all booked tickets.
  - Secure admin login (default password: `admin123`).

- **Customer Panel**
  - Browse all available movies and showtimes.
  - Book tickets by selecting movie, showtime, and seat.
  - Simple, modern UI built with JavaFX.

## Project Structure

```
src/
  logic/      # Core logic: Movie, Customer, Ticket, Managers
  ui/         # JavaFX UI screens
  styles/     # CSS for JavaFX
  lib/        # JavaFX libraries and native dependencies
resource/     # (reserved for images, etc.)
```

## Getting Started

### Prerequisites

- Java 17 or later
- JavaFX 21+ (included in `src/lib/`)
- A Java IDE (e.g., IntelliJ IDEA, VS Code)

### Running the Application

1. **Clone the repository:**
   ```sh
   git clone https://github.com/your-username/movie-ticket-system.git
   cd movie-ticket-system
   ```

2. **Open in your IDE** and ensure the JavaFX libraries in `src/lib/` are added to your project/module dependencies.

3. **Run the application:**
   - Run the `logic.Main` class to launch the JavaFX GUI.
   - Alternatively, run `logic.MovieTicketSystem` for the console version.

### Usage

- On launch, you'll see a welcome screen.
- **Customers** can view movies and book tickets.
- **Admins** can log in (password: `admin123`) to add movies, view movies, and see all bookings.

## Main Classes

- [`logic.Movie`](src/logic/Movie.java): Represents a movie and its showtimes.
- [`logic.MovieManager`](src/logic/MovieManager.java): Handles movie CRUD operations.
- [`logic.Ticket`](src/logic/Ticket.java): Represents a booked ticket.
- [`logic.TicketManager`](src/logic/TicketManager.java): Manages all ticket bookings.
- [`logic.Customer`](src/logic/Customer.java): Represents a customer.
- [`logic/Main.java`](src/logic/Main.java): JavaFX application entry point.
- [`logic/MovieTicketSystem.java`](src/logic/MovieTicketSystem.java): Console application entry point.

## Customization

- **Styling:** Modify [`src/styles/app.css`](src/styles/app.css) for UI changes.
- **JavaFX Libraries:** Update or replace JARs in [`src/lib/`](src/lib/) as needed for your platform.

## Contributing

1. Fork the repository.
2. Create a new branch for your feature or bugfix.
3. Make your changes and test thoroughly.
4. Submit a pull request with a clear description.

## License

This project is licensed under the [MIT License](LICENSE).
