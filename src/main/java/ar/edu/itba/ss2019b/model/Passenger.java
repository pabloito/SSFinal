package ar.edu.itba.ss2019b.model;

import ar.edu.itba.ss2019b.inter.Delay;

public class Passenger {
    private Location location;
    private Location goal;

    public Passenger(Location location, Location goal) {
        this.location = location;
        this.goal = goal;
    }

    public Location getLocation() {
        return location;
    }

    public Location getGoal() {
        return goal;
    }
}
