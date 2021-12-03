
//Jackson Zheng
//SBUID: 113362794
//Recitation: R03
/**
 * Represents Seven Flag simulator
 * 
 * @author Jackson Zheng
 */
import java.util.Scanner;
import java.util.ArrayList;

public class SevenFlags {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Seven Flags!");
        System.out.println();
        System.out.print("Please enter the number of regular customers: ");
        Person[] regularCustomer = new Person[input.nextInt()];
        System.out.print("Please enter the number of silver customers: ");
        Person[] silverCustomer = new Person[input.nextInt()];
        System.out.print("Please enter the number of gold customers: ");
        Person[] goldCustomer = new Person[input.nextInt()];
        System.out.print("Please enter simulation length: ");
        int simulationLength = input.nextInt();
        System.out.println();

        Ride blueScreamOfDeath = new Ride();
        blueScreamOfDeath.setName("BSOD");
        System.out.print("Please enter the duration of Blue Scream of Death (minutes): ");
        int bsodDuration = input.nextInt();
        blueScreamOfDeath.setDuration(bsodDuration);
        System.out.print("Please enter the capactiy of Blue Scream of Death: ");
        int bsodCapacity = input.nextInt();
        blueScreamOfDeath.setPeopleOnRideCapacity(bsodCapacity);
        blueScreamOfDeath.setPeopleOnRide(new ArrayList<Person>(bsodCapacity));
        System.out.print("Please enter the holding queue size for Blue Scream of Death: ");
        blueScreamOfDeath.getHoldingQueue().setMaxSize(input.nextInt());
        System.out.println();

        Ride kingdaKnuth = new Ride();
        kingdaKnuth.setName("KK");
        System.out.print("Please enter the duration of Kingda Knuth (minutes): ");
        int kkDuration = input.nextInt();
        kingdaKnuth.setDuration(kkDuration);
        System.out.print("Please enter the capactiy of Kingda Knuth: ");
        int kkCapacity = input.nextInt();
        kingdaKnuth.setPeopleOnRideCapacity(kkCapacity);
        kingdaKnuth.setPeopleOnRide(new ArrayList<Person>(kkCapacity));
        System.out.print("Please enter the holding queue size for Kingda Knuth: ");
        kingdaKnuth.getHoldingQueue().setMaxSize(input.nextInt());
        System.out.println();

        Ride i386TowerOfTerror = new Ride();
        i386TowerOfTerror.setName("ToT");
        System.out.print("Please enter the duration of i386 Tower of Terror (minutes): ");
        int totDuration = input.nextInt();
        i386TowerOfTerror.setDuration(totDuration);
        System.out.print("Please enter the capactiy of i386 Tower of Terror: ");
        int totCapactiy = input.nextInt();
        i386TowerOfTerror.setPeopleOnRideCapacity(totCapactiy);
        i386TowerOfTerror.setPeopleOnRide(new ArrayList<Person>(totCapactiy));
        System.out.print("Please enter the holding queue size for i386 Tower of Terror: ");
        i386TowerOfTerror.getHoldingQueue().setMaxSize(input.nextInt());
        System.out.println();

        Ride geForce = new Ride();
        geForce.setName("GF");
        System.out.print("Please enter the duration of GeForce (minutes): ");
        int geDuration = input.nextInt();
        geForce.setDuration(geDuration);
        System.out.print("Please enter the capactiy of GeForce: ");
        int geCapacity = input.nextInt();
        geForce.setPeopleOnRideCapacity(geCapacity);
        geForce.setPeopleOnRide(new ArrayList<Person>(geCapacity));
        System.out.print("Please enter the holding queue size for GeForce: ");
        geForce.getHoldingQueue().setMaxSize(input.nextInt());
        System.out.println();

        Ride[] rides = { blueScreamOfDeath, kingdaKnuth, i386TowerOfTerror, geForce };
        int[] ridesCompleted = { 0, 0, 0, 0 };
        int[] duration = { bsodDuration, kkDuration, totDuration, geDuration };
        double[] averages = { 0, 0, 0 };

