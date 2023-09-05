package hexlet.code.game;

import hexlet.code.cli.Cli;
import hexlet.code.user.User;
import hexlet.code.user.UserImpl;

public class GameImpl implements Game {

    private final Cli cliTool;
    private User user;

    public GameImpl(Cli cliTool) {
        this.cliTool = cliTool;
    }

    public void startGame() {
        setUp();
    }

    public void setUp() {
        GameOption gameOption = selectGameOption();

        switch (gameOption) {
            case GREET:
                this.user = getUserData();
            case EXIT:
                System.exit(0);
        }
    }

    private GameOption selectGameOption() {
        System.out.println(getSelectionText());
        for (GameOption option : GameOption.values()) {
            System.out.println(option.getOptionNumber() + " - " + option.getDescription());
        }
        System.out.print(getChoiceText());

        String userChoice = cliTool.getGameType();
        int optionNumber;
        try {
            optionNumber = Integer.parseInt(userChoice);
        } catch (NumberFormatException e) {
            optionNumber = -1;
        }

        return GameOption.findByOptionNumber(optionNumber);
    }

    private User getUserData() {
        System.out.print("\n" + getStartGreeting());
        String username = cliTool.getUserName();
        System.out.println(getPersonalGreeting(username));

        return new UserImpl(username);
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
