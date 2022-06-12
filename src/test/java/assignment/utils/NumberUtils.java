package assignment.utils;

import java.util.Random;

public class NumberUtils {


    public static int getRandomNumber() {

        Random r = new Random();
        int low = 0;
        int high = 3;
        int result = r.nextInt(high - low) + low;
        return result;
    }

    public static int getRandomNumber(int ceil) {

        Random r = new Random();
        int low = 0;
        int high = ceil;
        int result = r.nextInt(high - low) + low;
        return result;
    }
}

