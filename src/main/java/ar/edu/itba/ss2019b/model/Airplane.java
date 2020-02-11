package ar.edu.itba.ss2019b.model;

import ar.edu.itba.ss2019b.inter.Delay;

import java.util.Map;

public class Airplane {
    private double time;
    private Map<Location, Passenger> passengerMap;
    private Map<Integer, Delay> delayMap;
    private int passengersSat;
    public Airplane(double time, Map<Location, Passenger> passengerMap, Map<Integer, Delay> delayMap, int passengersSat){
        this.passengerMap=passengerMap;
        this.delayMap=delayMap;
        this.time=time;
        this.passengersSat=passengersSat;
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

    public int getPassengersSat(){
        return passengersSat;
    }

    public String stringify() {
        StringBuilder sb = new StringBuilder();

        for(Passenger passenger : passengerMap.values())
            sb.append(passenger.stringify());

        return sb.toString();
    }
}
