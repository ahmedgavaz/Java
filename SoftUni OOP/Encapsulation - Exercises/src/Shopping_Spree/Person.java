package Shopping_Spree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public String getName() {
        return name;
    }

    public Person(String name, double money) {
        products = new ArrayList<>();
        setMoney(money);
        setName(name);
    }

    private void setName(String name) {
        if (!name.trim().isEmpty()){
            this.name = name;
        }else {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }

    private void setMoney(double money) {
        if (money>=0){
            this.money=money;
        }else{
            throw new IllegalArgumentException("Money cannot be negative");
        }
    }
    public void buyProduct(Product product){
        if (money>=product.getCost()){
            products.add(product);
            money-=product.getCost();
            System.out.printf("%s bought %s%n",this.name,product.getName());
        }else{
            throw new IllegalArgumentException(this.name+"%s can't afford "+product.getName());
        }
    }
}
