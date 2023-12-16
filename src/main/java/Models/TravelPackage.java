package Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class TravelPackage {
    private int id;
    private String name;
    private int passengerCapacity;
    private List<Destination> destinations;
    private List<Passenger> passengers;

    public TravelPackage(int id, String name, int passengerCapacity, List<Destination> destinations, List<Passenger> passengers) {
        this.id = id;
        this.name = name;
        this.passengerCapacity = passengerCapacity;
        this.destinations = destinations;
        this.passengers = passengers;
    }

    public void printPackage() {
        System.out.println("Travel Package Details are as below:");
        System.out.println("Package ID: " + this.id);
        System.out.println("Package Name: " + this.name);
        System.out.println("Package Capacity: " + this.passengerCapacity);
        System.out.println("Total passengers enrolled: " +  this.passengers.size());



        System.out.println("Destinations Covered under this package: ");
        for(int i=0; i<this.destinations.size(); i++) {
            this.destinations.get(i).printDestination();
        }
        System.out.println();
        System.out.println();

        System.out.println("Passengers Enrolled in this package :");
        for(int i=0; i<this.passengers.size(); i++) {
//            System.out.println(this.passengers.get(i).getName());
            this.passengers.get(i).printPassenger();
        }

        System.out.println();
        System.out.println();
        System.out.println("Available spaces in each activities: ");
        for(int i=0; i<this.destinations.size(); i++) {
            this.destinations.get(i).printActivitiesWithSpaces();

        }


    }

}
