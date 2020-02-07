package ar.edu.itba.ss2019b.model.delays;

import ar.edu.itba.ss2019b.inter.Delay;

public class NoDelay implements Delay {
    @Override
    public boolean isOver(double currentTime) {
        return true;
    }
}
