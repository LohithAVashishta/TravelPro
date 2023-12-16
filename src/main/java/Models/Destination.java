package Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class Destination {
    private int id;
    private String name;
    private List<Activity> activities;

    public Destination(int id, String name, List<Activity> activities) {
        this.id = id;
        this.name = name;
        this.activities = activities;
    }

    public void printDestination() {
        System.out.println("Destination " + this.id + " : " + this.name);

        for(int i=0; i<this.activities.size(); i++) {
            this.activities.get(i).printActivity2();
        }
    }
    public void printDestination2() {
        System.out.println("Destination " + this.id + " : " + this.name);
    }

    public void printActivitiesWithSpaces() {
        for(int i=0; i<this.activities.size(); i++) {
            this.activities.get(i).printActivitySpaces();
        }
    }



}
