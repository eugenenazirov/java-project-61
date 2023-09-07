package hexlet.code.games;


import hexlet.code.games.question.Question;

public interface Game {
    void startRound();
    void showTitle();
    int getNumberForQuestion();
    Question generateQuestion();
    String getUserAnswer();
    void showQuestion(Question question);
    void showLostMessage(String userAnswer, String correctAnswer);
    void showSuccessMessage();
    void showCorrectAnswerMessage();
}
