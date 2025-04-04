package UnitTesting.src.test.java.p04_BubbleSortTest;

import UnitTesting.src.main.java.p04_BubbleSortTest.Bubble;
import org.junit.Assert;
import org.junit.Test;

public class BubbleTest {

    @Test
    public void testSort() {
        int[] numbers = {5, 2, 8, 0, -5};
        int[] expectedSortedArray = {-5, 0, 2, 5, 8};
        Bubble.sort(numbers);
        Assert.assertArrayEquals(expectedSortedArray, numbers);
    }
}