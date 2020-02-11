package ar.edu.itba.ss2019b;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public final class SystemConfig {
    private double SIMULATION_DELTA_TIME;
    private int FRAMES_PER_PRINT;
    private boolean LOG_ON;

    private int PASSENGER_QUANITTY;

    private double DELAY_GHOST;
    private double DELAY_GETUP;
    private double DELAY_BAGS;
    private double DELAY_MOVEMENT;
    private double DELAY_STD;

    private int AIRPLANE_HEIGHT;
    private int AIRPLANE_WIDTH;
    private int HORIZONTAL_OFFSET;
    private int VERTICAL_OFFSET;
    private int AIRPLANE_CENTER;

    private String OUTPUT_PATH;
    private String SEAT_PATH;

    private static SystemConfig instance;

    public static SystemConfig getInstance(){
        if(instance==null){
            instance=new SystemConfig();
        }
        return instance;
    }

    private SystemConfig() {

        try{
            recoverValuesFromXML();
        }
        catch (ParserConfigurationException | IOException | SAXException e){
            System.err.println("Invalid XML file. '"+e.getMessage()+"'");
            throw new IllegalArgumentException();
        }
        PASSENGER_QUANITTY = (this.AIRPLANE_HEIGHT-1)*this.AIRPLANE_WIDTH;
        HORIZONTAL_OFFSET = PASSENGER_QUANITTY;
        VERTICAL_OFFSET = 0;
        AIRPLANE_CENTER = AIRPLANE_HEIGHT/2;
    }

    private void recoverValuesFromXML() throws ParserConfigurationException, IOException, SAXException {
        File file = new File("config.xml");

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(file);

        String SIMULATION_DELTA_TIME = document.getElementsByTagName("SIMULATION_DELTA_TIME").item(0).getTextContent();
        String FRAMES_PER_PRINT = document.getElementsByTagName("FRAMES_PER_PRINT").item(0).getTextContent();
        String LOG_ON = document.getElementsByTagName("LOG_ON").item(0).getTextContent();

        String DELAY_GHOST = document.getElementsByTagName("DELAY_GHOST").item(0).getTextContent();
        String DELAY_GETUP = document.getElementsByTagName("DELAY_GETUP").item(0).getTextContent();
        String DELAY_BAGS = document.getElementsByTagName("DELAY_BAGS").item(0).getTextContent();
        String DELAY_MOVEMENT = document.getElementsByTagName("DELAY_MOVEMENT").item(0).getTextContent();
        String DELAY_STD = document.getElementsByTagName("DELAY_STD").item(0).getTextContent();

        String AIRPLANE_WIDTH = document.getElementsByTagName("AIRPLANE_WIDTH").item(0).getTextContent();
        String AIRPLANE_HEIGHT = document.getElementsByTagName("AIRPLANE_HEIGHT").item(0).getTextContent();

        this.OUTPUT_PATH = document.getElementsByTagName("OUTPUT_PATH").item(0).getTextContent();
        this.SEAT_PATH = document.getElementsByTagName("SEAT_PATH").item(0).getTextContent();

        this.SIMULATION_DELTA_TIME = Double.parseDouble(SIMULATION_DELTA_TIME);
        this.FRAMES_PER_PRINT = Integer.parseInt(FRAMES_PER_PRINT);
        this.LOG_ON = Boolean.parseBoolean(LOG_ON);

        this.DELAY_GHOST = Double.parseDouble(DELAY_GHOST);
        this.DELAY_GETUP = Double.parseDouble(DELAY_GETUP);
        this.DELAY_BAGS = Double.parseDouble(DELAY_BAGS);
        this.DELAY_MOVEMENT = Double.parseDouble(DELAY_MOVEMENT);
        this.DELAY_STD = Double.parseDouble(DELAY_STD);

        this.AIRPLANE_HEIGHT = Integer.parseInt(AIRPLANE_HEIGHT);
        this.AIRPLANE_WIDTH = Integer.parseInt(AIRPLANE_WIDTH);
    }

    public double SIMULATION_DELTA_TIME(){return SIMULATION_DELTA_TIME;}
    public int FRAMES_PER_PRINT(){return FRAMES_PER_PRINT;}
    public boolean LOG_ON(){return LOG_ON;}
    public int PASSENGER_QUANITTY(){return PASSENGER_QUANITTY;}
    public double DELAY_GHOST(){return DELAY_GHOST;}
    public double DELAY_GETUP(){return DELAY_GETUP;}
    public double DELAY_BAGS(){return DELAY_BAGS;}
    public double DELAY_STD(){return DELAY_STD;}
    public int AIRPLANE_HEIGHT(){return AIRPLANE_HEIGHT;}
    public int AIRPLANE_WIDTH(){return AIRPLANE_WIDTH;}
    public int HORIZONTAL_OFFSET(){return HORIZONTAL_OFFSET;}
    public int VERTICAL_OFFSET(){return VERTICAL_OFFSET;}
    public String OUTPUT_PATH(){return OUTPUT_PATH;}
    public String SEAT_PATH(){return SEAT_PATH;}
    public int AIRPLANE_CENTER(){return AIRPLANE_CENTER;}

    public double DELAY_MOVEMENT() {
        return DELAY_MOVEMENT;
    }
}
