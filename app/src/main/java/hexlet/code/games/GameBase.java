package hexlet.code.games;

import hexlet.code.Config;
import hexlet.code.cli.Cli;
import hexlet.code.games.shared.question.Question;
import hexlet.code.randomizer.Randomizer;
import hexlet.code.user.User;

public abstract class GameBase implements Game {
    protected String title;
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
        this.showTitle();

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

    public int getNumberForQuestion() {
        int start = 1;
        int end = Config.INT_LIMIT;
        return this.randomizer.getRandomInt(start, end);
    }

    public void showTitle() {
        System.out.println(this.title);
    }

    @Override
    public void showQuestion(Question question) {
        System.out.println("Question: " + question.getQuestion());
    }

    public String getUserAnswer() {
        System.out.print("Your answer: ");
        return this.cliTool.getUserAnswer();
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
