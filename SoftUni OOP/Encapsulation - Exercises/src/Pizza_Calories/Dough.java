package Pizza_Calories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setBakingTechnique(bakingTechnique);
        setFlourType(flourType);
        setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if (flourType.equals("White") || flourType.equals("Wholegrain")){
            this.flourType = flourType;
        }else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (bakingTechnique.equals("Crispy") || bakingTechnique.equals("Chewy") || bakingTechnique.equals("Homemade")){
            this.bakingTechnique = bakingTechnique;
        }else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setWeight(double weight) {
        if (weight>=1 && weight<=200){
            this.weight = weight;
        }else{
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
    }
    public double calculateCalories(){
        double typeCoefficient =0;
        switch (flourType){
            case "White":
                typeCoefficient=1.5;
                break;
            case "Wholegrain":
                typeCoefficient=1;
                break;
        }
        double bakingCoefficient =0;
        switch (bakingTechnique){
            case "Crispy":
                bakingCoefficient=0.9;
                break;
            case "Chewy":
                bakingCoefficient=1.1;
                break;
            case "Homemade":
                bakingCoefficient=1;
                break;
        }
        return 2*weight*bakingCoefficient*typeCoefficient;
    }
}
