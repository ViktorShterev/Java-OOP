package UnitTesting.src.test.java.p01_Database;

import UnitTesting.src.main.java.p01_Database.Database;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    private final static Integer[] NUMBERS = {1, 2, 3, 4};
    private Database database;

    @Before
    public void setUp() throws OperationNotSupportedException {
        database = new Database(NUMBERS);
    }

    @Test
    public void testConstructorCreatesValidDatabase() throws OperationNotSupportedException {

        Integer[] databaseElements = database.getElements();

        Assert.assertEquals("Wrong length", databaseElements.length, NUMBERS.length);

        for (int i = 0; i < NUMBERS.length; i++) {
            Assert.assertEquals("Different numbers", databaseElements[i], NUMBERS[i]);
        }

//        Assert.assertArrayEquals(databaseElements, NUMBERS);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowsWhenMoreThan16Elements() throws OperationNotSupportedException {

        Integer[] largeTestArray = new Integer[17];
        database = new Database(largeTestArray);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowsWhenLessThan1Element() throws OperationNotSupportedException {

        Integer[] largeTestArray = new Integer[0];
        database = new Database(largeTestArray);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddMethodThrowsWithNull() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testAddMethodAdds() throws OperationNotSupportedException {
        database.add(6);
        Integer[] dbElements = database.getElements();

        Assert.assertEquals(NUMBERS.length + 1, dbElements.length);
        Assert.assertEquals(Integer.valueOf(6), dbElements[dbElements.length - 1]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveMethodThrowsException() throws OperationNotSupportedException {
        for (int i = 0; i < NUMBERS.length; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test
    public void testRemoveMethodRemoves() throws OperationNotSupportedException {
        database.remove();
        Integer[] dbElements = database.getElements();

        Assert.assertEquals(NUMBERS.length - 1, dbElements.length);
        Assert.assertEquals(Integer.valueOf(NUMBERS.length - 1), dbElements[dbElements.length - 1]);
    }
}