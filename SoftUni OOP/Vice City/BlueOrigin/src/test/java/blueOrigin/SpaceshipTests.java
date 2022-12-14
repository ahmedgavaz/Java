package blueOrigin;

import org.junit.Assert;
import org.junit.Test;

public class SpaceshipTests {

    @Test
    public void addTestPass(){
        Spaceship spaceship = new Spaceship("Apolo",10);
        Assert.assertEquals(spaceship.getCapacity(),10);
        Assert.assertEquals(spaceship.getCount(),0);
        Astronaut astronaut = new Astronaut("Ahmed",80);
        spaceship.add(astronaut);
        Assert.assertEquals(spaceship.getCount(),1);
        Astronaut astronaut1 = new Astronaut("Ramadan",90);
        spaceship.add(astronaut1);
        Assert.assertEquals(spaceship.getCount(),2);
    }
    @Test(expected = IllegalArgumentException.class)
    public void addFullError(){
        Spaceship spaceship = new Spaceship("Apolo",1);
        Astronaut astronaut = new Astronaut("Ahmed",80);
        Astronaut astronaut1 = new Astronaut("Ramadan",90);
        spaceship.add(astronaut);
        spaceship.add(astronaut1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addExistedError(){
        Spaceship spaceship = new Spaceship("Apolo",10);
        Assert.assertEquals("Apolo",spaceship.getName());
        Astronaut astronaut = new Astronaut("Ahmed",80);
        Astronaut astronaut1 = new Astronaut("Ahmed",80);
        spaceship.add(astronaut);
        spaceship.add(astronaut1);
    }

    @Test
    public void removePass(){
        Spaceship spaceship = new Spaceship("Apolo",10);
        Astronaut astronaut = new Astronaut("Ahmed",80);
        Astronaut astronaut1 = new Astronaut("Ramadan",80);
        spaceship.add(astronaut);
        spaceship.add(astronaut1);
        Assert.assertEquals(spaceship.remove("Ahmed"),true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setCapacityError(){
        Spaceship spaceship = new Spaceship("Apollo",-2);
    }

    @Test(expected = NullPointerException.class)
    public void setNameError(){
        Spaceship spaceship = new Spaceship("",12);
    }
}
