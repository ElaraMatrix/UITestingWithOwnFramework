package framework.utils;

import java.util.Random;

public final class RandomGenerator extends BaseUtility {

    private RandomGenerator() {}

    public static String getRandomWord() {
        log.info("get random word");
        Random random = new Random();
        int wordLength = (int) (Math.random() * 10 + 3);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < wordLength; i++) {
            char tmp = (char) ('a' + random.nextInt('z' - 'a'));
            sb.append(tmp);
        }
        return sb.toString();
    }

    public static int getRandomNumber(int min, int max) {
        log.info("get random number from " + min + " to " + max);
        return ((int) (Math.random()*(max + 1 - min))) + min;
    }

}