package hexlet.code.games;

import hexlet.code.Config;
import hexlet.code.cli.Cli;
import hexlet.code.games.shared.question.Question;
import hexlet.code.randomizer.Randomizer;
import hexlet.code.user.User;

/**
 * Represents the base for all game types providing essential game mechanisms.
 * <p>
 * This class should be extended to create specific game implementations.
 * </p>
 */
public abstract class GameBase implements Game {
    private String title;
    private int successCount = 0;
    private final Randomizer random;
    private final Cli cli;
    private final String username;

    /**
     * Constructor to initialize the essential components required for the game.
     *
     * @param randomizer a utility to generate random numbers.
     * @param cliTool a utility to interact with the command line interface.
     * @param user the user playing the game.
     */
    public GameBase(
            Randomizer randomizer,
            Cli cliTool,
            User user
    ) {
        this.random = randomizer;
        this.cli = cliTool;
        this.username = user.getUsername();
    }

    /**
     * Starts a new round of the game.
     * <p>
     * When extending this class, subclasses should ensure they call this method
     * if they override it to keep the basic game flow.
     * </p>
     */
    @Override
    public void startRound() {
        this.showTitle();

        while (successCount < Config.MAX_ATTEMPTS) {
            Question question = this.generateQuestion();
            this.showQuestion(question);

            String correctAnswer = question.getAnswer();
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

    /**
     * Generates a new question for the game round.
     * <p>
     * Subclasses should provide their own implementation to produce game-specific questions.
     * </p>
     *
     * @return a {@link Question} object representing the game question.
     */
    @Override
    public abstract Question generateQuestion();

    /**
     * Fetches a random number between specified limits.
     *
     * @return a random integer used for game questions.
     */
    public int getNumberForQuestion() {
        int start = 1;
        int end = Config.INT_LIMIT;
        return this.random.getRandomInt(start, end);
    }


    /**
     * Displays the title of the game.
     */
    @Override
    public void showTitle() {
        System.out.println(this.getTitle());
    }

    /**
     * Displays the generated game question to the user.
     *
     * @param question the game question to be displayed.
     */
    @Override
    public void showQuestion(Question question) {
        System.out.println("Question: " + question.getQuestion());
    }

    /**
     * Prompts the user for their answer and fetches it.
     *
     * @return the answer provided by the user.
     */
    @Override
    public String getUserAnswer() {
        System.out.print("Your answer: ");
        return this.cli.getUserAnswer();
    }

    /**
     * Displays a message if the user's answer is incorrect.
     *
     * @param userAnswer the answer provided by the user.
     * @param correctAnswer the correct answer for the game question.
     */
    @Override
    public void showLostMessage(String userAnswer, String correctAnswer) {
        System.out.println(
                "'" + userAnswer + "' is wrong answer ;(. "
                        + "Correct answer was " + "'" + correctAnswer + "'."
        );
        System.out.println("Let's try again, " + this.username + "!");
    }

    /**
     * Displays a success message to the user.
     */
    @Override
    public void showSuccessMessage() {
        System.out.println("Congratulations, " + username + "!");
    }

    /**
     * Displays a message when the user's answer is correct.
     */
    @Override
    public void showCorrectAnswerMessage() {
        System.out.println("Correct!\n");
    }

    /**
     * Retrieves the title of the game.
     *
     * @return the game's title.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Sets the title for the game.
     *
     * @param title the desired title.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    public Cli getCli() {
        return this.cli;
    }

    public Randomizer getRandomTool() {
        return this.random;
    }

    public String getUsername() {
        return this.username;
    }
}
