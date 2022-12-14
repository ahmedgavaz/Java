package Birthday_Celebrations;

public class Pet implements Birthable{
    private String name;
    private String birthDate;

    public Pet(String name,String birthDate){
        this.birthDate=birthDate;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getBirthDate() {
        return birthDate;
    }
}
