package Wild_Farm;

import java.text.DecimalFormat;

public class Cat extends Felime{
    private String breed;

    public Cat(String animalName, String animalType, Double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        return String.format("%s[%s, %s, %s, %s, %d]",getAnimalType(),getAnimalName(),getBreed(),decimalFormat.format(getAnimalWeight()),getLivingRegion(),getFoodEaten());
    }

    @Override
    void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    void eatFood(Food food) {
        setFoodEaten(food.getQuantity());
    }
}
