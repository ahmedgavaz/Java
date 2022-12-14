package Gringotts_Database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "magic_wand")
public class MagicWand {
    @Id
    @Column
    private long id;
    @Column(length = 100)
    private String magicWandCreator;
    @Column
    private long magicWandSize;

    public MagicWand(String magicWandCreator, long magicWandSize) {
        if (magicWandSize>=1 && magicWandSize<=32767){
            setMagicWandSize(magicWandSize);
        }
       setMagicWandCreator(magicWandCreator);
    }

    public MagicWand() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setMagicWandCreator(String magicWandCreator) {
        this.magicWandCreator = magicWandCreator;
    }

    public void setMagicWandSize(long magicWandSize) {
        this.magicWandSize = magicWandSize;
    }

    public long getId() {
        return id;
    }

    public String getMagicWandCreator() {
        return magicWandCreator;
    }

    public long getMagicWandSize() {
        return magicWandSize;
    }
}
