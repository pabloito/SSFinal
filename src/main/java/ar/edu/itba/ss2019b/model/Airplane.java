package ar.edu.itba.ss2019b.model;

import java.util.Map;

public class Airplane {
    private Map<Location, Passenger> passengerMap;
    public Airplane(Map<Location, Passenger> passengerMap){
        this.passengerMap=passengerMap;
    }
}
