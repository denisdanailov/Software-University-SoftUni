package exams.javaOopExamApril2021.problem2.aquarium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AquariumTests {
    private final static String AQUARIUM_NAME = "Danger Zone";
    private final static int AQUARIUM_CAPACITY = 10;
    private final static String NON_EXISTING_FISH = "Dorry";

    private Aquarium aquarium;

    @Before
    public void setUp() {
        aquarium = new Aquarium(AQUARIUM_NAME, AQUARIUM_CAPACITY);

        Fish fish = new Fish("Nemo");
        Fish fish1 = new Fish("Blue");
        this.aquarium.add(fish);
        this.aquarium.add(fish1);
    }

    @Test (expected = NullPointerException.class)
    public void testSetNameMethodThrowsExceptionGivenNull() {
        this.aquarium = new Aquarium(null, AQUARIUM_CAPACITY);
    }

    @Test (expected = NullPointerException.class)
    public void testSetNameMethodThrowsExceptionGivenEmptyString() {
        this.aquarium = new Aquarium("   ", AQUARIUM_CAPACITY);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetCapacityThrowsExceptionLessThanZero() {
        this.aquarium = new Aquarium(AQUARIUM_NAME, -1);
    }

    @Test
    public void testGetNameWorksCorrectly() {
        Assert.assertEquals(AQUARIUM_NAME, this.aquarium.getName());
    }

    @Test
    public void testGetCapacityWorksCorrectly() {
        Assert.assertEquals(AQUARIUM_CAPACITY, this.aquarium.getCapacity());
    }

    @Test
    public void testAddMethodAndGetCountWorkCorrectly() {
        this.aquarium = new Aquarium(AQUARIUM_NAME, AQUARIUM_CAPACITY);

        Assert.assertEquals(0, this.aquarium.getCount());

        Fish fish = new Fish("Nemo");
        Fish fish1 = new Fish("Blue");
        Fish fish2 = new Fish("White");
        this.aquarium.add(fish);
        this.aquarium.add(fish1);
        this.aquarium.add(fish2);

        Assert.assertEquals(3, this.aquarium.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddMethodThrowsExceptionAquariumIsFull() {
        this.aquarium = new Aquarium(AQUARIUM_NAME, 3);

        Fish fish = new Fish("Nemo");
        Fish fish1 = new Fish("Black");
        Fish fish2 = new Fish("White");
        Fish fish3 = new Fish("Blue");
        this.aquarium.add(fish);
        this.aquarium.add(fish1);
        this.aquarium.add(fish2);
        this.aquarium.add(fish3);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRemoveMethodThrowsExceptionInvalidFish() {

        this.aquarium.remove(NON_EXISTING_FISH);
    }

    @Test
    public void testRemoveMethodWorksCorrectly() {
        this.aquarium = new Aquarium(AQUARIUM_NAME, AQUARIUM_CAPACITY);

        Assert.assertEquals(0, this.aquarium.getCount());

        Fish fish = new Fish("Nemo");
        Fish fish1 = new Fish("Black");
        Fish fish2 = new Fish("White");
        this.aquarium.add(fish);
        this.aquarium.add(fish1);
        this.aquarium.add(fish2);

        Assert.assertEquals(3, this.aquarium.getCount());

        this.aquarium.remove("Black");
        this.aquarium.remove("White");

        Assert.assertEquals(1, this.aquarium.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSellFishMethodInvalidFish() {

        this.aquarium.sellFish(NON_EXISTING_FISH);
    }

    @Test
    public void testSellFishMethodWorksCorrectly() {
        Fish fish1 = new Fish("Blue");

        Fish soldFish = this.aquarium.sellFish(fish1.getName());

        Assert.assertFalse(soldFish.isAvailable());
    }

    @Test
    public void testReportMethodWorksCorrectly() {
        String fishNames = String.join(", ","Nemo", "Blue");
        String expectedOutput = String.format("Fish available at %s: %s", AQUARIUM_NAME, fishNames);

        Assert.assertEquals(expectedOutput, this.aquarium.report());
    }
}

