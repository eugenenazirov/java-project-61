package hexlet.code.randomizer;

import hexlet.code.Config;

import java.util.Random;

public class RandomizerImpl implements Randomizer {
    private Random random = new Random();
    @Override
    public int getRandomInt(int limit) {
        int start = 1;
        int end = Config.INT_LIMIT;
        return this.random.nextInt((end - start) + 1) + start;
    }
}
