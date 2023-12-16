package Models;

import Exceptions.ActivityCapacityReached;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Activity {

    private int id;
    private String name;
    private String description;
    private double cost;
    private int capacity;
    private Destination destination;
    private int enrolledCount;

    public Activity(int id, String name, String description, double cost, int capacity, Destination destination, int enrolledCount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.destination = destination;
        this.enrolledCount = enrolledCount;
    }

    public void signUpForActivity(Passenger passenger) throws ActivityCapacityReached {
        if(enrolledCount <= capacity){
            enrolledCount+=1;
        } else {
            throw new ActivityCapacityReached(this);
        }
    }

    public void printActivity() {
        System.out.println("Activity " + this.getId() + ": " + this.getName());
        System.out.println(this.getDescription());
        System.out.println("Fees: " + this.getCost());
        System.out.println("Maximum Capacity: "+this.getCapacity());
    }

    public void printActivity2() {
        System.out.println("Activity " + this.getId() + ": " + this.getName());
        System.out.println(this.getDescription());
    }

    public void printActivitySpaces() {
        int seatsLeft = this.getCapacity() - this.enrolledCount;
        System.out.println("Activity " + this.getName() + " has still " + seatsLeft + " spaces left out of total "+ this.getCapacity());
    }
}
