package unitTesting.exercises.p03_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ListIteratorTest {
    private static final String[] NAMES = {"Pesho", "Gosho", "Sami", "Maria"};

    private ListIterator listIterator;

    @Before
    public void setUp() throws OperationNotSupportedException {
    this.listIterator = new ListIterator(NAMES);
    }

    //1. Testing whether the constructor throws an exception when initialized with null
    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowsException() throws OperationNotSupportedException {
        this.listIterator = new ListIterator(null);
    }

    //2. Testing whether hasNext method returns true
    @Test
    public void testHasNextReturnTrue() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator("Gosho", "Pesho");
        Assert.assertTrue(listIterator.hasNext());
    }

    //3. Testing whether hasNext method returns false
    @Test
    public void testHasNextReturnFalse() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator( "Pesho");
        Assert.assertFalse(listIterator.hasNext());
    }

    //4. Testing whether move method returns true
    @Test
    public void testMoveReturnTrue() {
        Assert.assertTrue(this.listIterator.move());
    }

    //5. Testing whether move method returns false
    @Test
    public void testMoveReturnFalse() throws OperationNotSupportedException {
        this.listIterator = new ListIterator("Gosho");
        Assert.assertFalse(listIterator.move());
    }

    //6. Testing whether print method throws Exception
    @Test (expected = IllegalStateException.class)
    public void testPrintThrowsException() throws OperationNotSupportedException {
        this.listIterator = new ListIterator();
        this.listIterator.print();
    }

    //7. testing whether print method prints correctly
    @Test
    public void testPrintMethodWorksCorrectly() {
        int testIndex = 0;
        while (this.listIterator.hasNext()) {
            Assert.assertEquals(NAMES[testIndex++], this.listIterator.print());
            this.listIterator.move();
        }
    }
}