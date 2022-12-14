package softuni.exam.models.dto;

public class AgentDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String town;

    public AgentDTO(String firstName, String lastName, String email, String town) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.town = town;
    }

    public AgentDTO() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTownName() {
        return town;
    }

    public void setTownName(String town) {
        this.town = town;
    }

    public boolean isValid(){
        if (firstName.length()<2 || lastName.length()<2 || !email.contains("@") || !email.contains(".")){
            return false;
        }
        return true;
    }
}
