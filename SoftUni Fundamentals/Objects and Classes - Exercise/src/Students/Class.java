package Students;

public class Class {
        private String firstName;
        private String lastName;
        private Double grade;

        public Class(String firstName,String lastName,Double grade){
                this.firstName=firstName;
                this.lastName=lastName;
                this.grade=grade;
        }

        public Double getGrade() {
                return grade;
        }

        public String getLastName() {
                return lastName;
        }

        public String getFirstName() {
                return firstName;
        }

        public String toString(){
                return String.format("%s %s: %.2f",this.firstName,this.lastName,this.grade);
        }
}
