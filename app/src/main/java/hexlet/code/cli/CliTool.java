package hexlet.code.cli;

import java.util.Scanner;

public final class CliTool implements Cli {
    private final Scanner scanner = new Scanner(System.in);

    public String getUserName() {
        return scanner.nextLine();
    }

    public int getGameType() {
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    public String getUserAnswer() {
        return scanner.nextLine();
    }
}
