package hexlet.code.games.calc;

import hexlet.code.cli.Cli;
import hexlet.code.games.Game;
import hexlet.code.games.GameBase;
import hexlet.code.games.shared.question.Question;
import hexlet.code.games.shared.question.QuestionImpl;
import hexlet.code.randomizer.Randomizer;
import hexlet.code.user.User;

public final class Calc extends GameBase implements Game {

    private final String[] operations = new String[] {"+", "-", "*"};
    public Calc(Randomizer randomizer, Cli cliTool, User user) {
        super(randomizer, cliTool, user);
        this.title = "What is the result of the expression?";
    }

    public Question generateQuestion() {
        int firstNumber = this.getNumberForQuestion();
        String operation = this.operations[this.getRandomOperationIdx()];
        int secondNumber;

        /*
        If the operation is subtraction ("-"), regenerate the second number
        until it won't be less than the first number
         */
        do {
            secondNumber = this.getNumberForQuestion();
        } while (
                operation.equals("-") && firstNumber < secondNumber
                || operation.equals("*") && secondNumber > 11
        );

        String correctAnswer = this.getCorrectAnswer(firstNumber, secondNumber, operation);

        return new QuestionImpl(
                (firstNumber + " " + operation + " " + secondNumber),
                correctAnswer
        );
    }

    private int getRandomOperationIdx() {
        return this.randomizer.getRandomInt(0, 2);
    }

    public String getCorrectAnswer(int firstNumber, int secondNumber, String operation) {
        int result = switch (operation) {
            case "+" -> firstNumber + secondNumber;
            case "-" -> firstNumber - secondNumber;
            case "*" -> firstNumber * secondNumber;
            default -> throw new IllegalArgumentException("Invalid operation was given: " + operation);
        };

        return Integer.toString(result);
    }
}
