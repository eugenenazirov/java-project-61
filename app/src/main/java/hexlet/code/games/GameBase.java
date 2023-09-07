package hexlet.code.games;

import hexlet.code.Config;
import hexlet.code.cli.Cli;
import hexlet.code.games.question.Question;
import hexlet.code.randomizer.Randomizer;
import hexlet.code.user.User;

public abstract class GameBase implements Game {
    private int successCount = 0;
    protected final Randomizer randomizer;
    protected final Cli cliTool;
    protected final String username;

    public GameBase(
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
        this.showRoundTitle();

        while (successCount < Config.MAX_ATTEMPTS) {
            Question question = this.generateQuestion();
            this.showQuestion(question);

            String correctAnswer = question.getCorrectAnswer();
            String userAnswer = getUserAnswer();

            if (!userAnswer.equalsIgnoreCase(correctAnswer)) {
                this.showLostMessage(userAnswer, correctAnswer);
                return;
            }

            this.showCorrectAnswerMessage();
            this.successCount++;
        }

        this.showSuccessMessage();
    }

    @Override
    public abstract Question generateQuestion();

    @Override
    public void showQuestion(Question question) {
        System.out.println("Question: " + question.getQuestion());
    }

    @Override
    public void showLostMessage(String userAnswer, String correctAnswer) {
        System.out.println(
                "'" + userAnswer + "' is wrong answer ;(. "
                        + "Correct answer was " + "'" + correctAnswer + "'."
        );
        System.out.println("Let's try again, " + this.username + "!");
    }

    @Override
    public void showSuccessMessage() {
        System.out.println("Congratulations, " + username + "!");
    }

    @Override
    public void showCorrectAnswerMessage() {
        System.out.println("Correct!\n");
    }
}
