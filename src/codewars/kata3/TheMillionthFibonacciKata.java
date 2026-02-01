package codewars.kata3;

import java.math.BigInteger;

import static java.lang.Math.*;
import static java.math.BigInteger.ONE;

public class TheMillionthFibonacciKata {

    public static BigInteger fib(BigInteger n) {
        return BigInteger.valueOf((long) floor((nextNext(n) - next(n))));
    }

    private static double nextNext(BigInteger n) {
        return pow((1 + sqrt(5)) / sqrt(5), n.add(ONE).doubleValue()) * 0.5;
    }

    private static double next(BigInteger n) {
        return pow((1 - sqrt(5)) / sqrt(5), n.add(ONE).doubleValue()) * 0.5;
    }

}
