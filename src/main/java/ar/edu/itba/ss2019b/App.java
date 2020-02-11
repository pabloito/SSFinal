package ar.edu.itba.ss2019b;

import ar.edu.itba.ss2019b.logic.AirplaneSystemManager;
import ar.edu.itba.ss2019b.logic.SystemCreator;
import ar.edu.itba.ss2019b.model.Airplane;
import ar.edu.itba.ss2019b.logic.AirplaneSystemPrinter;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        AirplaneSystemManager asm = new AirplaneSystemManager();
        AirplaneSystemPrinter asp = new AirplaneSystemPrinter();
        Airplane airplane = SystemCreator.getInitialSystem();
        double delta = 0.05;
        int counter =0;
        boolean stop=false;
        while(!stop){
            if(counter%20==0) {
                asp.printAirplane(airplane);
                System.out.printf("Running and Printing step #%d\n", counter);
            }
            airplane = asm.getNextAirplane(airplane,delta);
            stop = airplane==null;
            counter++;
        }
    }
}
