package christmasPastryShop.repositories.interfaces;


import christmasPastryShop.entities.cocktails.interfaces.Cocktail;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CocktailRepositoryImpl implements CocktailRepository<Cocktail>{
   private List<Cocktail> cocktails = new ArrayList<>();
    @Override
    public Cocktail getByName(String name) {
        for (Cocktail cocktail:cocktails) {
            if(cocktail.getName().equals(name)){
                return cocktail;
            }
        }
        return null;
    }

    @Override
    public Collection<Cocktail> getAll() {
        return cocktails;
    }

    @Override
    public void add(Cocktail baseCocktail) {
        cocktails.add(baseCocktail);
    }
}
