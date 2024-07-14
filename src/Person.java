/**
 * The Person class represents a person with the name, surname and email
 */
public class Person {
    private String name; //The name of the person
    private String surname;//The surname of the person
    private String email;//The email of the person

    /**
     * Constructs a new Person object with the specific name, surname and email
     *
     * @param name
     * @param surname
     * @param email
     */
    public Person(String name,String surname,String email){
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    /**
     * Gets the name of a person
     * @return the name of the person
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of a person
     * @param name   The name of the person
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the Surname of a person
     * @return  The surname of the person
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Sets the surname of a
     * @param surname   The surname of the person
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Sets the email of the person
     * @return The email of the person
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets the email of the person
     * @param email  The email of the person
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * A method to display the information of a person
     */
    public void displayPerson(){
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("Email: " + email);
    }
}
