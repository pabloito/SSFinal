package ar.edu.itba.ss2019b.model;

import ar.edu.itba.ss2019b.inter.Delay;

public class Passenger {
    private int id;
    private Location location;
    private Location goal;
    private boolean delayed;

    public Passenger(int id, Location location, Location goal, boolean delayed) {
        this.id = id;
        this.location = location;
        this.goal = goal;
        this.delayed = delayed;
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

    public boolean isDelayed(){
        return delayed;
    }

    public String stringify() {
        String color = getColor();
        return location.getX()+" "+location.getY()+" "+0.5+" "+color+"\n";
    }

    private String getColor() {
        if(location.equals(goal))
            return  "0 0 255";
        if(delayed)
            return  "255 0 0";
        return "0 255 255";

    }
}
