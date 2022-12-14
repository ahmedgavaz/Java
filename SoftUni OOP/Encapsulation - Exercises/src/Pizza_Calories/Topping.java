package Pizza_Calories;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if (toppingType.equals("Meat") || toppingType.equals("Veggies") || toppingType.equals("Cheese") ||toppingType.equals("Sauce")){
            this.toppingType = toppingType;
        }else{
            throw new IllegalArgumentException("Cannot place " +toppingType +" on top of your pizza.");
        }
    }

    private void setWeight(double weight) {
        if (weight>=1 && weight<=50){
            this.weight = weight;
        }else{
            throw new IllegalArgumentException(this.toppingType +" weight should be in the range [1..50].");
        }
    }
    public double calculateCalories(){
        double coefficient = 0;
        switch (this.toppingType){
            case "Meat":
                coefficient=1.2;
                break;
            case  "Veggies":
                    coefficient=0.8;
                    break;
            case "Cheese":
                coefficient=1.1;
                break;
            case "Sauce":
                coefficient=0.9;
                break;
        }
        return 2*weight*coefficient;
    }
}
