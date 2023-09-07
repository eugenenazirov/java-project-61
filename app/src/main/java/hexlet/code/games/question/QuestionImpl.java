package hexlet.code.games.question;

public class QuestionImpl implements Question {
    private String question;
    private String correctAnswer;

    public QuestionImpl(String question, String correctAnswer) {
        this.question = question;
        this.correctAnswer = correctAnswer;
    }

    @Override
    public String getQuestion() {
        return this.question;
    }

    @Override
    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public String getCorrectAnswer() {
        return this.correctAnswer;
    }

    @Override
    public void setCorrectAnswer(String answer) {
        this.correctAnswer = answer;
    }
}
