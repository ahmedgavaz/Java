package Comparing_Objects;

public class Person implements Comparable<Person>{
    private String name;
    private int age;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    private String town;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Override
    public int compareTo(Person person) {
        int result = this.name.compareTo(person.getName());
        if (result ==0){
            result = Integer.compare(this.age, person.getAge());
            if (result==0){
                result= this.town.compareTo(person.getTown());
            }
        }
        return result;
    }
}
