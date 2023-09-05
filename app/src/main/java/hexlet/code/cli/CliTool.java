package hexlet.code.cli;

import java.util.Scanner;

public class CliTool implements Cli {
    private final Scanner scanner = new Scanner(System.in);

    public String getUserName() {
        return scanner.nextLine();
    }

    public String getGameType() {
        return scanner.nextLine();
    }

    public String getUserAnswer() {
        return scanner.nextLine();
    }
}
