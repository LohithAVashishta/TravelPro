package Models;

import Exceptions.BalanceInsufficientException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public abstract class Passenger {
    private int id;
    private String name;
    private long passengerNumber;
    private List<Destination> destinations;
    private List<Activity> optedActivities;

    public Passenger(int id, String name, long passengerNumber, List<Destination> destinations, List<Activity> optedActivities) {
        this.id = id;
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.destinations = destinations;
        this.optedActivities = optedActivities;
    }

    public void printPassenger() {
        System.out.println("Passenger "+ this.id + ", Name : " + this.getName() + ", Number: " + this.getPassengerNumber());
        System.out.println("Destinations visiting: ");

        for(int i=0; i<this.destinations.size(); i++) {
            this.destinations.get(i).printDestination2();
        }

        for(int i=0; i<this.optedActivities.size(); i++) {
            this.optedActivities.get(i).printActivity();
        }

        if(this instanceof GoldSubscription) {
            ((GoldSubscription)this).printBalance();
        }
        if(this instanceof StandardSubscription) {
            ((StandardSubscription)this).printBalance();
        }
    }


    public abstract boolean signUp(Activity activity) throws BalanceInsufficientException;
}
