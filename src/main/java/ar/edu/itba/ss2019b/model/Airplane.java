package ar.edu.itba.ss2019b.model;

import ar.edu.itba.ss2019b.inter.Delay;

import java.util.Map;

public class Airplane {
    private Map<Location, Passenger> passengerMap;
    private Map<Integer, Delay> delayMap;
    public Airplane(Map<Location, Passenger> passengerMap, Map<Integer, Delay> delayMap){
        this.passengerMap=passengerMap;
        this.delayMap=delayMap;
    }

    public Map<Location, Passenger> getPassengerMap() {
        return passengerMap;
    }

    public Map<Integer, Delay> getDelayMap() {
        return delayMap;
    }
}
