//Jackson Zheng
//SBUID: 113362794
//Recitation: R03
/**
 * Represents a random ride generator.
 * 
 * @author Jackson Zheng
 */
public class RandomGenerator {

    /**
     * Randomly generate a ride.
     * 
     * @param rides A list full of availiable rides.
     * @return a randomly selected ride from the availiable rides.
     */
    public static Ride selectRide(Ride[] rides) {
        int random = (int) (Math.random() * rides.length);
        return rides[random];
    }
}
