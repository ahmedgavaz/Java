import java.io.Serializable;

public class ddz implements Serializable {
    private String name;
    private int age;

    public ddz(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
