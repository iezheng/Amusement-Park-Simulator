//Jackson Zheng
//SBUID: 113362794
//Recitation: R03
/**
 * Represents a holding queue
 * 
 * @author Jackson Zheng
 */
public class HoldingQueue extends VirtualLine {
    private int maxSize;

    /**
     * enqueues or adds a person to back of the queue.
     * 
     * @param p A person object.
     * 
     */
    public void enqueue(Person p) {
        if (line.size() < maxSize) {
            line.add(p);
            rear++;
        } else {
            System.out.println("The holding queue is full.");
        }
    }

    /**
     * dequeues or removes a person in the front of the queue.
     * 
     */
    public Person dequeue() {
        if (line.size() == 0) {
            System.out.println("Holding queue is empty.");
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
            System.out.println("Holding queue is empty.");
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
     * sets the capacity for the holding queue.
     * 
     * @param maxSize the max size for hte queue.
     * 
     */
    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    /**
     * gets the capacity of the holding queue.
     * 
     * @return a int representing the capacity of the holding queue.
     * 
     */
    public int getMaxSize() {
        return maxSize;
    }

    /**
     * gets a string that prints out the holding queue.
     * 
     * @return a string representing the holding queue.
     * 
     */
    public String toString() {
        String output = "Holding Queue: ";
        for (int i = 0; i < line.size(); i++) {
            output += line.get(i).getMembership() + " " + line.get(i).getNumber();
            if (i < line.size() - 1) {
                output += ", ";
            }

        }
        return output;
    }

}
