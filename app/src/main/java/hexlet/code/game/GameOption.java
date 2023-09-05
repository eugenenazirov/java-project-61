package hexlet.code.game;

public enum GameOption {
    GREET(1, "Greet"),
    EVEN(2, "Even"),
    CALC(3, "Calc"),
    GCD(4, "GCG"),
    PROGRESSION(5, "Progression"),
    PRIME(6, "Prime"),
    EXIT(0, "Exit");

    private final int optionNumber;
    private final String description;

    GameOption(int optionNumber, String description) {
        this.optionNumber = optionNumber;
        this.description = description;
    }

    public int getOptionNumber() {
        return optionNumber;
    }

    public String getDescription() {
        return description;
    }

    public static GameOption findByOptionNumber(int optionNumber) {
        for (GameOption option : GameOption.values()) {
            if (option.getOptionNumber() == optionNumber) {
                return option;
            }
        }
        throw new IllegalArgumentException("Invalid option number: " + optionNumber);
    }
}
