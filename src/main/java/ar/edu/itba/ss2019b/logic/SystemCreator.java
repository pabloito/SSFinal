package ar.edu.itba.ss2019b.logic;

import ar.edu.itba.ss2019b.SystemConfig;
import ar.edu.itba.ss2019b.model.Airplane;
import ar.edu.itba.ss2019b.model.Grid;
import ar.edu.itba.ss2019b.model.Location;
import ar.edu.itba.ss2019b.model.Passenger;
import ar.edu.itba.ss2019b.model.delays.NoDelay;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class SystemCreator {
    private SystemCreator(){}

    public static Airplane getInitialSystem(){
        Map<Location, Passenger> passengerMap = getPassengerMap();
        return new Airplane(passengerMap);
    }

    private static Map<Location, Passenger> getPassengerMap() {
        Grid grid = Grid.getInstance();
        SystemConfig c = SystemConfig.getInstance();
        Map<Location, Passenger> passengerMap = new HashMap<>();
        List<Location> goals = getGoalList();
        for(int i=0; i< SystemConfig.getInstance().PASSENGER_QUANITTY();i++){
            Location location = grid.getLocation(i,c.AIRPLANE_CENTER());
            passengerMap.put(location,new Passenger(location,goals.get(i),new NoDelay()));
        }
        return passengerMap;
    }

    private static List<Location> getGoalList() {
        return null; //todo: segun algun parametro configurable devolver la lista de asientos en orden. Si el primer pasajero va al Asiento 1A devolver ese asiento primero.
    }
}
