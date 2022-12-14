package softuni.exam.models.dto;

import javax.persistence.Column;
import javax.validation.constraints.Size;

public class TownDTO {
    private String townName;
    private Integer population;

    public TownDTO(String townName, Integer population) {
        setTownName(townName);
        setPopulation(population);
    }

    public TownDTO(String townName, Integer population, boolean isCorrect) {
        this.townName = townName;
        this.population = population;

    }

    public TownDTO() {
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public boolean isCorrect() {
        if (townName.length()<2 || population<=0){
            return false;
        }
        return true;
    }

}
