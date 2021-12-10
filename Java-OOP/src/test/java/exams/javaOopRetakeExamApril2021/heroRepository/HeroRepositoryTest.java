package exams.javaOopRetakeExamApril2021.heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeroRepositoryTest {
    private HeroRepository repository;

    @Before
    public void setUp() {
        repository = new HeroRepository();
    }

    @Test(expected = NullPointerException.class)
    public void testCreateMethodThrowsExceptionGiveNull() {
        this.repository.create(null);
    }

    @Test
    public void testAddAndGetCountMethodWorksCorrectly() {
        Assert.assertEquals(0, this.repository.getCount());

        Hero hero1 = new Hero("Elf", 12);

        String actualOutput = this.repository.create(hero1);

        Assert.assertEquals(1, this.repository.getCount());

        String expectedOutput = "Successfully added hero Elf with level 12";
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddMethodThrowsExceptionExistingHero() {
        Hero hero1 = new Hero("Elf", 12);
        this.repository.create(hero1);
        this.repository.create(hero1);
    }

    @Test (expected = NullPointerException.class)
    public void testRemoveMethodThrowsExceptionGivenNull() {
        this.repository.remove(null);
    }

    @Test (expected = NullPointerException.class)
    public void testRemoveMethodThrowsExceptionGivenEmptyString() {
        this.repository.remove("   ");
    }

    @Test
    public void testRemoveMethodRemovesHero() {
        Hero hero1 = new Hero("Elf", 12);
        this.repository.create(hero1);
        Assert.assertEquals(1, this.repository.getCount());
        boolean actual = this.repository.remove("Elf");
        Assert.assertTrue(actual);
        Assert.assertEquals(0, this.repository.getCount());
    }

    @Test
    public void testRemoveMethodDoesNotRemoveHero() {
        Hero hero1 = new Hero("Elf", 12);
        this.repository.create(hero1);
        Assert.assertEquals(1, this.repository.getCount());
        boolean actual = this.repository.remove("Blood Elf");
        Assert.assertFalse(actual);
        Assert.assertEquals(1, this.repository.getCount());
    }

    @Test
    public void testGetHeroWithHighestLevelReturnsNull() {
        Assert.assertNull(this.repository.getHeroWithHighestLevel());
    }

    @Test
    public void testGetHeroWithHighestLevelReturnsHero() {
        Hero hero1 = new Hero("Elf", 12);
        Hero hero2 = new Hero("Blood Elf", 22);
        this.repository.create(hero1);
        this.repository.create(hero2);
        Assert.assertEquals(hero2, this.repository.getHeroWithHighestLevel());
    }

    @Test
    public void testGetHeroMethodReturnsHero() {
        Hero hero1 = new Hero("Elf", 12);
        this.repository.create(hero1);

        Assert.assertEquals(hero1, this.repository.getHero("Elf"));
    }

    @Test
    public void testGetHeroMethodReturnsNull() {
        Assert.assertNull(this.repository.getHero("Elf"));
    }

    @Test
    public void testGetHeroesWorksCorrectly() {
        Hero hero1 = new Hero("Elf", 12);
        Hero hero2 = new Hero("Blood Elf", 22);
        this.repository.create(hero1);
        this.repository.create(hero2);

        Assert.assertTrue(this.repository.getHeroes().contains(hero1));
        Assert.assertTrue(this.repository.getHeroes().contains(hero2));
        Assert.assertEquals(2, this.repository.getHeroes().size());
    }
}