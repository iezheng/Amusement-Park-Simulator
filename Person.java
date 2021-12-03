
//Jackson Zheng
//SBUID: 113362794
//Recitation: R03
/**
 * Represents a Person
 * 
 * @author Jackson Zheng
 */
import java.util.ArrayList;

public class Person {
    private int number;
    private int maxLines;
    private Ride[] lines;
    private Status status;
    private String membership;

    /**
     * Creates a person with a ID
     * 
     * @param number The person's ID.
     * 
     */
    public Person(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Invalid ID.");
        }
        this.number = number;
    }

    /**
     * Gets the person's ID.
     * 
     * @return A int representing the person's ID.
     */
    public int getNumber() {
        return this.number;
    }

    /**
     * Gets the max line the person can be on.
     * 
     * @return A int that represent the max line the person can be on.
     */
    public int getMaxLines() {
        return this.maxLines;
    }

    /**
     * Gets the person's line.
     * 
     * @return A list of ride objects that represent the person's line.
     */
    public Ride[] getLines() {
        return this.lines;
    }

    /**
     * Gets the person's status.
     * 
     * @return A status enum representing the person's status.
     */
    public Status getStatus() {
        return this.status;
    }

    /**
     * Gets the person's membership.
     * 
     * @return A string representing the person's membership.
     */
    public String getMembership() {
        return this.membership;
    }

    /**
     * Sets the person's ID.
     * 
     * @param number A int representing the person's ID.
     */
    public void setNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Invalid ID.");
        }
        this.number = number;
    }

    /**
     * Sets the max line the person can be on.
     * 
     * @param maxLine A int that represent the max line the person can be on.
     */
    public void setMaxLines(int maxLines) {
        this.maxLines = maxLines;
    }

    /**
     * Sets the person's line.
     * 
     * @param lines A list of ride objects that represent the person's line.
     */
    public void setLines(Ride[] lines) {
        this.lines = lines;
    }

    /**
     * Sets the person's status.
     * 
     * @param status A status enum representing the person's status.
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Sets the person's membership.
     * 
     * @param membership A string representing the person's membership.
     */
    public void setMembership(String membership) {
        this.membership = membership;
    }

    /**
     * @return A string representing the person's ID, list, and status.
     */
    public String toString() {
        String output = number + ".";
        for (int i = 0; i < lines.length; i++) {
            output += lines[i].getName() + " ";
        }
        output += status;
        return output;
    }
}
