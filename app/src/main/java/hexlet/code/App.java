package hexlet.code;

import hexlet.code.cli.CliTool;
import hexlet.code.engine.Engine;

public class App {

    public static void main(String[] args) {
        CliTool cliTool = new CliTool();
        Engine game = new Engine(cliTool);
        game.start();
    }
}
