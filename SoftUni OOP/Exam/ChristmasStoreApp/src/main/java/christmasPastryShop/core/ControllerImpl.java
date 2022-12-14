package christmasPastryShop.core;

import christmasPastryShop.core.interfaces.Controller;
import christmasPastryShop.entities.booths.interfaces.OpenBooth;
import christmasPastryShop.entities.booths.interfaces.PrivateBooth;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.cocktails.interfaces.Hibernation;
import christmasPastryShop.entities.cocktails.interfaces.MulledWine;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.entities.delicacies.interfaces.Gingerbread;
import christmasPastryShop.entities.delicacies.interfaces.Stolen;
import christmasPastryShop.repositories.interfaces.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ControllerImpl implements Controller {
    private DelicacyRepository<Delicacy> delicacyRepository;
    private CocktailRepository<Cocktail> cocktailRepository;
    private BoothRepository<Booth> boothRepository;

    public ControllerImpl(DelicacyRepository<Delicacy> delicacyRepository, CocktailRepository<Cocktail> cocktailRepository, BoothRepository<Booth> boothRepository) {
    this.delicacyRepository=new DelicacyRepositoryImpl();
    this.boothRepository=new BoothRepositoryImpl();
    this.cocktailRepository = new CocktailRepositoryImpl();
    }


    @Override
    public String addDelicacy(String type, String name, double price) {
      /*  if (delicacyRepository.getAll()==null){
        for (Delicacy delicacy:delicacyRepository.getAll()) {
            if (delicacy.getName().equals(name)){
                String str = String.format("%s %s is already in the pastry shop!",type,name);
                throw new IllegalArgumentException(str);
            }
        }}*/
        if (type.equals("Gingerbread")){
            Gingerbread gingerbread = new Gingerbread(name,price);
            delicacyRepository.add(gingerbread);
        }else{
            Stolen stolen = new Stolen(name,price);
            delicacyRepository.add(stolen);
        }
        String string = String.format("Added delicacy %s - %s to the pastry shop!",name,type);
        return string;
    }

    @Override
    public String addCocktail(String type, String name, int size, String brand) {

       /* for (Cocktail delicacy:cocktailRepository.getAll()) {
            if (delicacy.getName().equals(name)){
                String str = String.format("%s %s is already in the pastry shop!",type,name);
                throw new IllegalArgumentException(str);
            }
        }*/
        if (type.equals("MulledWine")){
            MulledWine mulledWine = new MulledWine(name,size,brand);
            cocktailRepository.add(mulledWine);
        }else{
            Hibernation hibernation = new Hibernation(name,size,brand);
            cocktailRepository.add(hibernation);
        }
        String string = String.format("Added cocktail %s - %s to the pastry shop!",name,type);
        return string;
    }

    @Override
    public String addBooth(String type, int boothNumber, int capacity) {

      /*  for (Booth booth:boothRepository.getAll()) {
            if (booth.getBoothNumber()==boothNumber){
                String str = String.format("Booth %d is already in the pastry shop!",boothNumber);
                throw new IllegalArgumentException(str);
            }
        }*/
        if (type.equals("OpenBooth")){
            OpenBooth openBooth = new OpenBooth(boothNumber,capacity);
            boothRepository.add(openBooth);
        }else{
            PrivateBooth privateBooth = new PrivateBooth(boothNumber,capacity);
            boothRepository.add(privateBooth);
        }
        String string = String.format("Added booth number %d in the pastry shop!",boothNumber);
        return string;
    }

    @Override
    public String reserveBooth(int numberOfPeople) {
        /*for (Booth booth:boothRepository.getAll()) {
            if (booth.getCapacity()>=numberOfPeople){
                String str = String.format("Booth %d has been reserved for %d people!",booth.getBoothNumber(),booth.getCapacity());
                return str;
            }
        }*/
        String string = String.format("No available booth for %d people!",numberOfPeople);
        return string;
    }

    @Override
    public String leaveBooth(int boothNumber) {
        for (Booth booth:  boothRepository.getAll()) {
            if (booth.getCapacity()==boothNumber){
                double bill =booth.getBill();
                booth.clear();
                boothRepository.setIncome(boothRepository.getIncome()+bill);
                //"Booth: {boothNumber}"
                //"Bill: {booth bill:f2}"
                String str = String.format("Booth: %d\nBill: %.2f",boothNumber,bill);
                return str;
            }
        }
        return null;
    }

    @Override
    public String getIncome() {
        double sum = boothRepository.getIncome();
        String str=String.format("Income: %.2flv",sum);
        return str;
    }
}
