package unitTesting.exercises.p04_BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleTest {
    private final static int[] NUMBERS_ARR = {3, 1, 5, 6, 4, 2};

    @Test
    public void testBubbleSortWorksCorrectly() {
        Bubble.sort(NUMBERS_ARR);
        int[] expectedArr = {1, 2, 3, 4, 5, 6};
        Assert.assertArrayEquals(expectedArr, NUMBERS_ARR);
    }

}