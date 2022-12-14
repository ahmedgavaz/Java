package christmasPastryShop.repositories.interfaces;

import christmasPastryShop.entities.booths.interfaces.Booth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BoothRepositoryImpl implements BoothRepository<Booth>{
    private List<Booth> booths = new ArrayList<>();
    public double income;

    public List<Booth> getBooths() {
        return booths;
    }

    public void setBooths(List<Booth> booths) {
        this.booths = booths;
    }


    @Override
    public Booth getByNumber(int number) {
        for (Booth baseBooth:booths) {
            if (baseBooth.getBoothNumber()==number){
                return baseBooth;
            }
        }
        return null;
    }

    @Override
    public double getIncome() {
        return income;
    }

    @Override
    public void setIncome(double number) {
        this.income = number;
    }

    @Override
    public Collection<Booth> getAll() {
        return booths;
    }

    @Override
    public void add(Booth baseBooth) {
        booths.add(baseBooth);
    }
}
