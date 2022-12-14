package catHouse.core;

import catHouse.common.ConstantMessages;
import catHouse.common.ExceptionMessages;
import catHouse.entities.cat.Cat;
import catHouse.entities.cat.LonghairCat;
import catHouse.entities.cat.ShorthairCat;
import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;
import catHouse.entities.toys.Ball;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;
import catHouse.repositories.ToyRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ControllerImpl implements Controller {
    private ToyRepository toys;
    private Collection<House> houses;

    public ControllerImpl() {
        this.toys = new ToyRepository();
        this.houses = new ArrayList<>();
    }

    @Override
    public String addHouse(String type, String name) {
        House house = null;
        if (type.equals("LongHouse")) {
            house = new LongHouse(name);
        }
        else if (type.equals("ShortHouse")) {
            house = new ShortHouse(name);
        } else {
            throw new NullPointerException(ExceptionMessages.INVALID_HOUSE_TYPE);
        }
        houses.add(house);
        String message = String.format(ConstantMessages.SUCCESSFULLY_ADDED_HOUSE_TYPE, type);
        return message;
    }

    @Override
    public String buyToy(String type) {
        Toy toy = null;
        if (type.equals("Mouse")) {
            toy = new Mouse();
        }
        else if (type.equals("Ball")) {
            toy = new Ball();
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_TOY_TYPE);
        }
        toys.buyToy(toy);
        String str = String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOY_TYPE, type);
        return str;
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        Toy toy = toys.findFirst(toyType);
        if (toy == null) {
            String str = String.format(ExceptionMessages.NO_TOY_FOUND, toyType);
            throw new IllegalArgumentException(str);
        }
        toys.removeToy(toy);
        for (House home : houses) {
            if (home.getName().equals(houseName)) {
                home.buyToy(toy);
            }
        }
        String string = String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName);
        return string;
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
        if (!catType.equals("ShorthairCat") && !catType.equals("LonghairCat")) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_CAT_TYPE);
        } else {
            Cat cat;
            if (catType.equals("LonghairCat")) {
                cat = new LonghairCat(catName, catBreed, price);
            } else {
                cat = new ShorthairCat(catName, catBreed, price);
            }
            for (House home : houses) {
                if (home.getName().equals(houseName)) {
                    if ((home.getClass().getSimpleName().startsWith("Long") && catType.startsWith("Long")) || (home.getClass().getSimpleName().startsWith("Short") && catType.startsWith("Short"))) {
                        home.addCat(cat);

                    } else {
                        return ConstantMessages.UNSUITABLE_HOUSE;
                    }
                }
            }
        }
        String str = String.format(ConstantMessages.SUCCESSFULLY_ADDED_CAT_IN_HOUSE, catType, houseName);
        return str;
    }

    @Override
    public String feedingCat(String houseName) {
        int sum = 0;
        for (House house : houses) {
            if (house.getName().equals(houseName)) {
                house.feeding();
                sum = house.getCats().size();
            }
        }
        String str = String.format(ConstantMessages.FEEDING_CAT, sum);
        return str;
    }

    @Override
    public String sumOfAll(String houseName) {
        double sum = 0;
        for (House house : houses) {
            if (house.getName().equals(houseName)) {
                house.feeding();
                List<Cat> catList = (List<Cat>) house.getCats();
                for (Cat cat : catList) {
                    sum += cat.getPrice();
                }
                List<Toy> toyList = (List<Toy>) house.getToys();
                for (Toy toy : toyList) {
                    sum += toy.getPrice();
                }
            }
        }
        String str = String.format(ConstantMessages.VALUE_HOUSE, houseName, sum);
        return str;
    }

    @Override
    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        for (House house : houses) {
            stringBuilder.append(house.getStatistics()).append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}
