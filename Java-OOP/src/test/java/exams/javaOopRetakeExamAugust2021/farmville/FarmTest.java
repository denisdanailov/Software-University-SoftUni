package exams.javaOopRetakeExamAugust2021.farmville;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FarmTest {
    private Farm farm;
    private final static String FARM_NAME = "Clarkson's Farm";
    private final static int FARM_CAPACITY = 10;

    @Before
    public void setUp() {
        farm = new Farm(FARM_NAME, FARM_CAPACITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityThrowsException() {
        Farm testFarm = new Farm(FARM_NAME, -1);
    }

    @Test (expected = NullPointerException.class)
    public void testSetNameThrowsExceptionGivenNull() {
        Farm testFarm = new Farm(null, FARM_CAPACITY);
    }

    @Test (expected = NullPointerException.class)
    public void testSetNameThrowsExceptionGivenEmptyString () {
        Farm testFarm = new Farm("   ", FARM_CAPACITY);
    }

    @Test
    public void testGetNameWorksCorrectly() {
        String expectedName = FARM_NAME;
        String actualName = this.farm.getName();
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void testGetCapacityWorksCorrectly() {
        int expectedCapacity = FARM_CAPACITY;
        int actualCapacity = this.farm.getCapacity();
        Assert.assertEquals(expectedCapacity, actualCapacity);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddMethodThrowsExceptionFullCapacity() {
        Farm testFarm = new Farm(FARM_NAME, 1);
        Animal cow = new Animal("Cow", 60);
        Animal sheep = new Animal("Sheep", 40);
        testFarm.add(cow);
        testFarm.add(sheep);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddMethodThrowsExceptionAnimalAlreadyExists() {
        Animal cow = new Animal("Cow", 60);
        Animal cowIntruder = new Animal("Cow", 40);
        this.farm.add(cow);
        this.farm.add(cowIntruder);
    }

    @Test
    public void testAddMethodAndGetCountWorkCorrectly() {
        Animal cow = new Animal("Cow", 60);
        Animal sheep = new Animal("Sheep", 40);
        this.farm.add(cow);
        this.farm.add(sheep);

        int actualOutput = this.farm.getCount();

        int expectedOutput = 2;

        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testRemoveMethodRemovesAnimal() {
        Animal cow = new Animal("Cow", 65);
        Animal sheep = new Animal("Sheep", 40);
        Animal hen = new Animal("Hen", 60);
        this.farm.add(cow);
        this.farm.add(sheep);
        this.farm.add(hen);

        Assert.assertTrue(this.farm.remove("Hen"));
        Assert.assertEquals(2, this.farm.getCount());
    }

    @Test
    public void testRemoveMethodDoesNotRemoveAnimal() {
        Animal cow = new Animal("Cow", 65);
        Animal sheep = new Animal("Sheep", 40);

        this.farm.add(cow);
        this.farm.add(sheep);

        Assert.assertFalse(this.farm.remove("Hen"));
        Assert.assertEquals(2, this.farm.getCount());
    }
}