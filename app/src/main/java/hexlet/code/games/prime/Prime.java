package hexlet.code.games.prime;

import hexlet.code.cli.Cli;
import hexlet.code.games.Game;
import hexlet.code.games.GameBase;
import hexlet.code.games.shared.question.Question;
import hexlet.code.games.shared.question.QuestionImpl;
import hexlet.code.randomizer.Randomizer;
import hexlet.code.user.User;

public class Prime extends GameBase implements Game {

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
        if (num < 2) {
            return false;
        }
        if (num == 2 || num == 3) {
            return true;
        }
        if (num % 2 == 0) {
            return false;  // Even numbers (except 2) are not prime
        }

        int sqrt = (int) Math.sqrt(num);
        for (int i = 3; i <= sqrt; i += 2) {
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
