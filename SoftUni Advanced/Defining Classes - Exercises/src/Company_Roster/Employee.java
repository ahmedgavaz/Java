package Company_Roster;

public class Employee {
    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private int age;
    public Employee(String name,double salary,String position,String department,String email,int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }
public Employee(String name,double salary,String position,String department){
            this(name,salary,position,department,"n/a",-1);
            }
    public Employee(String name,double salary,String position,String department,int age){
        this(name,salary,position,department,"-1",age);
    }
    public Employee(String name,double salary,String position,String department,String email){
        this(name,salary,position,department,email,-1);
    }
    public Employee(){

    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }

    public String getPosition() {
        return position;
    }
}
