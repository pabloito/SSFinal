package ar.edu.itba.ss2019b.model;
import java.util.Random;

/**
 Generate pseudo-random floating point values, with an
 approximately Gaussian (normal) distribution.

 Many physical measurements have an approximately Gaussian
 distribution; this provides a way of simulating such values.
 */
public class RandomHelper {
    private RandomHelper(){}

    private static Random fRandom = new Random();

    public static double getGaussian(double aMean, double aStd){
        return aMean + fRandom.nextGaussian() * aStd;
    }
}
