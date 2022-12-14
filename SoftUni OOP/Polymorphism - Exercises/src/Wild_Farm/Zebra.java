package Wild_Farm;

public class Zebra extends Mammal{
    public Zebra(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    void makeSound() {
        System.out.println("Zs");
        if (getFoodEaten()<0){
            System.out.println("Zebras are not eating that type of food!");
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
