package hexlet.code.games.prime;

import hexlet.code.cli.Cli;
import hexlet.code.games.Game;
import hexlet.code.games.GameBase;
import hexlet.code.games.shared.question.Question;
import hexlet.code.games.shared.question.QuestionImpl;
import hexlet.code.randomizer.Randomizer;
import hexlet.code.user.User;

import java.util.Arrays;

public final class Prime extends GameBase implements Game {

    private static final int START_CHECK_PRIME = 3;

    public Prime(Randomizer randomizer, Cli cliTool, User user) {
        super(randomizer, cliTool, user);
        this.setTitle("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
    }

    @Override
    public Question generateQuestion() {
        int number = this.getNumberForQuestion();
        boolean isPrime = checkIsNumberPrime(number);

        return new QuestionImpl(
                Integer.toString(number),
                getCorrectAnswer(isPrime)
        );
    }

    private static boolean checkIsNumberPrime(int num) {
        int[] smallestPrimeNumbers = new int[]{2, 3};

        if (num < 2) {
            return false;
        }
        if (Arrays.stream(smallestPrimeNumbers).anyMatch(n -> n == num)) {
            return true;
        }
        if (num % 2 == 0) {
            return false;  // Even numbers (except 2) are not prime
        }

        int sqrt = (int) Math.sqrt(num);
        for (int i = START_CHECK_PRIME; i <= sqrt; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static String getCorrectAnswer(boolean isPrime) {
        return (isPrime) ? "yes" : "no";
    }
}
