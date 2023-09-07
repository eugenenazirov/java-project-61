package hexlet.code.games.calc;

import hexlet.code.games.Game;
import hexlet.code.games.question.Question;

public class Calc implements Game {
    @Override
    public void startRound() {

    }

    @Override
    public void showTitle() {

    }

    @Override
    public int getNumberForQuestion() {
        return 0;
    }

    @Override
    public Question generateQuestion() {
        return null;
    }

    @Override
    public String getUserAnswer() {
        return null;
    }

    @Override
    public void showQuestion(Question question) {

    }

    @Override
    public void showLostMessage(String userAnswer, String correctAnswer) {

    }

    @Override
    public void showSuccessMessage() {

    }

    @Override
    public void showCorrectAnswerMessage() {

    }
}
