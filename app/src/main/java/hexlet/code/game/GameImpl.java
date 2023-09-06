package hexlet.code.game;

import hexlet.code.cli.Cli;
import hexlet.code.game.even.Even;
import hexlet.code.randomizer.Randomizer;
import hexlet.code.user.User;
import hexlet.code.user.UserImpl;

import java.util.InputMismatchException;

public class GameImpl implements Game {
    private final Cli cliTool;
    private final Randomizer randomizer;
    private User user;

    public GameImpl(
            Cli cliTool
    ) {
        this.cliTool = cliTool;

        Randomizer randomizer = new Randomizer() {
            @Override
            public int getRandomInt(int limit) {
                return 15;
            }
        };
        this.randomizer = randomizer;
    }

    @Override
    public void start() {
        setUp();
    }

    @Override
    public void setUp() {
        GameOption gameOption;
        try {
            gameOption = selectGameOption();
        } catch (IllegalArgumentException e) {
            return;
        }

        switch (gameOption) {
            case GREET:
                this.user = getUserData();
                break;
            case EVEN:
                startGame(new Even(this.randomizer, this.cliTool, this.user));
                break;
            case EXIT:
                System.exit(0);
                break;
            default:
                start();
        }
    }

    private GameOption selectGameOption() {
        System.out.println(getSelectionText());
        for (GameOption option : GameOption.values()) {
            System.out.println(option.getOptionNumber() + " - " + option.getDescription());
        }
        System.out.print(getChoiceText());

        int userChoice;
        try {
            userChoice = cliTool.getGameType();
        } catch (InputMismatchException e) {
            userChoice = -1;
        }

        return GameOption.findByOptionNumber(userChoice);
    }

    private User getUserData() {
        System.out.print("\n" + getStartGreeting());
        String username = cliTool.getUserName();
        System.out.println(getPersonalGreeting(username));

        return new UserImpl(username);
    }

    private void startGame(GameType gameType) {
        gameType.startRound();
    }

    public void end() {

    }

    private static String getSelectionText() {
        return "Please enter the game number and press Enter.\n";
    }

    private static String getChoiceText() {
        return "Your choice: ";
    }

    private static String getStartGreeting() {
        return "Welcome to the Brain Games!\nMay I have your name? ";
    }

    private static String getPersonalGreeting(String username) {
        return "Hello, " + username + "!";
    }
}
