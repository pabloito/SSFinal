package ar.edu.itba.ss2019b.logic;

import ar.edu.itba.ss2019b.SystemConfig;
import ar.edu.itba.ss2019b.inter.Delay;
import ar.edu.itba.ss2019b.model.*;
import sun.security.krb5.Config;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class SystemCreator {
    private SystemCreator(){}

    public static Airplane getInitialSystem() throws IOException {
        Map<Location, Passenger> passengerMap = getPassengerMap();
        Map<Integer, Delay> delayMap = getDelayMap();
        return new Airplane(0,passengerMap, delayMap);
    }

    private static Map<Location, Passenger> getPassengerMap() throws IOException {
        Grid grid = Grid.getInstance();
        SystemConfig c = SystemConfig.getInstance();
        Map<Location, Passenger> passengerMap = new HashMap<>();
        List<Location> goals = getGoalList();
        for(int i=0; i< SystemConfig.getInstance().PASSENGER_QUANITTY();i++){
            Location location = grid.getLocation(i,c.AIRPLANE_CENTER());
            passengerMap.put(location,new Passenger(i,location,goals.get(i)));
        }
        return passengerMap;
    }

    private static List<Location> getGoalList() throws IOException {
        List<Location> goals = new ArrayList<>();

        BufferedReader reader = openSeatConfiguration();
        String line;
        while ((line = reader.readLine()) != null) {
            int len = line.length();

            String col = line.substring(0,len-1);
            char row = line.charAt(len-1);

            int colNum = Integer.parseInt(col);
            goals.add(locationFromSeat(colNum,row));
        }

        return goals;
    }

    private static Location locationFromSeat(int colNum, Character row) {
        SystemConfig c=SystemConfig.getInstance();
        int xBase = c.HORIZONTAL_OFFSET();
        int yBase = c.VERTICAL_OFFSET();
        int x = xBase+colNum-1;
        int y =yBase+Character.getNumericValue(Character.toUpperCase(row)) - Character.getNumericValue('A');
        return Grid.getInstance().getLocation(x,y);
    }

    private static BufferedReader openSeatConfiguration() {
        try{
            return new BufferedReader(new FileReader(SystemConfig.getInstance().SEAT_PATH()));
        }catch (FileNotFoundException e) {
            throw new IllegalArgumentException();
        }
    }

    private static Map<Integer, Delay> getDelayMap() {
        Map<Integer, Delay> delayMap = new HashMap<>();
        for(int i=0; i<SystemConfig.getInstance().PASSENGER_QUANITTY(); i++){
            delayMap.put(i, Delays.NODELAY());
        }
        return delayMap;
    }
}
