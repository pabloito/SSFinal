package ar.edu.itba.ss2019b.logic;

import ar.edu.itba.ss2019b.model.Airplane;
import ar.edu.itba.ss2019b.SystemConfig;

public class AirplaneSystemPrinter {

    private static String PARTICLE_OUTPUT_PATH;
    private static String METRIC_OUTPUT_PATH;
    private SystemConfig c;

    private static String header = "time,sitting\n";

    public AirplaneSystemPrinter(){
        this.c = SystemConfig.getInstance();

        PARTICLE_OUTPUT_PATH = c.OUTPUT_PATH()+"/"+"particle.ov";
        METRIC_OUTPUT_PATH = c.OUTPUT_PATH()+"/metrics.csv";

        Helper.resetFile(PARTICLE_OUTPUT_PATH);
        Helper.resetFile(METRIC_OUTPUT_PATH);
        Helper.appendToFile(header, METRIC_OUTPUT_PATH);
    }

    public void printAirplane(Airplane airplane){
        StringBuilder sb = new StringBuilder();

        sb.append(airplane.getPassengerMap().size());
        sb.append('\n');
        sb.append('\n');
        sb.append(airplane.stringify());

        Helper.appendToFile(sb.toString(),PARTICLE_OUTPUT_PATH);
    }

    public void printAirplaneMetrics(Airplane airplane) {
        String sb = String.valueOf(airplane.getTime()) + ',' +
                airplane.getPassengersSat() + '\n';
        Helper.appendToFile(sb,METRIC_OUTPUT_PATH);
    }
}
