package viceCity.repositories.interfaces;

import viceCity.models.guns.Gun;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class GunRepository implements Repository{
    private Collection<Gun> models;

    public GunRepository() {
        models=new ArrayList<>();
    }

    @Override
    public Collection getModels() {
        return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(Object model) {
        if (!models.contains(model)){
            models.add((Gun) model);
        }
    }

    @Override
    public boolean remove(Object model) {
        return models.remove(model);
    }

    @Override
    public Object find(String name) {
        return models.stream().filter(e->e.getName().equals(name)).limit(1);
    }
}
