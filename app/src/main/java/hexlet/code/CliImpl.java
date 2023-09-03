package hexlet.code;

import hexlet.code.interfaces.Cli;

import java.util.Scanner;

public class CliImpl implements Cli {
    private final Scanner scanner = new Scanner(System.in);
    public String getUserName() {
        return scanner.nextLine();
    }
}
