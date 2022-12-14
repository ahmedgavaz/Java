package toyStore;

import org.junit.Test;
import org.junit.Assert;

import javax.naming.OperationNotSupportedException;
import java.util.Map;

public class ToyStoryTest {
        @Test
        public void testReturnManufacturerAndID(){
                Toy toy = new Toy("Ivan","1");
                Assert.assertEquals("1",toy.getToyId());
                Assert.assertEquals("Ivan",toy.getManufacturer());
        }
        @Test
        public void testShelf(){
                ToyStore toyStore = new ToyStore();
                Map<String,Toy> map = toyStore.getToyShelf();
                Assert.assertEquals(null,map.get("A"));
        }
        @Test
        public void testShelff(){
                ToyStore toyStore = new ToyStore();
                Assert.assertEquals(null,toyStore.getToyShelf().get("A"));
        }
        @Test
        public void testShelfer() throws OperationNotSupportedException {
                ToyStore toyStore = new ToyStore();
                Toy toy = new Toy("Ivan","1");
                toyStore.addToy("A",toy);
                Assert.assertEquals("Ivan",toyStore.getToyShelf().get("A").getManufacturer());
        }

        @Test(expected = IllegalArgumentException.class)
        public void testAddError() throws OperationNotSupportedException {
                ToyStore toyStore = new ToyStore();
                Toy toy = new Toy("Ivan","1");
                toyStore.addToy("RG",toy);
                Map<String,Toy> map = toyStore.getToyShelf();
                Assert.assertEquals("Shelf doesn't exist!",map.get("RG").getToyId());
        }
        @Test(expected = OperationNotSupportedException.class)
        public void testAddingError() throws OperationNotSupportedException {
                ToyStore toyStore = new ToyStore();
                Toy toy = null;
                toyStore.addToy("A",toy);
                Map<String,Toy> map = toyStore.getToyShelf();
                Assert.assertEquals("Toy is already in shelf!",map.get("A").getToyId());
        }

        @Test(expected = NullPointerException.class)
        public void testAddErrorEmptyShelf(){
                ToyStore toyStore = new ToyStore();
                toyStore.removeToy("A", null);
                toyStore.removeToy("B", null);
                toyStore.removeToy("C", null);
                toyStore.removeToy("D", null);
                toyStore.removeToy("E", null);
                toyStore.removeToy("F", null);
                toyStore.removeToy("G", null);
                Map<String,Toy> map = toyStore.getToyShelf();
                Assert.assertEquals("Shelf doesn't exist!",map.get("RG").getToyId());
        }
        @Test
        public void testAdd() throws OperationNotSupportedException {
                ToyStore toyStore = new ToyStore();
                Toy toy = new Toy("Ivan","1");
                Assert.assertEquals(String.format("Toy:1 placed successfully!",toy.getToyId()),toyStore.addToy("A",toy));
        }
        @Test
        public void testRemoveSuccess() throws OperationNotSupportedException {
                ToyStore toyStore = new ToyStore();
                Toy toy = new Toy("Ivan","1");
                toyStore.addToy("A",toy);
                Assert.assertEquals("Remove toy:1 successfully!",toyStore.removeToy("A",toy));
        }
        @Test(expected = IllegalArgumentException.class)
        public void testShelfDeletingError(){
                ToyStore toyStore = new ToyStore();
                Assert.assertEquals("Shelf doesn't exists!",toyStore.removeToy("R",null));
        }
        @Test(expected = IllegalArgumentException.class)
        public void testShelfDeleteError(){
                ToyStore toyStore = new ToyStore();
                Toy toy = new Toy("Ivan","1");
                Assert.assertEquals("Toy in that shelf doesn't exists!",toyStore.removeToy("A",toy));
        }

}