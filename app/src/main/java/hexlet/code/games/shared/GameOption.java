package hexlet.code.games.shared;

public enum GameOption {
    GREET(1, "Greet"),
    EVEN(2, "Even"),
    CALC(3, "Calc"),
    GCD(4, "GCG"),
    PROGRESSION(5, "Progression"),
    PRIME(6, "Prime"),
    EXIT(0, "Exit");

    private final int optionNumber;
    private final String optionDescription;

    GameOption(int option, String description) {
        this.optionNumber = option;
        this.optionDescription = description;
    }

    public int getOptionNumber() {
        return optionNumber;
    }

    public String getOptionDescription() {
        return optionDescription;
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
