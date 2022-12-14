package Wild_Farm;

public class Tiger extends Felime{
    private String livingRegion;

    public Tiger(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    void makeSound() {
        System.out.println("ROAAR!!!");
        if (getFoodEaten()<0){
            System.out.println("Tigers are not eating that type of food!");
            setFoodEaten(0);
        }
    }

    @Override
    void eatFood(Food food) {
        if (!(food instanceof Meat)){
            setFoodEaten(-1);
        }else{
            setFoodEaten(food.getQuantity());
        }
    }
}
