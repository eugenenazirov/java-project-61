package hexlet.code.user;

public final class UserImpl implements User {

    private String username;

    public UserImpl(String name) {
        this.username = name;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
