package hero;

public class Hero {
    private String username;
    private int level;

    public String getUsername() {
        return username;
    }

    public Hero(String username, int level) {
        this.username = username;
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return String.format("Type: %s Username: %s Level: %s",
                this.getClass().getName(),
                this.getUsername(),
                this.getLevel());

    }
}
