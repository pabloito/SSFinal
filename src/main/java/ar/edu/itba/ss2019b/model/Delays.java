package ar.edu.itba.ss2019b.model;

import ar.edu.itba.ss2019b.inter.Delay;

public class Delays{

    public static Delay NODELAY(){
        return new NoDelay();
    }
    public static Delay UNPACKINGDELAY(){
        return new UnPackingDelay();
    }
    public static Delay RESEATINGDELAY(){
        return new ReSeatingDelay();
    }
    public static Delay GHOSTDELAY(){
        return new GhostDelay();
    }

    private static class NoDelay implements Delay {
        @Override
        public boolean isOver(double currentTime) {
            return true;
        }
    }
    private static class UnPackingDelay implements Delay {
        @Override
        public boolean isOver(double currentTime) {
            return true; //todo
        }
    }
    private static class ReSeatingDelay implements Delay {
        @Override
        public boolean isOver(double currentTime) {
            return true; //todo
        }
    }
    private static class GhostDelay implements Delay {
        @Override
        public boolean isOver(double currentTime) {
            return true; //todo
        }
    }
}
