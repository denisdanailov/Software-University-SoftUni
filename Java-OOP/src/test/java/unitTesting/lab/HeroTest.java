package unitTesting.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class HeroTest {

    private Hero hero;

    /*
    ...The classes below are obsolete because of Mockito...
    public class FakeAxe implements Weapon {

        @Override
        public int getAttackPoints() {
            return 0;
        }

        @Override
        public int getDurabilityPoints() {
            return 0;
        }

        @Override
        public void attack(Target target) {

        }
    }

    public class FakeTarget implements Target {

        @Override
        public int getHealth() {
            return 0;
        }

        @Override
        public void takeAttack(int attackPoints) {

        }

        @Override
        public int giveExperience() {
            return 100;
        }

        @Override
        public boolean isDead() {
            return true;
        }
    }
     */

    @Before
    public void setUp() {
        Weapon mockWeapon = Mockito.mock(Weapon.class);
        this.hero = new Hero("Mock Name", mockWeapon);
    }

    @Test
    public void testHeroGainsXpWhenTargetDies() {
        // Arrange
        Target mockTarget = Mockito.mock(Target.class);
        Mockito.when(mockTarget.isDead()).thenReturn(true);
        Mockito.when(mockTarget.giveExperience()).thenReturn(100);
        // Act
        this.hero.attack(mockTarget);
        // Assert
        Assert.assertEquals(100, this.hero.getExperience());
    }

    @Test
    public void testHeroDoesNotGainXpWhenTargetIsAlive() {
        // Arrange
        Target mockTarget = Mockito.mock(Target.class);
        Mockito.when(mockTarget.isDead()).thenReturn(false);
        Mockito.when(mockTarget.giveExperience()).thenReturn(100);
        // Act
        this.hero.attack(mockTarget);
        // Assert
        Assert.assertEquals(0, this.hero.getExperience());
    }
}