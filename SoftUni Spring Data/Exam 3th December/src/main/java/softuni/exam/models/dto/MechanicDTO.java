package softuni.exam.models.dto;

public class MechanicDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    public MechanicDTO(String firstName, String lastName, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public MechanicDTO() {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isValid() {
        if (firstName.length() < 2 || lastName.length() < 2 || !email.contains("@") || !email.contains(".") || phone.length() < 2) {
            return false;
        }
        return true;
    }
}
