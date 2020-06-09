package utils;

import java.util.Random;

public class RandomUtils {
    public static int intervalo(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("Minimo deve ser maior que maximo");
        }
    
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}