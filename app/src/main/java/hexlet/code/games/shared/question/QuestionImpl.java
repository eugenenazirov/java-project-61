package hexlet.code.games.shared.question;

public final class QuestionImpl implements Question {
    private String question;
    private String answer;

    public QuestionImpl(String generatedQuestion, String correctAnswer) {
        this.question = generatedQuestion;
        this.answer = correctAnswer;
    }

    @Override
    public String getQuestion() {
        return this.question;
    }

    @Override
    public void setQuestion(String questionStrRepresentation) {
        this.question = questionStrRepresentation;
    }

    @Override
    public String getAnswer() {
        return this.answer;
    }

    @Override
    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
