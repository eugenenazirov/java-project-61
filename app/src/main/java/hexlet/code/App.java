package hexlet.code;

import hexlet.code.interfaces.Cli;

public class App {
    private final Cli cliTool = new CliImpl();

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
        App app = new App();
        app.startGame();
    }
}