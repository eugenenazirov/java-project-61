package hexlet.code.games.even;

import hexlet.code.cli.Cli;
import hexlet.code.games.Game;
import hexlet.code.games.GameBase;
import hexlet.code.games.shared.question.Question;
import hexlet.code.games.shared.question.QuestionImpl;
import hexlet.code.randomizer.Randomizer;
import hexlet.code.user.User;

public final class Even extends GameBase implements Game {

    public Even(Randomizer randomizer, Cli cliTool, User user) {
        super(randomizer, cliTool, user);
        this.title = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    public Question generateQuestion() {
        int questionNumber = this.getNumberForQuestion();
        String correctAnswer = this.getCorrectAnswer(questionNumber);

        return new QuestionImpl(
                Integer.toString(questionNumber),
                correctAnswer
        );
    }

    public String getCorrectAnswer(int number) {
        return (number % 2 == 0) ? "yes" : "no";
    }
}
