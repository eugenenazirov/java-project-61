package hexlet.code.game.even;

import hexlet.code.Config;
import hexlet.code.cli.Cli;
import hexlet.code.game.GameType;
import hexlet.code.randomizer.Randomizer;
import hexlet.code.user.User;

public class Even implements GameType {

    private int successCount = 0;
    private final Randomizer randomizer;
    private final Cli cliTool;
    private final String username;

    public Even(
            Randomizer randomizer,
            Cli cliTool,
            User user
    ) {
        this.randomizer = randomizer;
        this.cliTool = cliTool;
        this.username = user.getUsername();
    }

    @Override
    public void startRound() {
        showRoundTitle();

        while (successCount < 3) {
            int questionNumber = getQuestionNumber();
            showQuestion(questionNumber);

            String correctAnswer = getCorrectAnswer(questionNumber);
            String userAnswer = getUserAnswer();

            if (!userAnswer.equalsIgnoreCase(correctAnswer)) {
                showLostMessage(userAnswer, correctAnswer);
                return;
            }

            showCorrectAnswerMessage();
            this.successCount++;
        }

        showSuccessMessage();
    }

    @Override
    public void finishRound() {

    }

    public int getQuestionNumber() {
        return randomizer.getRandomInt(Config.INT_LIMIT);
    }

    public String getCorrectAnswer(int number) {
        return (number % 2 == 0) ? "yes" : "no";
    }

    public String getUserAnswer() {
        System.out.print("Your answer: ");
        return cliTool.getUserAnswer();
    }

    public void showRoundTitle() {
        String roundTitle = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        System.out.println(roundTitle);
    }

    public void showQuestion(int number) {
        String question = "Question: " + number;
        System.out.println(question);
    }

    public void showLostMessage(String userAnswer, String correctAnswer) {
        System.out.println(
                "'" + userAnswer + "' is wrong answer ;(. "
                + "Correct answer was " + "'" + correctAnswer + "'."
        );
        System.out.println("Let's try again, " + this.username + "!");
    }

    public void showSuccessMessage() {
        System.out.println("Congratulations, " + username);
    }

    public void showCorrectAnswerMessage() {
        System.out.println("Correct!\n");
    }
}
