package ar.edu.itba.ss2019b.model;

import ar.edu.itba.ss2019b.inter.Delay;

import java.util.Map;

public class Airplane {
    private double time;
    private Map<Location, Passenger> passengerMap;
    private Map<Integer, Delay> delayMap;
    public Airplane(double time, Map<Location, Passenger> passengerMap, Map<Integer, Delay> delayMap){
        this.passengerMap=passengerMap;
        this.delayMap=delayMap;
        this.time=time;
    }

    public Map<Location, Passenger> getPassengerMap() {
        return passengerMap;
    }

    public Map<Integer, Delay> getDelayMap() {
        return delayMap;
    }

    public double getTime() {
        return time;
    }

    public String stringify() {
        StringBuilder sb = new StringBuilder();

        for(Passenger passenger : passengerMap.values())
            sb.append(passenger.stringify());

        return sb.toString();
    }
}
