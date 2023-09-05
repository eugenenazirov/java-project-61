package hexlet.code;

import hexlet.code.cli.Cli;
import hexlet.code.cli.CliTool;

public class App {
    private final Cli cliTool;

    App(Cli cliTool) {
        this.cliTool = cliTool;
    }

    private static String getStartGreeting() {
        return "Welcome to the Brain Games!\nMay I have your name? ";
    }

    private static String getPersonalGreeting(String username) {
        return "Hello, " + username + "!";
    }

    private void startGame() {
        System.out.print(getStartGreeting());
        String username = cliTool.getUserName();
        System.out.println(getPersonalGreeting(username));
    }

    public static void main(String[] args) {
        CliTool cliTool = new CliTool();
        App app = new App(cliTool);
        app.startGame();
    }
}
