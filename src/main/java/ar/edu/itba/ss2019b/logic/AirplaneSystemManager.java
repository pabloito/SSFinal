package ar.edu.itba.ss2019b.logic;

import ar.edu.itba.ss2019b.SystemConfig;
import ar.edu.itba.ss2019b.inter.Delay;
import ar.edu.itba.ss2019b.model.*;

import java.util.HashMap;
import java.util.Map;

public class AirplaneSystemManager {
    private Grid grid = Grid.getInstance();
    private SystemConfig c = SystemConfig.getInstance();

    private Map<Location, Passenger> nextPassengerMap;
    private Map<Integer, Delay> nextDelayMap;

    private int counter=0;

    public AirplaneSystemManager(){
        nextDelayMap = new HashMap<>();}

    public Airplane getNextAirplane(Airplane airplane, double delta){
        resetMaps();
        calculatePositionsAndDelays(airplane,delta);
        return new Airplane(airplane.getTime()+delta,nextPassengerMap,nextDelayMap, counter);
    }

    private void resetMaps() {
        nextPassengerMap = new HashMap<>();
    }

    private void calculatePositionsAndDelays(Airplane airplane, double delta) {
        double currentTime = airplane.getTime()+delta;
        for(Passenger p : airplane.getPassengerMap().values()){
            Location currentLocation = p.getLocation();
            if(isReadyToMove(p, airplane, currentTime)){
                Location nextLocation = getNextLocation(p);
                Passenger nextPassenger = new Passenger(p.getId(),nextLocation,p.getGoal());
                nextPassengerMap.put(nextLocation,nextPassenger);

                addGhostDelay(currentLocation,airplane, currentTime);
                addPassengerDelays(nextPassenger, airplane, currentTime);
            }else {
                Passenger nextPassenger = new Passenger(p.getId(),currentLocation,p.getGoal());
                nextPassengerMap.put(currentLocation,nextPassenger);
            }
        }

    }

    private Location getNextLocation(Passenger p) {
        if(p.getDirection()==Direction.RIGHT)
            return grid.getNextLocation(p.getLocation(),Direction.RIGHT);
        System.out.printf("Passenger %d arrived at Location x: %d, y: %d\n",p.getId(),p.getGoal().getX(),p.getGoal().getY());
        counter++;
        return p.getGoal();
    }

    private void addGhostDelay(Location currentLocation, Airplane airplane, double currentTime) {
        Location behind = grid.getNextLocation(currentLocation,Direction.LEFT);
        Passenger passengerBehindMovement = airplane.getPassengerMap().get(behind);
        if(passengerBehindMovement!=null){
            nextDelayMap.put(passengerBehindMovement.getId(),Delays.GHOSTDELAY(currentTime));
        }
    }

    private void addPassengerDelays(Passenger nextPassenger, Airplane airplane, double currentTime) {
        switch (nextPassenger.getDirection()){
            case UP:
            case DOWN:
                if(passengerIsOnTheWay(nextPassenger, airplane))
                    nextDelayMap.put(nextPassenger.getId(),Delays.RESEATINGDELAY(currentTime));
                else
                    nextDelayMap.put(nextPassenger.getId(),Delays.UNPACKINGDELAY(currentTime));
                break;
            case RIGHT:
                nextDelayMap.put(nextPassenger.getId(),Delays.MOVEMENTDELAY(currentTime));
                break;
            case LEFT:
                throw new IllegalArgumentException("This shouldnt happen");
            default:
        }
    }

    private boolean passengerIsOnTheWay(Passenger passenger, Airplane airplane) {
        Direction dir = passenger.getDirection();
        Location location = grid.getNextLocation(passenger.getLocation(),dir);
        while(!location.equals(passenger.getGoal())){
            if(airplane.getPassengerMap().get(location)!=null)
                return true;
            location=grid.getNextLocation(location,dir);
        }
        return false;
    }

    private boolean isReadyToMove(Passenger p, Airplane airplane, double currentTime) {
        if(p.getLocation().equals(p.getGoal())) return false;

        Direction dir = p.getDirection();

        boolean delayOver =airplane.getDelayMap().getOrDefault(p.getId(), Delays.NODELAY()).isOver(currentTime);
        boolean nextCellEmpty = (dir != Direction.RIGHT) || isNextCellEmpty(p, airplane);
        return delayOver && nextCellEmpty;
    }

    private boolean isNextCellEmpty(Passenger p, Airplane airplane) {
        Location nextLoc = grid.getNextLocation(p.getLocation(),Direction.RIGHT);
        return airplane.getPassengerMap().get(nextLoc)==null;
    }
}
