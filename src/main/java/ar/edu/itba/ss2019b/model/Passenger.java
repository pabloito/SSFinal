package ar.edu.itba.ss2019b.model;

import ar.edu.itba.ss2019b.inter.Delay;

public class Passenger {
    private int id;
    private Location location;
    private Location goal;

    public Passenger(int id, Location location, Location goal) {
        this.id = id;
        this.location = location;
        this.goal = goal;
    }

    public Location getLocation() {
        return location;
    }

    public Location getGoal() {
        return goal;
    }

    public int getId(){
        return id;
    }

    public Direction getDirection(){
        if(location.equals(goal)) return Direction.NONE;
        if(location.getX()<goal.getX()) return Direction.RIGHT;
        if(location.getY()<goal.getY()) return Direction.UP;
        return Direction.DOWN;
    }
}
