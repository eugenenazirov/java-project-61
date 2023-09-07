package hexlet.code.games.gcd;

import hexlet.code.cli.Cli;
import hexlet.code.games.Game;
import hexlet.code.games.GameBase;
import hexlet.code.games.shared.question.Question;
import hexlet.code.games.shared.question.QuestionImpl;
import hexlet.code.randomizer.Randomizer;
import hexlet.code.user.User;

public class GCD extends GameBase implements Game {

    public GCD(Randomizer randomizer, Cli cliTool, User user) {
        super(randomizer, cliTool, user);
        this.title = "Find the greatest common divisor of given numbers.";
    }

    @Override
    public Question generateQuestion() {
        int firstNumber = this.getNumberForQuestion();
        int secondNumber = this.getNumberForQuestion();
        int gcd = findGCD(firstNumber, secondNumber);

        return new QuestionImpl(
                (firstNumber + " " + secondNumber),
                Integer.toString(gcd)
        );
    }

    public static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;  // Remainder
            a = temp;
        }

        return a;
    }
}
