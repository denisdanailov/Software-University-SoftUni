package unitTesting.exercises.p05_CustomLinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomLinkedListTest {
    private CustomLinkedList<Integer> customLinkedList;

    @Before
    public void compile() {
        this.customLinkedList = new CustomLinkedList();
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetMethodThrowsExceptionIndexOutOfBounds() {
        this.customLinkedList.get(-1);
    }

    @Test
    public void testGetMethodWorksCorrectly() {
        this.customLinkedList.add(101);
        this.customLinkedList.add(102);
        this.customLinkedList.add(103);
        Integer actualResult = this.customLinkedList.get(2);
        Assert.assertEquals(Integer.valueOf(103), actualResult);
    }

    @Test
    public void testAddMethodWithEmptyList() {
        this.customLinkedList.add(101);
        Assert.assertEquals(1, this.customLinkedList.getCount());
    }

    @Test
    public void testAddMethodWithExistingElementsInList() {
        this.customLinkedList.add(101);
        this.customLinkedList.add(102);
        Assert.assertEquals(2, this.customLinkedList.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetMethodThrowsExceptionInvalidIndex() {
        this.customLinkedList.set(-1, 101);
    }

    @Test
    public void testSetMethodWorksCorrectly() {
        // Arrange
        this.customLinkedList.add(101);
        this.customLinkedList.add(102);
        this.customLinkedList.add(103);
        // Act
        this.customLinkedList.set(2 ,104);
        // Assert
        Integer expectedResult = this.customLinkedList.get(2);
        Assert.assertEquals(Integer.valueOf(104), expectedResult);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRemoveAtMethodThrowsExceptionInvalidIndex() {
        this.customLinkedList.removeAt(-1);
    }

    @Test
    public void testRemoveAtMethodWorksCorrectly() {
        // Arrange
        this.customLinkedList.add(101);
        this.customLinkedList.add(102);
        this.customLinkedList.add(103);
        this.customLinkedList.add(104);
        // Act
        Integer actualResult = this.customLinkedList.removeAt(2);
        // Assert
        Assert.assertEquals(Integer.valueOf(103), actualResult);
    }

    @Test
    public void testRemoveMethodWithInvalidItem() {
        // Arrange
        this.customLinkedList.add(101);
        this.customLinkedList.add(102);
        this.customLinkedList.add(103);
        // Act
        int actualResult = this.customLinkedList.remove(104);
        // Assert
        Assert.assertEquals(-1, actualResult);
    }

    @Test
    public void testRemoveMethodWorksCorrectly() {
        // Arrange
        this.customLinkedList.add(101);
        this.customLinkedList.add(102);
        this.customLinkedList.add(103);
        // Act
        int actualResult = this.customLinkedList.remove(103);
        // Assert
        Assert.assertEquals(2, actualResult);
    }

    @Test
    public void testIndexOfMethodWithInvalidItem() {
        // Arrange
        this.customLinkedList.add(101);
        this.customLinkedList.add(102);
        this.customLinkedList.add(103);
        // Act
        int actualResult = this.customLinkedList.indexOf(104);
        // Assert
        Assert.assertEquals(-1, actualResult);
    }

    @Test
    public void testIndexOfMethodWorksCorrectly() {
        // Arrange
        this.customLinkedList.add(101);
        this.customLinkedList.add(102);
        this.customLinkedList.add(103);
        // Act
        int actualResult = this.customLinkedList.indexOf(102);
        // Assert
        Assert.assertEquals(1, actualResult);
    }

    @Test
    public void testContainsMethodWithInvalidItem() {
        // Arrange
        this.customLinkedList.add(101);
        this.customLinkedList.add(102);
        this.customLinkedList.add(103);
        // Act
        boolean actualResult = this.customLinkedList.contains(104);
        // Assert
        Assert.assertFalse(actualResult);
    }

    @Test
    public void testContainsMethodWorksCorrectly() {
        // Arrange
        this.customLinkedList.add(101);
        this.customLinkedList.add(102);
        this.customLinkedList.add(103);
        // Act
        boolean actualResult = this.customLinkedList.contains(103);
        // Assert
        Assert.assertTrue(actualResult);
    }
}