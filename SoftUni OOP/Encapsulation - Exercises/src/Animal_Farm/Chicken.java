package Animal_Farm;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {

    }

    private void setName(String name) {
        if (!name.trim().isEmpty()){
            this.name = name;
        }else {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
    }

    private void setAge(int age) {
        if (age>=0 && age<=15){
            this.age = age;
        }else{
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
    }
    public double productPerDay(){
        return calculateProductPerDay();
    }
    private double calculateProductPerDay(){
        if (age<6){
            return 2;
        }else if (age<12){
            return 1;
        }else{
            return 0.75;
        }
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day.",name,age,calculateProductPerDay());
    }
}
