package Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private Company company;
    private Car car;
    private List<Pokemon> pokemons;
    private List<Parents> parents;
    private List<Children> children;

    public Person(){
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }
    public Person(Company company, Car car, List<Pokemon> pokemons, List<Parents> parents, List<Children> children) {
        this.company = company;
        this.car = car;
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(Pokemon pokemons) {
        this.pokemons.add(pokemons);
    }

    public List<Parents> getParents() {
        return parents;
    }

    public void setParents(Parents parents) {
        this.parents.add(parents);
    }

    public List<Children> getChildren() {
        return children;
    }

    public void setChildren(Children children) {
        this.children.add(children);
    }
}
