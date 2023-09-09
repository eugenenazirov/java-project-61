package hexlet.code.user;

public final class UserImpl implements User {

    private String username;

    public UserImpl(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
