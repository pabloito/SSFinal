package ar.edu.itba.ss2019b.model;

import ar.edu.itba.ss2019b.SystemConfig;
import ar.edu.itba.ss2019b.inter.Delay;

public class Delays{

    private static NoDelay noDelayInstance = new NoDelay();

    public static Delay NODELAY(){
        return noDelayInstance;
    }
    public static Delay UNPACKINGDELAY(double currentTime){
        return new UnPackingDelay(currentTime);
    }
    public static Delay RESEATINGDELAY(double currentTime){
        return new ReSeatingDelay(currentTime);
    }
    public static Delay GHOSTDELAY(double currentTime){
        return new GhostDelay(currentTime);
    }
    public static Delay MOVEMENTDELAY(double currentTime){
        return new MovementDelay(currentTime);
    }

    private static class NoDelay implements Delay {
        @Override
        public boolean isOver(double currentTime) {
            return true;
        }

        @Override
        public boolean isColored() {
            return false;
        }
    }
    private static class UnPackingDelay implements Delay {
        private double initalTime;
        private double delayTime;
        UnPackingDelay(double initalTime){
            this.initalTime=initalTime;
            double aMean = SystemConfig.getInstance().DELAY_BAGS();
            double aStd = SystemConfig.getInstance().DELAY_STD();
            this.delayTime= RandomHelper.getGaussian(aMean,aStd);
            this.delayTime= (delayTime<0)?0:delayTime;
        }
        @Override
        public boolean isOver(double currentTime) {
            return delayTime<currentTime-initalTime;
        }

        @Override
        public boolean isColored() {
            return true;
        }
    }
    private static class ReSeatingDelay implements Delay {
        private double initalTime;
        private double delayTime;
        ReSeatingDelay(double initalTime){
            this.initalTime=initalTime;
            double aMean = SystemConfig.getInstance().DELAY_GETUP();
            double aStd = SystemConfig.getInstance().DELAY_STD();
            this.delayTime= RandomHelper.getGaussian(aMean,aStd);
            this.delayTime= (delayTime<0)?0:delayTime;
        }
        @Override
        public boolean isOver(double currentTime) {
            return delayTime<currentTime-initalTime;
        }

        @Override
        public boolean isColored() {
            return true;
        }
    }
    private static class GhostDelay implements Delay {
        private double initalTime;
        private double delayTime;
        GhostDelay(double initalTime){
            this.initalTime=initalTime;
            this.delayTime= SystemConfig.getInstance().DELAY_GHOST();
        }
        @Override
        public boolean isOver(double currentTime) {
            return delayTime<currentTime-initalTime;
        }

        @Override
        public boolean isColored() {
            return false;
        }
    }
    private static class MovementDelay implements Delay {
        private double initalTime;
        private double delayTime;
        MovementDelay(double initalTime){
            this.initalTime=initalTime;
            this.delayTime= SystemConfig.getInstance().DELAY_MOVEMENT();
        }
        @Override
        public boolean isOver(double currentTime) {
            return delayTime<currentTime-initalTime;
        }

        @Override
        public boolean isColored() {
            return false;
        }
    }
}
