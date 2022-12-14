package cats;

import org.junit.Assert;
import org.junit.Test;

public class HouseTests {
    private Cat cat;
    private House house;

    /*@Before
    public void prepareCat() {
        cat = new Cat("Tiger");
        house = new House("My house",10);
    }*/
    @Test
    public void testReturnCapacity(){
        cat = new Cat("Tiger");
        house = new House("My house",10);
        Assert.assertEquals(10,house.getCapacity());
        Assert.assertEquals(0,house.getCount());
        house.addCat(cat);
        Assert.assertEquals(1,house.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void testErrorSetNameOfHouse(){
        cat = new Cat("Tiger");
        house = new House("My house",10);
        house = new House("",3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testErrorSetCapacity(){
        cat = new Cat("Tiger");
        house = new House("My house",10);
        house = new House("Debren",-3);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testHouseIsFull(){
        cat = new Cat("Tiger");
        house = new House("My house",10);
        house = new House("Debren",1);
        Cat cat1 = new Cat("Smuki");
        house.addCat(cat);
        house.addCat(cat1);
    }

    @Test
    public void testRemoveCatPassed(){
        cat = new Cat("Tiger");
        house = new House("My house",10);
        house.addCat(cat);
        Assert.assertEquals(1,house.getCount());
        house.removeCat("Tiger");
        Assert.assertEquals(0,house.getCount());
        Assert.assertEquals("My house",house.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveCatError(){
        cat = new Cat("Tiger");
        house = new House("My house",10);
        house.addCat(cat);
        house.removeCat("fdds");
    }

    @Test
    public void catForSalePass(){
        cat = new Cat("Tiger");
        house = new House("My house",10);
        house.addCat(cat);
        Cat saledCat = house.catForSale("Tiger");
        Assert.assertFalse(saledCat.isHungry());
        Assert.assertEquals(saledCat,cat);
    }

    @Test(expected = IllegalArgumentException.class)
    public void catForSaleError(){
        cat = new Cat("Tiger");
        house = new House("My house",10);
        house.addCat(cat);
        house.catForSale("gdd");
    }

    @Test
    public void testIfTheCatIsHungry(){
        cat = new Cat("Tiger");
        house = new House("My house",10);
        Assert.assertTrue(cat.isHungry());
    }


    @Test
    public void statistics(){
        cat = new Cat("Tiger");
        house = new House("My house",10);
        Cat cat1 = new Cat("Smuki");
        House asus = new House("Asus" , 1);
        asus.addCat(cat1);
        String str = "The cat Smuki is in the house Asus!";
        Assert.assertEquals(str,asus.statistics());
    }
    @Test
    public void statisticsPass(){
        cat = new Cat("Tiger");
        house = new House("My house",10);
        Cat cat1 = new Cat("Smuki");
        House asus = new House("Asus" , 4);
        asus.addCat(cat1);
        asus.addCat(cat);
        String str = "The cat Smuki, Tiger is in the house Asus!";
        Assert.assertEquals(str,asus.statistics());
    }
    @Test
    public void statisticsEmpty(){
        House asus = new House("Asus" , 1);
        String str = "The cat  is in the house Asus!";
        Assert.assertEquals(str,asus.statistics());
    }
}
