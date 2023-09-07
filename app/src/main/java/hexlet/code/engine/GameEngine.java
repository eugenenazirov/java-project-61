package hexlet.code.engine;

import hexlet.code.games.GameOption;

public interface GameEngine {

    void start();
    void startGame(GameOption gameOption);
    void end();
}
