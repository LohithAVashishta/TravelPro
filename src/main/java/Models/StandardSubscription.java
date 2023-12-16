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
public class StandardSubscription extends Passenger{
    private double balance;
    private List<Activity> activities = new ArrayList<>();

    public StandardSubscription(int id, String name, long passengerNumber, List<Destination> destinations, List<Activity> optedActivities, double balance) {
        super(id, name, passengerNumber, destinations, optedActivities);
        this.balance = balance;
    }

    @Override
    public boolean signUp(Activity activity) throws BalanceInsufficientException {

        if(activity.getCost()>balance){
            throw new BalanceInsufficientException();
        }
        balance-=activity.getCost();
        this.activities.add(activity);
        setOptedActivities(this.getActivities());
        return true;
    }

    public void printBalance() {
        System.out.println("Balance in account: "+ this.getBalance());
    }
}
