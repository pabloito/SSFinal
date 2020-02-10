package ar.edu.itba.ss2019b;

import ar.edu.itba.ss2019b.logic.AirplaneSystemManager;
import ar.edu.itba.ss2019b.logic.SystemCreator;
import ar.edu.itba.ss2019b.model.Airplane;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        AirplaneSystemManager asm = new AirplaneSystemManager();
        Airplane airplane = SystemCreator.getInitialSystem();
        double delta = 0.02;
        while(true){
            airplane = asm.getNextAirplane(airplane,delta);
        }
    }
}
