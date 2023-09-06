package hexlet.code;

import hexlet.code.cli.CliTool;
import hexlet.code.game.GameImpl;

public class App {

    public static void main(String[] args) {
        CliTool cliTool = new CliTool();
        GameImpl game = new GameImpl(cliTool);
        game.start();
    }
}
