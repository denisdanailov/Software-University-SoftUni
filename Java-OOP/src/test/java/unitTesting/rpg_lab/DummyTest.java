package unitTesting.rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DummyTest {
    private static final int DUMMY_HEALTH = 100;
    private static final int DUMMY_EXPERIENCE = 100;
    private static final int ATTACK_POINTS = 50;

    private Dummy dummy;
    private Dummy deadDummy;

    @Before
    public void setUp() {
        dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
        deadDummy = new Dummy(0, DUMMY_EXPERIENCE);
    }

    @Test
    public void testDummyLosesHealthIfAttacked() {
        // Act
        dummy.takeAttack(ATTACK_POINTS);
        // Assert
        Assert.assertEquals(DUMMY_HEALTH - ATTACK_POINTS, dummy.getHealth());
    }

    @Test (expected = IllegalStateException.class)
    public void testDeadDummyThrowsExceptionIfAttacked() {
        // Act
        deadDummy.takeAttack(ATTACK_POINTS);
    }

    @Test
    public void testDeadDummyCanGiveExperience() {
        // Act
        int xpFromDeadDummy = deadDummy.giveExperience();
        // Assert
        Assert.assertEquals(DUMMY_EXPERIENCE, xpFromDeadDummy);
    }

    @Test (expected = IllegalStateException.class)
    public void testAliveDummyCanNotGiveExperience() {
        // Act
        dummy.giveExperience();
    }
}