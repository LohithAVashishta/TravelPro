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
public class PremiumSubscription extends Passenger{
    private List<Activity> activitiesList = new ArrayList<>();

    public PremiumSubscription(int id, String name, long passengerNumber, List<Destination> destinations, List<Activity> optedActivities) {
        super(id, name, passengerNumber, destinations, optedActivities);
    }

    @Override
    public boolean signUp(Activity activity) throws BalanceInsufficientException {
        this.activitiesList.add(activity);
        setOptedActivities(this.getActivitiesList());
        return true;
    }
}
