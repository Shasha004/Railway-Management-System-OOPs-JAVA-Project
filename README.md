# Railway Management System

## Description

The **Railway Management System** is a comprehensive project developed in Java that allows efficient management of railway-related operations. The system enables users to perform various functionalities, such as adding, editing, and managing trains, passengers, trips, and employees. The system is built using Object-Oriented Programming (OOP) principles and provides a graphical user interface (GUI) built with **Swing** and **AWT**. Data is stored and managed through a relational database using **JDBC** and **SQL** queries, with **XAMPP** serving as the local server for the database.

---

## Key Features

- **Train Management**: Add and manage train details such as train number, name, source, destination, and schedule.
- **Passenger Management**: Add, edit, and manage passenger information including name, contact details, and booking status.
- **Trip Management**: Create and manage trips that correspond to specific trains, including trip timings, availability, and booking status.
- **Employee Management**: Add and manage employees, track their roles (e.g., conductors, station managers), and update employee details.
- **Database Connectivity**: The project uses **JDBC** to connect to the **SQL database** for data storage and retrieval.
- **Graphical User Interface (GUI)**: The system is designed with a user-friendly GUI built with **Swing** and **AWT** components, featuring **JFrame** and **JPanel** for navigation and user interaction.
- **CRUD Operations**: Create, Read, Update, and Delete operations are enabled for all entities (trains, passengers, trips, employees) in the system, making it a full-fledged management system.

---

## Technologies Used

- **Java**: The core language used for implementing business logic and handling the user interface.
- **Swing & AWT**: Java libraries for building the graphical user interface (GUI).
- **JDBC**: Java Database Connectivity for interacting with the SQL database.
- **SQL**: Used for writing queries to manage the database.
- **XAMPP**: Local server used for running MySQL for database management.
- **IntelliJ IDEA**: Integrated Development Environment (IDE) used for project development.

---

## Project Structure

- **Model**: Contains Java classes representing various entities such as Train, Passenger, Trip, and Employee, using OOP principles like inheritance, encapsulation, and polymorphism.
- **View**: Contains the GUI components built with Swing and AWT. The system is built with JFrame and JPanel for managing different views (Add Train, Edit Trip, etc.).
- **Controller**: Handles the interactions between the model and view. It connects the GUI with database operations using JDBC.

---

## Database Schema

The project utilizes a relational database with the following tables:

- **Trains**: Stores details of all trains including train ID, train name, source, and destination.
- **Passengers**: Stores passenger information like ID, name, contact info, and train bookings.
- **Trips**: Contains details of trips, including trip ID, associated train, start and end dates, and booking status.
- **Employees**: Stores employee details like ID, name, role, and contact information.

---

## Setup Instructions

1. **Install XAMPP**:
   - Download and install **XAMPP** from [https://www.apachefriends.org/index.html](https://www.apachefriends.org/index.html).
   - Start **Apache** and **MySQL** modules from the XAMPP control panel.

2. **Setup MySQL Database**:
   - Open **phpMyAdmin** via XAMPP (http://localhost/phpmyadmin).
   - Create a new database (e.g., `railway_management`).
   - Import the provided SQL script (located in the `database` folder) to set up the necessary tables.

3. **Configure Database Connection**:
   - In the `dbConnection` class (or equivalent), configure the **JDBC** connection to point to your local MySQL database.
   - Ensure the database username and password are correctly set to match your XAMPP MySQL configuration.

4. **Run the Project**:
   - Open the project in **IntelliJ IDEA**.
   - Build and run the project.
   - The GUI will launch, allowing you to interact with the system.

---

## Screenshots

![Main Menu](screenshots/main_menu.png)
*Main Menu of the Railway Management System.*

![Add Train](screenshots/add_train.png)
*Adding a new train.*

![Edit Trip](screenshots/edit_trip.png)
*Editing trip details.*

---

## Future Improvements

- **User Authentication**: Implement user login functionality for better security and role management (Admin, User).
- **Enhanced Reporting**: Add features for generating reports on train schedules, passenger bookings, and employee performance.
- **Mobile Version**: Develop a mobile-friendly version of the application for broader access.
- **Error Handling**: Add more robust error handling and validation for user inputs to improve the user experience.

---

## License

This project is open-source and available under the [MIT License](https://opensource.org/licenses/MIT).

---

## Contributions

If you'd like to contribute to this project, feel free to fork the repository, create a pull request, or report issues you encounter. All contributions are welcome!
