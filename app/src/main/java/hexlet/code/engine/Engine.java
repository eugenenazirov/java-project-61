package hexlet.code.engine;

import hexlet.code.cli.Cli;
import hexlet.code.games.gcd.GCD;
import hexlet.code.games.shared.GameOption;
import hexlet.code.games.Game;
import hexlet.code.games.calc.Calc;
import hexlet.code.games.even.Even;
import hexlet.code.randomizer.Randomizer;
import hexlet.code.randomizer.RandomizerImpl;
import hexlet.code.user.User;
import hexlet.code.user.UserImpl;

import java.util.InputMismatchException;

public class Engine implements GameEngine {
    private final Cli cliTool;
    private User user;

    public Engine(
            Cli cliTool
    ) {
        this.cliTool = cliTool;
    }

    @Override
    public void start() {
        GameOption gameOption;
        try {
            gameOption = this.selectGameOption();
        } catch (IllegalArgumentException e) {
            return;
        }

        this.user = getUserData();

        this.startGame(gameOption);
    }

    public void startGame(GameOption gameOption) {
        Randomizer randomizer = new RandomizerImpl();

        switch (gameOption) {
            case GREET:
                return;
            case EVEN:
                runGame(new Even(randomizer, this.cliTool, this.user));
                return;
            case CALC:
                runGame(new Calc(randomizer, this.cliTool, this.user));
                return;
            case GCD:
                runGame(new GCD(randomizer, this.cliTool, this.user));
                return;
            case EXIT:
                this.end();
                return;
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

    private void runGame(Game game) {
        game.startRound();
    }

    public void end() {
        System.exit(0);
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
