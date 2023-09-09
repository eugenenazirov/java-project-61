package hexlet.code.games.progression;

import hexlet.code.Config;
import hexlet.code.cli.Cli;
import hexlet.code.games.Game;
import hexlet.code.games.GameBase;
import hexlet.code.games.shared.question.Question;
import hexlet.code.games.shared.question.QuestionImpl;
import hexlet.code.randomizer.Randomizer;
import hexlet.code.user.User;

public final class Progression extends GameBase implements Game {

    public Progression(Randomizer randomizer, Cli cliTool, User user) {
        super(randomizer, cliTool, user);
        this.setTitle("What number is missing in the progression?");
    }

    @Override
    public Question generateQuestion() {
        int progressionStep = this.getProgressionStep();
        int[] progression = this.generateProgression(
                this.getNumberForQuestion(),
                progressionStep
        );
        int missingElementIdx = this.getMissingIdx(progression);

        String progressionWithMissingElement = this.progressionToString(
                progression, missingElementIdx
        );

        return new QuestionImpl(
                progressionWithMissingElement,
                Integer.toString(progression[missingElementIdx])
        );
    }

    private int[] generateProgression(int start, int step) {
        int[] progression = new int[Config.PROGRESSION_LENGTH];
        for (int i = 0; i < Config.PROGRESSION_LENGTH; i++) {
            progression[i] = start + i * step;
        }
        return progression;
    }

    private String progressionToString(int[] progression, int missingElementIdx) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < progression.length; i++) {
            String element =
                    (i != missingElementIdx)
                    ? Integer.toString(progression[i])
                    : "..";

            sb.append(element);

            if (i < progression.length - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    private int getProgressionStep() {
        return this.randomizer.getRandomInt(2, 12);
    }

    private int getMissingIdx(int[] array) {
        return this.randomizer.getRandomInt(0, array.length - 1);
    }
}
