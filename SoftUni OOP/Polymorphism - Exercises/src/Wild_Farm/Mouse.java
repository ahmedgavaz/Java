package Wild_Farm;

public class Mouse extends Mammal{
    public Mouse(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    void makeSound() {
        System.out.println("SQUEEEAAAK!");
        if (getFoodEaten()<0){
            System.out.println("Mice are not eating that type of food!");
            setFoodEaten(0);
        }
    }

    @Override
    void eatFood(Food food) {
        if (!(food instanceof Vegetable)){
            setFoodEaten(-1);
        }else{
            setFoodEaten(food.getQuantity());
        }
    }

}
