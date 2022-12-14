package Pizza_Calories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name,int count) {
        setName(name);
        setToppings(count);
    }

    private void setName(String name) {
        if (name.trim().length()>=1 && name.trim().length()<=15){
            this.name = name;
        }else{
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    private void setToppings(int count) {
        if (count<=10 && count>=0){
            this.toppings = new ArrayList<>(count);
        }else{
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
    }

    public String getName() {
        return name;
    }

    public void addTopping(Topping topping){
        this.toppings.add(topping);
    }

    public double getOverallCalories(){
        return dough.calculateCalories()+toppings.stream().mapToDouble(e->e.calculateCalories()).sum();
    }
}
