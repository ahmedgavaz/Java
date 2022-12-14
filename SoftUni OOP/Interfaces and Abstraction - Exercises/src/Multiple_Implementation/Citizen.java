package Multiple_Implementation;

public class Citizen implements Person,Identifiable,Birthable{
    private String name;
    private int age;
    private String id;
    private String birthDate;

    public Citizen(String name, int age,String id, String birthDate){
        this.name=name;
        this.age=age;
        this.birthDate=birthDate;
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String getBirthDate() {
        return birthDate;
    }

    @Override
    public String getId() {
        return id;
    }
}
