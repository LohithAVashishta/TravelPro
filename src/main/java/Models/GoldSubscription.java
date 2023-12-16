package Models;

import Exceptions.BalanceInsufficientException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class GoldSubscription extends Passenger{
    private double balance;
    private List<Activity> activitiesList = new ArrayList<>();


    public GoldSubscription(int id, String name, long passengerNumber, List<Destination> destinations, List<Activity> optedActivities) {
        super(id, name, passengerNumber, destinations, optedActivities);
    }

    @Override
    public boolean signUp(Activity activity) throws BalanceInsufficientException {
        double goldCost = activity.getCost() *0.9;
        if(balance<goldCost){
            throw new BalanceInsufficientException();
        }

        balance -= goldCost;
        this.activitiesList.add(activity);
        setOptedActivities(this.getActivitiesList());
        return true;
    }

    public void printBalance() {
        System.out.println("Balance in account: "+ this.getBalance());
    }
}
