package christmasPastryShop.repositories.interfaces;

import christmasPastryShop.entities.delicacies.interfaces.BaseDelicacy;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DelicacyRepositoryImpl implements DelicacyRepository<Delicacy> {
    private List<Delicacy> delicacies = new ArrayList<>();

    @Override
    public Delicacy getByName(String name) {
        for (Delicacy delicacy : delicacies) {
            if (delicacy.getName().equals(name)) {
                return delicacy;
            }
        }
        return null;
    }

    @Override
    public Collection<Delicacy> getAll() {
        return delicacies;
    }

    @Override
    public void add(Delicacy baseDelicacy) {
        delicacies.add(baseDelicacy);
    }
}
