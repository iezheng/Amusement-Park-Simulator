
//Jackson Zheng
//SBUID: 113362794
//Recitation: R03
/**
 * Represents Ride
 * 
 * @author Jackson Zheng
 */
import java.util.ArrayList;

public class Ride {
    private int duration;
    private int timeleft;
    private String name;
    private VirtualLine virtualLine = new VirtualLine();
    private HoldingQueue holdingQueue = new HoldingQueue();
    private ArrayList<Person> peopleOnRide;
    private int peopleOnRideCapacity;

    /**
     * Creates a default ride object.
     * 
     */
    public Ride() {
    }

    /**
     * Gets the ride's duration
     * 
     * @return A int representing the ride's duration
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Gets the time left.
     * 
     * @return A int representing the time left for the ride.
     */
    public int getTimeLeft() {
        return timeleft;
    }

    /**
     * Gets the name of the ride.
     * 
     * @return A string representing the name of the ride.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the ride's virutal line.
     * 
     * @return A Virtual Line object representing the virtual line.
     */
    public VirtualLine getVirtualLine() {
        return virtualLine;
    }

    /**
     * Gets the ride's holding queue.
     * 
     * @return A holding queue object representing the holding line.
     */
    public HoldingQueue getHoldingQueue() {
        return holdingQueue;
    }

    /**
     * Gets the people on the ride
     * 
     * @return A list representing the people on the ride.
     */
    public ArrayList<Person> getPeopleOnRide() {
        return peopleOnRide;
    }

    /**
     * Gets ride's capacity
     * 
     * @return A int representing the rides capacity.
     */
    public int getPeopleOnRideCapacity() {
        return peopleOnRideCapacity;
    }

    /**
     * Sets the ride's duration
     * 
     * @param duration A int representing the ride's duration
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * Sets the ride's time left.
     * 
     * @param timeLeft A int representing the time left for the ride.
     */
    public void setTimeLeft(int timeLeft) {
        this.timeleft = timeLeft;
    }

    /**
     * Sets the ride's name
     * 
     * @param name A string representing the name of the ride.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the ride's virtual line
     * 
     * @param virtualLine A Virtual Line object representing the virtual line.
     */
    public void setVirtualLine(VirtualLine virtualLine) {
        this.virtualLine = virtualLine;
    }

    /**
     * Sets the holding queue
     * 
     * @param holdingQueue A holding queue object representing the holding line.
     */
    public void setHoldingQueue(HoldingQueue holdingQueue) {
        this.holdingQueue = holdingQueue;
    }

    /**
     * Sets the people on the ride
     * 
     * @param peopleOnRide A list representing the people on the ride.
     */
    public void setPeopleOnRide(ArrayList<Person> peopleOnRide) {
        this.peopleOnRide = peopleOnRide;
    }

    /**
     * Sets the ride's capacity
     * 
     * @param peopleOnRideCapacity A int representing the rides capacity.
     */
    public void setPeopleOnRideCapacity(int peopleOnRideCapacity) {
        this.peopleOnRideCapacity = peopleOnRideCapacity;
    }

    /**
     * @return A string representing the people on the ride.
     */
    public String toString() {
        String output = "On Ride: ";
        for (int i = 0; i < peopleOnRide.size(); i++) {
            output += peopleOnRide.get(i).getMembership() + " " + peopleOnRide.get(i).getNumber();
            if (i < peopleOnRide.size() - 1) {
                output += ", ";
            }
        }
        return output;
    }
}
