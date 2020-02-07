package ar.edu.itba.ss2019b.model;

import ar.edu.itba.ss2019b.SystemConfig;

import java.util.HashMap;
import java.util.Map;

public final class Grid {
    private SystemConfig c;
    private Map<Integer,Location> locationMap;
    private int gridWidth;
    private int gridHeight;
    private static Grid instance = new Grid();

    public static Grid getInstance(){
        return instance;
    }

    private Grid(){
        this.c = SystemConfig.getInstance();
        this.locationMap = new HashMap<>();
        this.gridWidth = c.HORIZONTAL_OFFSET()+c.AIRPLANE_WIDTH();
        this.gridHeight = c.VERTICAL_OFFSET() + c.AIRPLANE_HEIGHT();
    }

    public Location getNextLocation(Location location, Direction direction){
        int x = location.getX();
        int y = location.getY();
        switch (direction){
            case UP:
                y+=1;
                break;
            case DOWN:
                y-=1;
                break;
            case LEFT:
                x-=1;
                break;
            case RIGHT:
                x+=1;
                break;
        }
        return getLocation(x,y);
    }

    public Location getLocation(int x, int y){
        Integer locationKey = getKey(x, y);
        Location location = locationMap.get(locationKey);
        if(location == null){
            location = new Location(x, y);
            locationMap.put(locationKey, location);
        }
        return location;
    }

    private Integer getKey(int x, int y) {
        return x+y*gridWidth;
    }

}
