package Animals;

public class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        setAge(age);
        setGender(gender);
        setName(name);
    }

    public String produceSound(){
        return null;
    }

    public String toString(){
        return String.format("%s%n%s %d %s%n%s",
                this.getClass().getSimpleName(),
                name, age, gender,
                produceSound());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.trim().isEmpty() || name==null){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age<0){
            throw new IllegalArgumentException("Invalid input!");
        }else{
            this.age = age;
        }
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (gender==null || gender.trim().isEmpty() || (!gender.equals("Male") && !gender.equals("Female"))){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.gender = gender;
    }
}
