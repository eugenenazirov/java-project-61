package hexlet.code.engine;

import hexlet.code.games.shared.GameOption;

public interface GameEngine {

    void start();
    void startGame(GameOption gameOption);
    void end();
}
