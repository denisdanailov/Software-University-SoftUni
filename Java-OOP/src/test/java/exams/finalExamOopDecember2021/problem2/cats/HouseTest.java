package exams.finalExamOopDecember2021.problem2.cats;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HouseTest {
    private final static String HOUSE_NAME = "Lion's Den";
    private final static int HOUSE_CAPACITY = 10;

    private House house;

    @Before
    public void before() {
        this.house = new House(HOUSE_NAME, HOUSE_CAPACITY);
    }

    @Test
    public void testGetNameMethodWorksCorrectly() {
        String actualOutput = this.house.getName();
        Assert.assertEquals(HOUSE_NAME, actualOutput);
    }

    @Test (expected = NullPointerException.class)
    public void testSetNameThrowsExceptionGivenNull() {
        this.house = new House(null, HOUSE_CAPACITY);
    }

    @Test (expected = NullPointerException.class)
    public void testSetNameThrowsExceptionGivenEmptyString() {
        this.house = new House("  ", HOUSE_CAPACITY);
    }

    @Test
    public void testGetCapacity() {
        int actualOutput = this.house.getCapacity();
        Assert.assertEquals(HOUSE_CAPACITY, actualOutput);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetCapacityThrowsExceptionInvalidCapacity() {
        this.house = new House(HOUSE_NAME, -1);
    }

    @Test
    public void testAddCatMethodAndGetCountWorkCorrectly() {
        Assert.assertEquals(0, this.house.getCount());

        Cat cat1 = new Cat("Tom");
        Cat cat2 = new Cat("Lucy");
        this.house.addCat(cat1);
        this.house.addCat(cat2);

        Assert.assertEquals(2, this.house.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddCatMethodThrowsExceptionNoRoomForCat() {
        this.house = new House(HOUSE_NAME, 1);

        Cat cat1 = new Cat("Tom");
        Cat cat2 = new Cat("Lucy");
        this.house.addCat(cat1);
        this.house.addCat(cat2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRemoveCatMethodThrowsExceptionCatNull() {
        this.house.removeCat("Tiger");
    }

    @Test
    public void testRemoveCatWorksCorrectly() {
        Assert.assertEquals(0, this.house.getCount());

        Cat cat1 = new Cat("Tom");
        Cat cat2 = new Cat("Lucy");
        this.house.addCat(cat1);
        this.house.addCat(cat2);

        this.house.removeCat("Tom");

        Assert.assertEquals(1, this.house.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testCatForSaleMethodThrowsExceptionCatNull() {
        this.house.catForSale("Tiger");
    }

    @Test
    public void testCatForSaleMethodWorksCorrectly() {
        Cat cat1 = new Cat("Tom");
        this.house.addCat(cat1);

        this.house.catForSale("Tom");

        Assert.assertFalse(cat1.isHungry());
    }

    @Test
    public void testStatisticsMethod() {
        Cat cat1 = new Cat("Tom");
        Cat cat2 = new Cat("Lucy");
        this.house.addCat(cat1);
        this.house.addCat(cat2);

        String actualOutput = this.house.statistics();
        String expectedOutput = "The cat Tom, Lucy is in the house Lion's Den!";

        Assert.assertEquals(expectedOutput, actualOutput);
    }
}