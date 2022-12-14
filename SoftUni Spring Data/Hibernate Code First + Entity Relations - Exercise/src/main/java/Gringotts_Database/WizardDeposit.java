package Gringotts_Database;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class WizardDeposit {
    @Id
    @Column()
    private long id;

    @Column(length = 50)
    private String first_name;

    @Column(length = 60)
    private String last_name;

    @Column(length = 1000)
    private String notes;

    @Column
    @NotNull
    private short age;

    @OneToOne
    @JoinColumn
    private MagicWand wand;

    @OneToMany
    @JoinTable(name = "wizard_deposit",
    joinColumns = @JoinColumn(name ="id"),
    inverseJoinColumns = @JoinColumn(name = "deposit_id"))
    private List<Deposit> deposit;

    public WizardDeposit() {
    }

    public List<Deposit> getDeposit() {
        return deposit;
    }

    public void setDeposit(List<Deposit> deposit) {
        this.deposit = deposit;
    }

    public WizardDeposit(long id, String first_name, String last_name, String notes, short age, MagicWand wand, List<Deposit> deposit) {
        if (id>=1 && id <=Math.pow(2,31)-1){
            setId(id);
        }
       setFirst_name(first_name);
        setLast_name(last_name);
        setNotes(notes);
        setAge(age);
        setWand(wand);
        setDeposit(deposit);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public MagicWand getWand() {
        return wand;
    }

    public void setWand(MagicWand wand) {
        this.wand = wand;
    }


}
