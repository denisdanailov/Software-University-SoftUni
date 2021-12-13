package testDrivenDevelopment.lab;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;

public class InstockTest {
    private Instock instock;

    @Before
    public void before() {
        this.instock = new Instock();
    }

    @Test
    public void testAddMethodAndGetCountWorksCorrectly() {
        assertEquals(0, this.instock.getCount());

        Product product = new Product("Waffle", 2.50, 10);
        Product product1 = new Product("Water", 1.20, 12);
        this.instock.add(product);
        this.instock.add(product1);

        assertEquals(2, this.instock.getCount());
    }

    @Test
    public void testContainsMethodReturnsTrue() {
        Product product = new Product("Water", 1.20, 12);
        this.instock.add(product);

        assertTrue(this.instock.contains(product));
    }

    @Test
    public void testContainsMethodReturnsFalse() {
        Product product = new Product("Water", 1.20, 12);

        assertFalse(this.instock.contains(product));
    }

    @Test
    public void testChangeQuantityMethodWithExistingProduct() {
        Product product = new Product("Water", 1.20, 12);
        this.instock.add(product);

        this.instock.changeQuantity("Water", 6);

        int newQuantity = this.instock.findByLabel("Water").getQuantity();
        assertEquals(6, newQuantity);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeQuantityMethodsThrowsExceptionGivenNonExistingProduct() {
        Product product = new Product("Water", 1.20, 12);

        this.instock.changeQuantity("Water", 6);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindMethodThrowsExceptionGivenInvalidIndex() {
        Product product = new Product("Waffle", 2.50, 10);
        Product product1 = new Product("Water", 1.20, 12);
        this.instock.add(product);
        this.instock.add(product1);

        this.instock.find(6);
    }

    @Test
    public void testFindMethodWorksCorrectly() {
        Product product = new Product("Waffle", 2.50, 10);
        Product product1 = new Product("Water", 1.20, 12);
        Product product2 = new Product("Cola", 1.49, 5);
        this.instock.add(product);
        this.instock.add(product1);
        this.instock.add(product2);

        Product actualProduct = this.instock.find(1);

        assertEquals(product1, actualProduct);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindByLabelMethodThrowsException() {
        this.instock.findByLabel("Waffle");
    }

    @Test
    public void testFindFirstByAlphabeticalOrderMethodReturnsIterable() {
        Product product = new Product("Waffle", 2.50, 10);
        Product product1 = new Product("Water", 1.20, 12);
        Product product2 = new Product("Cola", 1.49, 5);
        this.instock.add(product);
        this.instock.add(product1);
        this.instock.add(product2);

        Collection<Product> expectedCollection = new ArrayList<>();
        expectedCollection.add(product2);
        expectedCollection.add(product);

        assertEquals(expectedCollection, this.instock.findFirstByAlphabeticalOrder(2));
        ;
    }

    @Test
    public void testFindFirstByAlphabeticalOrderMethodReturnsEmptyCollection() {
        Product product = new Product("Waffle", 2.50, 10);
        Product product1 = new Product("Water", 1.20, 12);
        Product product2 = new Product("Cola", 1.49, 5);
        this.instock.add(product);
        this.instock.add(product1);
        this.instock.add(product2);

        assertEquals(new ArrayList<>(), this.instock.findFirstByAlphabeticalOrder(5));
        ;
    }

    @Test
    public void testFindAllInRangeWorksCorrectly() {
        Product product = new Product("Waffle", 2.50, 10);
        Product product1 = new Product("Water", 1.20, 12);
        Product product2 = new Product("Cola", 1.49, 5);
        this.instock.add(product);
        this.instock.add(product1);
        this.instock.add(product2);

        Collection<Product> expectedCollection = new ArrayList<>();
        expectedCollection.add(product2);
        expectedCollection.add(product1);

        assertEquals(expectedCollection, this.instock.findAllInRange(1, 2));
    }

    @Test
    public void testFindAllByPriceWorksCorrectly() {
        Product product = new Product("Fanta", 1.60, 12);
        Product product1 = new Product("Waffle", 2.50, 10);
        Product product2 = new Product("Cola", 1.60, 5);
        this.instock.add(product);
        this.instock.add(product1);
        this.instock.add(product2);

        Collection<Product> expectedCollection = new ArrayList<>();
        expectedCollection.add(product);
        expectedCollection.add(product2);

        assertEquals(expectedCollection, this.instock.findAllByPrice(1.60));
    }

    @Test
    public void testFindMostExpensiveProductsWorksCorrectly() {
        Product product = new Product("Chocolate", 2.20, 12);
        Product product1 = new Product("Waffle", 2.50, 10);
        Product product2 = new Product("Cola", 1.60, 5);
        this.instock.add(product);
        this.instock.add(product1);
        this.instock.add(product2);

        Collection<Product> expectedCollection = new ArrayList<>();
        expectedCollection.add(product1);
        expectedCollection.add(product);

        assertEquals(expectedCollection, this.instock.findFirstMostExpensiveProducts(2));
    }

    @Test
    public void testFindMostExpensiveProductsReturnsEmptyCollection() {
        Product product = new Product("Chocolate", 2.20, 12);
        Product product1 = new Product("Waffle", 2.50, 10);
        Product product2 = new Product("Cola", 1.60, 5);
        this.instock.add(product);
        this.instock.add(product1);
        this.instock.add(product2);

        assertEquals(new ArrayList<>(), this.instock.findFirstMostExpensiveProducts(5));
    }

    @Test
    public void testFindAllBtQuantityWorksCorrectly() {
        Product product = new Product("Chocolate", 2.20, 3);
        Product product1 = new Product("Waffle", 2.50, 3);
        Product product2 = new Product("Cola", 1.60, 5);
        this.instock.add(product);
        this.instock.add(product1);
        this.instock.add(product2);

        Collection<Product> expectedCollection = new ArrayList<>();
        expectedCollection.add(product);
        expectedCollection.add(product1);

        assertEquals(expectedCollection, this.instock.findAllByQuantity(3));
    }

}