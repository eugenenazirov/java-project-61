package hexlet.code.games.even;

import hexlet.code.Config;
import hexlet.code.cli.Cli;
import hexlet.code.games.Game;
import hexlet.code.games.GameBase;
import hexlet.code.games.question.Question;
import hexlet.code.games.question.QuestionImpl;
import hexlet.code.randomizer.Randomizer;
import hexlet.code.user.User;

public class Even extends GameBase implements Game {
    public Even(Randomizer randomizer, Cli cliTool, User user) {
        super(randomizer, cliTool, user);
    }

    public int getNumberForQuestion() {
        return this.randomizer.getRandomInt(Config.INT_LIMIT);
    }

    public String getCorrectAnswer(int number) {
        return (number % 2 == 0) ? "yes" : "no";
    }

    public Question generateQuestion() {
        int questionNumber = this.getNumberForQuestion();
        String correctAnswer = this.getCorrectAnswer(questionNumber);

        return new QuestionImpl(
                Integer.toString(questionNumber),
                correctAnswer
        );
    }

    public String getUserAnswer() {
        System.out.print("Your answer: ");
        return this.cliTool.getUserAnswer();
    }

    public void showRoundTitle() {
        String roundTitle = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        System.out.println(roundTitle);
    }

    public void showLostMessage(String userAnswer, String correctAnswer) {
        System.out.println(
                "'" + userAnswer + "' is wrong answer ;(. "
                        + "Correct answer was " + "'" + correctAnswer + "'."
        );
        System.out.println("Let's try again, " + this.username + "!");
    }

    public void showSuccessMessage() {
        System.out.println("Congratulations, " + this.username + "!");
    }

    public void showCorrectAnswerMessage() {
        System.out.println("Correct!\n");
    }
}
