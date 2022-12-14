package Traffic_Lights;

import static Traffic_Lights.Color.GREEN;

public class Light {
    private Color color;

    public Light(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void changeColor(){
        if (this.color==Color.RED){
            setColor(GREEN);
        }
        else if (this.color== GREEN){
            this.color=Color.YELLOW;
        }
        else if (this.color==Color.YELLOW){
            this.color=Color.RED;
        }
    }
}
