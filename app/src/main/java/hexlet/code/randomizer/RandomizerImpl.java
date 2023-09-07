package hexlet.code.randomizer;


import java.util.Random;

public class RandomizerImpl implements Randomizer {
    private final Random random = new Random();
    @Override
    public int getRandomInt(int start, int end) {
        return this.random.nextInt((end - start) + 1) + start;
    }
}
