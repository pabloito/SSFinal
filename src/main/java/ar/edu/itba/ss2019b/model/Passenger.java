package ar.edu.itba.ss2019b.model;

import ar.edu.itba.ss2019b.inter.Delay;

public class Passenger {
    private Location location;
    private Location goal;
    private Delay delay;

    public Passenger(Location location, Location goal, Delay delay) {
        this.location = location;
        this.goal = goal;
        this.delay = delay;
    }

    public Location getLocation() {
        return location;
    }

    public Location getGoal() {
        return goal;
    }

    public Delay getDelay() {
        return delay;
    }
}
