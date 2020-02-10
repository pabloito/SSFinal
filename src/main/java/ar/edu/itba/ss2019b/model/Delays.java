package ar.edu.itba.ss2019b.model;

import ar.edu.itba.ss2019b.inter.Delay;

public class Delays{

    public static Delay NODELAY(){
        return new NoDelay();
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
    }
    private static class UnPackingDelay implements Delay {
        private double initalTime;
        UnPackingDelay(double initalTime){
            this.initalTime=initalTime;
        }
        @Override
        public boolean isOver(double currentTime) {
            return true; //todo
        }
    }
    private static class ReSeatingDelay implements Delay {
        private double initalTime;
        ReSeatingDelay(double initalTime){
            this.initalTime=initalTime;
        }
        @Override
        public boolean isOver(double currentTime) {
            return true; //todo
        }
    }
    private static class GhostDelay implements Delay {
        private double initalTime;
        GhostDelay(double initalTime){
            this.initalTime=initalTime;
        }
        @Override
        public boolean isOver(double currentTime) {
            return true; //todo
        }
    }
    private static class MovementDelay implements Delay {
        private double initalTime;
        MovementDelay(double initalTime){
            this.initalTime=initalTime;
        }
        @Override
        public boolean isOver(double currentTime) {
            return true; //todo
        }
    }
}
