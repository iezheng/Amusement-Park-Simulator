
//Jackson Zheng
//SBUID: 113362794
//Recitation: R03
/**
 * Represents a virtual line
 * 
 * @author Jackson Zheng
 */
import java.util.ArrayList;

public class VirtualLine extends ArrayList {
    public ArrayList<Person> line = new ArrayList<Person>();
    public int front;
    public int rear;

    /**
     * enqueues or adds a person to back of the queue.
     * 
     * @param p A person object.
     * 
     */
    public void enqueue(Person p) {
        line.add(p);
        rear++;
    }

    /**
     * dequeues or removes a person in the front of the queue.
     * 
     */
    public Person dequeue() {
        if (line.size() == 0) {
            System.out.println("Virtual Queue is empty.");
            return null;
        }
        rear--;
        return line.remove(front);
    }

    /**
     * gets the person object in front of the queue.
     * 
     * @return A person object.
     */
    public Person peek() {
        if (line.size() == 0) {
            System.out.println("Virtual Queue is empty.");
            return null;
        }
        return line.get(front);
    }

    /**
     * gets a boolean that represent if the queue is empty.
     * 
     * @return true if the queue is empty
     * @return false if the queue is not empty
     */
    public boolean isEmpty() {
        return line.isEmpty();
    }

    /**
     * gets a string that prints out the virtual line.
     * 
     * @return a string representing the virtual line.
     * 
     */
    public String toString() {
        String output = "Virtual Queue: ";
        for (int i = 0; i < line.size(); i++) {
            output += line.get(i).getMembership() + " " + line.get(i).getNumber();
            if (i < line.size() - 1) {
                output += ", ";
            }

        }
        return output;
    }
}