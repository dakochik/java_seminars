package ru.hse.cs.seminar02;

import java.math.BigInteger;
import java.util.Optional;

public class Factorial {

    public static Optional<BigInteger> factorial(int value) {
        BigInteger base = BigInteger.ONE;

        if (value < 0) {
            return Optional.empty();
        }

        for (int i = 1; i <= value; i++) {
            base = base.multiply(BigInteger.valueOf(i));
        }

        return Optional.of(base);
         
    }

    public static void main(String[] args) {
        System.out.println(factorial(10));
    }
}