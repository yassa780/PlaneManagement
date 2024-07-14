import java.util.InputMismatchException;
import java.util.*;

public class PlaneManagement {
    private static final Scanner input = new Scanner(System.in);

// Arrays to store the seating rows
    static int[] row_A = new int[14];
    static int[] row_B = new int[12];
    static int[] row_C = new int[12];
    static int[] row_D = new int[14];

    private static Ticket[] ticketsSold = new Ticket[52]; //An array to store the sold tickets

    /**
     * Displays the main menu and handles user inputs
     * @param args
     */
    public static void main(String[] args) {
        while (true){
            System.out.println();
            System.out.println("Welcome to the Plane Management Application");
            for (int i = 0; i < 51; i++) {
                System.out.print('*');
            }
            System.out.println();
            //Printing the menu options
            System.out.println("*                  MENU OPTIONS                   *");
            for (int j = 0; j < 51; j++) {
                System.out.print('*');
            }
            System.out.println("\n\t1) Buy a seat");
            System.out.println("\t2) Cancel a seat");
            System.out.println("\t3) Find first available seat");
            System.out.println("\t4) Show seating plan");
            System.out.println("\t5) Print tickets information and total sales");
            System.out.println("\t6) Search tickets");
            System.out.println("\t0) Quit");

            for (int k = 0; k < 51; k++) {
                System.out.print("*");
            }
            int user = 0;
            try {
                System.out.print("\nPlease select an option: ");
                user = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Please enter a valid option");
                input.nextLine();
                continue;
            }
            switch (user) {
                case 0:
                    System.out.println("Thank you for using the Plane Management Application,exiting the program.");
                    System.exit(0);
                case 1:
                    buy_seat();
                    break;
                case 2:
                    cancel_seat();
                    break;
                case 3:
                    find_first_available();
                    break;
                case 4:
                    show_seating_plan();
                    break;
                case 5:
                    print_tickets_info();
                    break;
                case 6:
                    search_ticket();
                    break;

                default:
                    System.out.println("Invalid option, please re-enter a valid number");
            }
        }
    }
    /**
     * Allows users to buy a seat and book a seat on the plane.
     */
    private static void buy_seat() {
        while (true) {

            System.out.print("Enter the row letter you want to book(A,B,C,D): ");
            String rowLetter = input.next().toUpperCase();
            int[] selectedRow;

            switch (rowLetter) {
                case "A":
                    selectedRow = row_A;
                    break;
                case "B":
                    selectedRow = row_B;
                    break;
                case "C":
                    selectedRow = row_C;
                    break;
                case "D":
                    selectedRow = row_D;
                    break;
                default:
                    System.out.println("Invalid row letter, please re - enter");
                    continue;
            }
            int seatNumber = 0;
            while (true) {
                try {
                    System.out.print("Enter the seat number you want to book(1-14): ");
                    seatNumber = input.nextInt();

                    if (seatNumber > selectedRow.length || seatNumber < 1) {
                        System.out.println("Invalid seat Number, please re-enter");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input, please enter a valid seat number");
                    input.nextLine();
                }
            }
            if (selectedRow[seatNumber - 1] == 0) { //Checks whether the seat is available
                /**
                 * Asks the name,surname and email from the user.
                 * isEmpty() checks whether the string is empty before performing further operations.
                 */
                String name = "";
                while(name.isEmpty()){
                    System.out.print("Enter your name: ");
                    name = input.next();
                    if(name.isEmpty()){
                        System.out.println("Name cannot be left empty,please re-enter.");
                    }
                }
                String surname = "";
                while(surname.isEmpty()){
                    System.out.print("Enter your surname: ");
                    surname = input.next();
                    if(surname.isEmpty()){
                        System.out.println("The surname cannot be left empty,please re-enter.");
                    }
                }
                String email = "";
                while(email.isEmpty() || !email.contains("@")){
                    System.out.print("Enter your email: ");
                    email = input.next();
                    if(email.isEmpty() || !email.contains("@")){
                        System.out.println("Invalid email address, please re-enter.");
                    }
                }

                //Creating the person and ticket objects
                Person person = new Person(name, surname, email);
                Ticket ticket = new Ticket(rowLetter, seatNumber, person);

                if (seatNumber <= 5) {
                    ticket.setPrice(200);
                } else if (seatNumber >= 6 && seatNumber <= 9) {
                    ticket.setPrice(150);
                } else {
                    ticket.setPrice(180);
                }

                for (int x = 0; x < ticketsSold.length; x++) {
                    if (ticketsSold[x] == null) {
                        ticketsSold[x] = ticket;
                        ticket.save(); //Calling the method from the Ticket class
                        System.out.println("Ticket information saved to " + rowLetter + seatNumber + ".txt");
                        break;
                    }
                }
                selectedRow[seatNumber - 1] = 1;
                System.out.println("This seat " + rowLetter + seatNumber + " has been booked successfully");
                break;
            }
            else {
                System.out.println("This seat " + rowLetter + seatNumber + " is not available for booking");
                break;
            }
        }
    }

    /**
     * Allows users to cancel booked seats on the plane
     */
    private static void cancel_seat() {
        while (true) {
            System.out.print("Enter the row letter of the booking you want to cancel.(A,B,C,D): ");
            String rowLetter = input.next().toUpperCase();

            int[] selectedRow;
            switch (rowLetter) {
                case "A":
                    selectedRow = row_A;
                    break;
                case "B":
                    selectedRow = row_B;
                    break;
                case "C":
                    selectedRow = row_C;
                    break;
                case "D":
                    selectedRow = row_D;
                    break;
                default:
                    System.out.println("Invalid row letter, please re-enter a valid one");
                    continue;
            }
            int seatNumber = 0;
            while (true) {
                try {
                    System.out.print("Enter the seat number(1-14): ");
                    seatNumber = input.nextInt();

                    if (seatNumber > selectedRow.length || seatNumber < 1) {
                        System.out.println("Invalid seat number,please re-enter ");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input, please enter a valid seat number");
                    input.nextLine();
                }
            }
            if (selectedRow[seatNumber - 1] == 1) { //Checking whether the specific seat is booked
                for (int x = 0; x < ticketsSold.length; x++) {
                    Ticket ticket = ticketsSold[x];
                    if (ticket != null && ticket.getRowLetter().equals(rowLetter) && ticket.getSeatNumber() == seatNumber) {
                        ticketsSold[x] = null;
                        selectedRow[seatNumber - 1] = 0;
                        System.out.println("Your booking for seat " + rowLetter + seatNumber + " has been cancelled");
                        return;
                    }
                }
            } else {
                System.out.println("This seat " + rowLetter + seatNumber + " has not been booked yet");
                break;
            }
        }
    }

    /**
     * Finds the first seat that is available for booking.
     */
    private static void find_first_available() {
        char[] rowLetters = {'A', 'B', 'C', 'D'};
        for (int i = 0; i < rowLetters.length; i++) {
            int[] currentRow;

            switch (i) {
                case 0:
                    currentRow = row_A;
                    break;
                case 1:
                    currentRow = row_B;
                    break;
                case 2:
                    currentRow = row_C;
                    break;
                case 3:
                    currentRow = row_D;
                    break;
                default:
                    return; //This will never happen, just in case it happens
            }
            for (int j = 0; j < currentRow.length; j++) {
                if (currentRow[j] == 0) {
                    System.out.println("The first free seat is available in " + rowLetters[i] + (j + 1));
                    return;
                }
            }
        }
        System.out.println("No available seats found");
    }

    /**
     * Shows the seating plan of a plane.
     */
    private static void show_seating_plan() {
        System.out.println("The Seating Position");
        char[] rowLetters = {'A', 'B', 'C', 'D'};

        for (int i = 0; i < rowLetters.length; i++) {
            System.out.print("Row " + rowLetters[i] + " - ");
            int[] currentRow;

            switch (i) {
                case 0:
                    currentRow = row_A;
                    break;
                case 1:
                    currentRow = row_B;
                    break;
                case 2:
                    currentRow = row_C;
                    break;
                case 3:
                    currentRow = row_D;
                    break;
                default:
                    return; //This will never happen, but just in case it happens

            }
            for (int seatPosition : currentRow) {
                if (seatPosition == 0) {
                    System.out.print("O ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Prints the relevant information about the sold tickets and the total sales.
     */
    private static void print_tickets_info() {
        int totalTicketSales = 0;

        for (Ticket ticket : ticketsSold) {
            if (ticket != null) {
                ticket.displayTicket();
                totalTicketSales += ticket.getPrice();
                System.out.println("(" + ticket.getRowLetter() + ticket.getSeatNumber() + "=" + ticket.getPrice() + ")");
                System.out.println();
            }
        }
        System.out.println("Total ticket sales were: " + totalTicketSales);
        return;
    }

    /**
     * Searches for information about a specific seat that is booked
     */
    private static void search_ticket() {
        while (true) {
            System.out.print("Enter the row letter(A,B,C,D): ");
            String rowLetter = input.next().toUpperCase();

            int[] selectedRow;
            switch (rowLetter) {
                case "A":
                    selectedRow = row_A;
                    break;
                case "B":
                    selectedRow = row_B;
                    break;
                case "C":
                    selectedRow = row_C;
                    break;
                case "D":
                    selectedRow = row_D;
                    break;
                default:
                    System.out.println("Invalid row letter, please re-enter");
                    continue;
            }
            int seatNumber = 0;
            while (true) {
                try {
                    System.out.print("Enter the seat number(1-14): ");
                    seatNumber = input.nextInt();

                    if (seatNumber > selectedRow.length || seatNumber < 1) {
                        System.out.println("Invalid seat number,please re-enter ");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input, please enter a valid seat number");
                    input.nextLine();
                }
            }
            if (selectedRow[seatNumber -1] == 1){
                for (Ticket ticket : ticketsSold) {
                    if(ticket != null && ticket.getRowLetter().equals(rowLetter) && ticket.getSeatNumber() == seatNumber){
                        System.out.println("Ticket details");
                        System.out.println(ticket.ticketDetails()); //A method that is called from the Ticket Class
                        System.out.println();
                        System.out.println("Person details");
                        ticket.getPerson().displayPerson();
                        return;
                    }
                }
            }
            System.out.println("This seat is available");
            return;
        }
    }
}