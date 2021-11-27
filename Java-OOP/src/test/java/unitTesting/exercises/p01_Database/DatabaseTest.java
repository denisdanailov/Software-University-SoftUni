package unitTesting.exercises.p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {
    private static final Integer[] NUMBERS = {1, 2, 3, 4};
    private static final Integer Added_NUMBER = 6;

    private Database db;

    @Before
    public void setUp() throws OperationNotSupportedException {
        this.db = new Database(NUMBERS);
    }

    //1. Test db's constructor works correctly
    @Test
    public void testConstructorWorksCorrectly() throws OperationNotSupportedException {
        // Act
        Integer[] dbElements = this.db.getElements();
        // Assert
        Assert.assertArrayEquals(
                "The input integers don't match with db's elements.", NUMBERS, dbElements);
    }

    //2. Test if exception is thrown when constructor is given array with more than 16 elements
    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowsExceptionTooManyElements() throws OperationNotSupportedException {
        // Arrange
        Integer[] invalidArr = new Integer[17];
        this.db = new Database(invalidArr);
    }

    //3. Test if exception is thrown when constructor is given array with less than 1 element
    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowsExceptionTooFewElements() throws OperationNotSupportedException {
        // Arrange
        Integer[] invalidArr = new Integer[0];
        this.db = new Database(invalidArr);
    }

    //4. Test if add method works correctly
    @Test
    public void testAddMethodWorksCorrectly() throws OperationNotSupportedException {
        // Act
        this.db.add(Added_NUMBER);
        // Assert
        Integer[] dbElements = this.db.getElements();
        Integer dbLastElmnt = dbElements[this.db.getElements().length - 1];
        Assert.assertEquals("Last element in DB doesn't match the added integer.", Added_NUMBER, dbLastElmnt);
        Assert.assertEquals("DB's length hasn't increased post adding the integer.", NUMBERS.length + 1, dbElements.length);
    }

    //5. Test if exception is thrown when adding null
    @Test(expected = OperationNotSupportedException.class)
    public void testAddMethodThrowsExceptionWhenAddingNull() throws OperationNotSupportedException {
        // Act
        this.db.add(null);
    }

    //6. Test if removing an element works correctly
    @Test
    public void testRemoveMethodWorksCorrectly() throws OperationNotSupportedException {
        // Act
        this.db.remove();
        Integer expectedLastNum = NUMBERS[NUMBERS.length - 2];
        // Assert
        Integer actualLastNum = this.db.getElements()[this.db.getElements().length - 1];
        Assert.assertEquals("The last num in db wasn't removed correctly.", expectedLastNum, actualLastNum);
        Assert.assertEquals("The length of the db hasn't shrunken post removing element.", NUMBERS.length - 1, this.db.getElements().length);
    }

    //7. Test if going out of bounds triggers exception
    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveMethodThrowsException() throws OperationNotSupportedException {
        // Act
        int length = this.db.getElements().length;
        for (int i = 0; i < length; i++) {
            this.db.remove();
        }
        this.db.remove();
    }
}