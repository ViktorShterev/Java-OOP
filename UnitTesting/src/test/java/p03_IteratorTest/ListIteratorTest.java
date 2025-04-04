package UnitTesting.src.test.java.p03_IteratorTest;

import UnitTesting.src.main.java.p03_IteratorTest.ListIterator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTest {

    private static final String[] NAMES = new String[]{"Name1", "Name2", "Name3"};
    ListIterator listIterator;


    @Before
    public void setUp() throws OperationNotSupportedException {
        listIterator = new ListIterator(NAMES);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowsWhenNull() throws OperationNotSupportedException {
        new ListIterator(null);
    }

    @Test
    public void testConstructorShouldCreateListIterator() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator(NAMES);
    }

    @Test
    public void testHasNext() {
        Assert.assertTrue(listIterator.hasNext());
        listIterator.move();
        Assert.assertTrue(listIterator.hasNext());
        listIterator.move();
        Assert.assertFalse(listIterator.hasNext());
    }

    @Test
    public void testMove() {
        Assert.assertTrue(listIterator.move());
        Assert.assertTrue(listIterator.move());
        Assert.assertFalse(listIterator.move());
    }

    @Test(expected = IllegalStateException.class)
    public void testPrintThrowsForEmptyList() throws OperationNotSupportedException {
        listIterator = new ListIterator();
        listIterator.print();
    }

    @Test
    public void testPrintWorksCorrectly() {
        int index = 0;
        while (listIterator.hasNext()) {
            Assert.assertEquals(NAMES[index], listIterator.print());
            index++;
            listIterator.move();
        }
    }
}