        createCustomer(goldCustomer, rides, 3, "Gold");
        createCustomer(silverCustomer, rides, 2, "Silver");
        createCustomer(regularCustomer, rides, 1, "Regular");
        chooseRide(goldCustomer);
        chooseRide(silverCustomer);
        chooseRide(regularCustomer);

        for (int i = 0; i < simulationLength; i++) {
            System.out.println(
                    "------------------------------------------------------------------------------------------");
            System.out.println("At Time " + i + ":");
            System.out.println();
            System.out.println("Blue Scream of Death - Time remaining: " + blueScreamOfDeath.getDuration() + " min");
            System.out.println(blueScreamOfDeath.toString());
            System.out.println(blueScreamOfDeath.getHoldingQueue().toString());
            System.out.println(blueScreamOfDeath.getVirtualLine().toString());
            System.out.println("----------------");
            System.out.println("Kingda Knuth - Time remaining: " + kingdaKnuth.getDuration() + " min");
            System.out.println(kingdaKnuth.toString());
            System.out.println(kingdaKnuth.getHoldingQueue().toString());
            System.out.println(kingdaKnuth.getVirtualLine().toString());
            System.out.println("----------------");
            System.out.println("i386 Tower of Terror - Time remaining: " + i386TowerOfTerror.getDuration() + " min");
            System.out.println(i386TowerOfTerror.toString());
            System.out.println(i386TowerOfTerror.getHoldingQueue().toString());
            System.out.println(i386TowerOfTerror.getVirtualLine().toString());
            System.out.println("----------------");
            System.out.println("GeForce - Time remaining: " + geForce.getDuration() + " min");
            System.out.println(geForce.toString());
            System.out.println(geForce.getHoldingQueue().toString());
            System.out.println(geForce.getVirtualLine().toString());
            System.out.println("----------------");
            System.out.println("Regular Customers");
            System.out.println(printCustomer(regularCustomer));
            System.out.println();
            System.out.println("Silver Customers");
            System.out.println(printCustomer(silverCustomer));
            System.out.println();
            System.out.println("Gold Customers");
            System.out.println(printCustomer(goldCustomer));
            System.out.println();

            for (int j = 0; j < rides.length; j++) {
                rides[j].setDuration(rides[j].getDuration() - 1);
                if (rides[j].getDuration() == 0) {
                    averages = resetRide(rides[j], rides, averages);
                    ridesCompleted[j] += rides[j].getPeopleOnRide().size();
                    rides[j].setDuration(duration[j]);
                }
            }
        }
        double goldAverage = averages[0];
        double silverAverage = averages[1];
        double regularAverage = averages[2];
        goldAverage /= goldCustomer.length;
        silverAverage /= silverCustomer.length;
        regularAverage /= regularCustomer.length;
        System.out.println("On average, Gold customers have taken " + goldAverage + " rides.");
        System.out.println("On average, Silver customers have taken " + silverAverage + " rides.");
        System.out.println("On average, Regular customers have taken " + regularAverage + " rides.");
        System.out.println();
        System.out.println("BSOD has completed rides for " + ridesCompleted[0] + " people.");
        System.out.println("KK has completed rides for " + ridesCompleted[1] + " people.");
        System.out.println("ToT has completed rides for " + ridesCompleted[2] + " people.");
        System.out.println("GF has completed rides for " + ridesCompleted[3] + " people.");
    }

    public static Ride[] addRandomRides(Ride[] rides, int maxLines, Ride[] currentRides) {
        for (int i = 0; i < maxLines; i++) {
            if ((currentRides[i] == null)) {
                currentRides[i] = RandomGenerator.selectRide(rides);
            }
            while ((i > 0) && (currentRides[i] == currentRides[i - 1])) {
                currentRides[i] = RandomGenerator.selectRide(rides);
            }
        }
        return currentRides;
    }

    public static void createCustomer(Person[] customer, Ride[] rides, int maxLines, String membership) {
        for (int i = 0; i < customer.length; i++) {
            customer[i] = new Person(i + 1);
            customer[i].setMaxLines(maxLines);
            customer[i].setStatus(Status.Available);
            customer[i].setMembership(membership);
            Ride[] currentRides = new Ride[maxLines];
            customer[i].setLines(addRandomRides(rides, customer[i].getMaxLines(), currentRides));
        }
    }

    public static void chooseRide(Person[] customer) {
        for (int i = 0; i < customer.length; i++) {
            for (int j = 0; j < customer[i].getMaxLines(); j++) {
                if (customer[i].getStatus().equals(Status.Available)) {
                    if (customer[i].getLines()[j].getPeopleOnRide().size() < customer[i].getLines()[j]
                            .getPeopleOnRideCapacity()) {
                        customer[i].getLines()[j].getPeopleOnRide().add(customer[i]);
                        customer[i].setStatus(Status.OnRide);
                    } else if (customer[i].getLines()[j].getHoldingQueue().line.size() < customer[i].getLines()[j]
                            .getHoldingQueue().getMaxSize()) {
                        customer[i].getLines()[j].getHoldingQueue().enqueue(customer[i]);
                        customer[i].setStatus(Status.Holding);
                    } else {
                        customer[i].getLines()[j].getVirtualLine().enqueue(customer[i]);
                    }
                } else if (customer[i].getStatus().equals(Status.OnRide)) {
                    customer[i].getLines()[j].getVirtualLine().enqueue(customer[i]);
                }
            }
        }
    }

    public static double[] resetRide(Ride ride, Ride[] rides, double[] average) {
        ArrayList<Person> wasOnRide = ride.getPeopleOnRide();
        for (int i = 0; i < wasOnRide.size(); i++) {
            if (wasOnRide.get(i).getMembership().equals("Gold")) {
                average[0]++;
            } else if (wasOnRide.get(i).getMembership().equals("Silver")) {
                average[1]++;
            } else {
                average[2]++;
            }
        }
        for (int i = 0; i < wasOnRide.size(); i++) {
            wasOnRide.get(i).setStatus(Status.Available);
            for (int j = 0; j < wasOnRide.get(i).getLines().length - 1; j++) {
                wasOnRide.get(i).getLines()[j] = wasOnRide.get(i).getLines()[j + 1];
            }
            wasOnRide.get(i).getLines()[wasOnRide.get(i).getLines().length - 1] = null;
            wasOnRide.get(i)
                    .setLines(addRandomRides(rides, wasOnRide.get(i).getMaxLines(), wasOnRide.get(i).getLines()));
            wasOnRide.get(i).getLines()[wasOnRide.get(i).getLines().length - 1].getVirtualLine()
                    .enqueue(wasOnRide.get(i));
        }
        ride.getPeopleOnRide().clear();
        for (int i = 0; i < ride.getPeopleOnRideCapacity(); i++) {
            if (ride.getHoldingQueue().line.size() != 0) {
                ride.getPeopleOnRide().add(ride.getHoldingQueue().dequeue());
                ride.getPeopleOnRide().get(i).setStatus(Status.OnRide);
            }
        }
        int counter = 0;
        for (int i = 0; i < ride.getVirtualLine().line.size(); i++) {
            if (ride.getHoldingQueue().line.size() < ride.getHoldingQueue().getMaxSize()) {
                if (ride.getVirtualLine().line.get(i).getStatus() == Status.Available) {
                    ride.getHoldingQueue().enqueue(ride.getVirtualLine().dequeue());
                    ride.getHoldingQueue().line.get(counter).setStatus(Status.Holding);
                    counter++;
                }
            }
        }
        return average;
    }

    public static String printCustomer(Person[] customer) {
        String output = "Num Line Status\n----------------";
        for (Person p : customer) {
            output += "\n" + p.toString();
        }
        return output;
    }

}
