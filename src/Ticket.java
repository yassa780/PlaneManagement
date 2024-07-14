import java.io.FileWriter;
import java.io.IOException;

/**
 * The Ticket class represents a ticket with the row letter,seat number and price
 */
public class Ticket {
    private String rowLetter; //The letter representing the row letter
    private int seatNumber; // The integer representing the seat number
    private double price; // The price of the seat
    private Person person; // The person who booked the ticket

    /**
     * Constructs a new Ticket object with the specific row letter,seat number and person
     * @param rowLetter
     * @param seatNumber
     * @param person
     */
    public Ticket(String rowLetter, int seatNumber, Person person ){
        this.rowLetter = rowLetter;
        this.seatNumber = seatNumber;
        this.person = person;
    }

    /**
     * Gets the row letter of the ticket
     * @return  The row letter of the ticket
     */
    public String getRowLetter() {
        return rowLetter;
    }

    /**
     * Sets the row letter of the ticket
     * @param rowLetter The new row letter of the ticket
     */
    public void setRowLetter(String rowLetter){
        this.rowLetter = rowLetter;
    }

    /**
     * Gets the seat number of the ticket
     * @return  The seat number of the ticket
     */
    public int getSeatNumber(){
        return seatNumber;
    }

    /**
     * Gets the seat number of the ticket
     * @param seatNumber
     */
    public void setSeatNumber(int seatNumber){
        this.seatNumber = seatNumber;
    }

    /**
     * Gets the price of the ticket
     * @return  The price of ticket
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the ticket
     * @param price  The new price of the ticket
     */
    // setter method to set the price
    public void setPrice(double price){
        this.price = price;
    }

    /**
     * Sets the person who booked the seat
     * @return  The person who booked the specific ticket
     */
    public Person getPerson(){
        return person;
    }

    /**
     * Sets the person who booked the ticket
     * @param person  The new person who booked the ticket
     */
    public void setPerson(Person person) {
        this.person = person;
    }

    /**
     * Gets the details of the ticket as a string
     * @return  The ticket details
     */
    public String ticketDetails(){
        return ("Ticket: Row " + rowLetter + ", Seat number: " + seatNumber + ", Price: " + price);
        // Used to access the memory location in the search ticket method
    }

    /**
     * A method to display the Ticket details
     */
    public void displayTicket(){
        System.out.println("Row " + rowLetter);
        System.out.println("Seat: " + seatNumber);
        System.out.println("Price: " +price );
        System.out.println("Person Information");
        person.displayPerson();
    }

    /**
     * Saves the ticket information to a text file
     */
    public void save(){
        String ticketInformation = rowLetter + seatNumber + ".txt";
        try{
            FileWriter myWriter = new FileWriter(ticketInformation);
            myWriter.write("Ticket Information");
            myWriter.write("\nRow: " + rowLetter);
            myWriter.write("\nSeat Number: " + seatNumber);
            myWriter.write("\nThe Price: " + price);
            myWriter.write("\n");
            myWriter.write("\nPerson Information");
            myWriter.write("\nName: " + person.getName());
            myWriter.write("\nSurname: " + person.getSurname());
            myWriter.write("\nEmail: " + person.getEmail());
            myWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred");

        }
    }
}
