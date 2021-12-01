package testDrivenDevelopment.exercises;

import interfacesAndAbstraction.exercises.collectionHierarchy.Collection;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class ChainblockImplTest {
    private Chainblock chainblock;

    @Before
    public void setUp() {
        this.chainblock = new ChainblockImpl();
    }

    private void addTransactionsToChainblock(Transaction... transactions) {
        for (Transaction transaction : transactions) {
            this.chainblock.add(transaction);
        }
    }

    private <T> List<T> addElementsToList(T... elements) {
        List<T> list = new ArrayList<>();
        for (T element : elements) {
            list.add(element);
        }
        return list;
    }

    @Test
    public void testContainsMethodByTransactionReturnsTrueAndAddMethodWorksCorrectly() {
        Transaction transaction = new TransactionImpl(0, TransactionStatus.SUCCESSFUL, "Anne", "Donald", 7.20);
        this.chainblock.add(transaction);
        boolean actualResult = this.chainblock.contains(transaction);
        assertTrue(actualResult);
    }

    @Test
    public void testContainsMethodByTransactionReturnsFalse() {
        Transaction transaction = new TransactionImpl(0, TransactionStatus.SUCCESSFUL, "Anne", "Donald", 7.20);
        // Not adding the transaction to chainblock
        boolean actualResult = this.chainblock.contains(transaction);
        assertFalse(actualResult);
    }

    @Test
    public void testContainsMethodByIdReturnsTrue() {
        Transaction transaction = new TransactionImpl(0, TransactionStatus.SUCCESSFUL, "Anne", "Donald", 7.20);
        this.chainblock.add(transaction);
        boolean actualResult = this.chainblock.contains(transaction.getId());
        assertTrue(actualResult);
    }

    @Test
    public void testContainsMethodByIdReturnsFalse() {
        Transaction transaction = new TransactionImpl(0, TransactionStatus.SUCCESSFUL, "Anne", "Donald", 7.20);
        // Not adding the transaction to chainblock
        boolean actualResult = this.chainblock.contains(transaction);
        assertFalse(actualResult);
    }

    @Test
    public void testGetCountMethodWorksCorrectly() {
        Transaction transaction = new TransactionImpl(0, TransactionStatus.SUCCESSFUL, "Anne", "Donald", 7.20);
        Transaction transaction1 = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Brie", "Arnold", 10.20);
        addTransactionsToChainblock(transaction, transaction1);
        int actualResult = this.chainblock.getCount();
        assertEquals(2, actualResult);
    }


    @Test
    public void testGetByIdMethodWorksCorrectly() {
        Transaction transaction = new TransactionImpl(0, TransactionStatus.SUCCESSFUL, "Anne", "Donald", 7.20);
        this.chainblock.add(transaction);
        assertEquals(transaction, this.chainblock.getById(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByIdMethodThrowsException() {
        this.chainblock.getById(0);
    }

    @Test
    public void testAddMethodDoesNotAddElementGivenDuplicateIds() {
        Transaction transaction = new TransactionImpl(0, TransactionStatus.SUCCESSFUL, "Anne", "Donald", 7.20);
        Transaction transaction1 = new TransactionImpl(0, TransactionStatus.SUCCESSFUL, "Brie", "Arnold", 10.20);
        addTransactionsToChainblock(transaction, transaction1);
        int actualResult = this.chainblock.getCount();
        assertEquals(1, actualResult);
        assertEquals("Anne", this.chainblock.getById(0).getFrom());
        assertEquals("Donald", this.chainblock.getById(0).getTo());
        assertEquals(7.20, this.chainblock.getById(0).getAmount(), 0);
        assertEquals(TransactionStatus.SUCCESSFUL, this.chainblock.getById(0).getStatus());
    }

    @Test
    public void testChangeTransactionStatusMethodWorksCorrectly() {
        Transaction transaction = new TransactionImpl(0, TransactionStatus.SUCCESSFUL, "Anne", "Donald", 7.20);
        this.chainblock.add(transaction);
        this.chainblock.changeTransactionStatus(0, TransactionStatus.FAILED);
        assertEquals(TransactionStatus.FAILED, this.chainblock.getById(0).getStatus());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeTransactionStatusMethodThrowsException() {
        Transaction transaction = new TransactionImpl(1, TransactionStatus.UNAUTHORIZED, "John", "Sam", 7.20);
        this.chainblock.changeTransactionStatus(0, TransactionStatus.FAILED);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveTransactionByIdMethodThrowsException() {
        Transaction transaction = new TransactionImpl(1, TransactionStatus.UNAUTHORIZED, "John", "Sam", 7.20);
        this.chainblock.removeTransactionById(0);
    }

    @Test
    public void testRemoveTransactionByIdMethodWorksCorrectly() {
        // Arrange
        Transaction transaction = new TransactionImpl(0, TransactionStatus.SUCCESSFUL, "Anne", "Donald", 7.20);
        Transaction transaction1 = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Brie", "Arnold", 10.20);
        // Act
        addTransactionsToChainblock(transaction, transaction1);
        // Assert
        this.chainblock.removeTransactionById(0);
        int actualResult = this.chainblock.getCount();
        assertEquals(1, actualResult);
        // Check if removes the right transaction
        assertEquals(10.20, this.chainblock.getById(1).getAmount(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByTransactionStatusMethodThrowsException() {
        Transaction transaction = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Brie", "Arnold", 10.20);
        this.chainblock.add(transaction);
        this.chainblock.getByTransactionStatus(TransactionStatus.ABORTED);
    }

    @Test
    public void testGetByTransactionStatusWorksCorrectly() {
        // Arrange
        Transaction transaction = new TransactionImpl(0, TransactionStatus.ABORTED, "Anne", "Donald", 7.20);
        Transaction transaction1 = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Brie", "Arnold", 10.20);
        Transaction transaction2 = new TransactionImpl(2, TransactionStatus.ABORTED, "Jake", "Hillary", 15.10);
        Transaction transaction3 = new TransactionImpl(3, TransactionStatus.ABORTED, "Jhon", "Danny", 19.60);
        addTransactionsToChainblock(transaction, transaction1, transaction2, transaction3);
        // Act
        Iterable<Transaction> actualTransactions = this.chainblock.getByTransactionStatus(TransactionStatus.ABORTED);
        // Assert
        List<Transaction> expectedTransactions = addElementsToList(transaction, transaction2, transaction3);

        expectedTransactions.sort((a, b) -> Double.compare(b.getAmount(), a.getAmount()));

        assertEquals(expectedTransactions, actualTransactions);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAllSendersWithTransactionStatusMethodThrowsException() {
        Transaction transaction = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Brie", "Arnold", 10.20);
        this.chainblock.add(transaction);
        this.chainblock.getAllSendersWithTransactionStatus(TransactionStatus.UNAUTHORIZED);
    }

    @Test
    public void testGetAllSendersWithTransactionStatusMethodWorksCorrectly() {
        // Arrange
        Transaction transaction = new TransactionImpl(0, TransactionStatus.ABORTED, "Anne", "Donald", 7.20);
        Transaction transaction1 = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Brie", "Arnold", 10.20);
        Transaction transaction2 = new TransactionImpl(2, TransactionStatus.ABORTED, "Jake", "Hillary", 15.10);
        Transaction transaction3 = new TransactionImpl(3, TransactionStatus.ABORTED, "Jhon", "Danny", 19.60);
        addTransactionsToChainblock(transaction, transaction1, transaction2, transaction3);
        // Act
        Iterable<String> actualSenders = this.chainblock.getAllSendersWithTransactionStatus(TransactionStatus.ABORTED);
        // Assert
        List<String> expectedSenders = addElementsToList(transaction, transaction2, transaction3)
                .stream()
                .sorted((a, b) -> Double.compare(b.getAmount(), a.getAmount()))
                .map(Transaction::getFrom)
                .collect(Collectors.toList());

        assertEquals(expectedSenders, actualSenders);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAllReceiversWithTransactionStatusMethodThrowsException() {
        Transaction transaction = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Brie", "Arnold", 10.20);
        this.chainblock.add(transaction);
        this.chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.UNAUTHORIZED);
    }

    @Test
    public void testGetAllReceiversWithTransactionStatusMethodWorksCorrectly() {
        // Arrange
        Transaction transaction = new TransactionImpl(0, TransactionStatus.ABORTED, "Anne", "Donald", 7.20);
        Transaction transaction1 = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Brie", "Arnold", 10.20);
        Transaction transaction2 = new TransactionImpl(2, TransactionStatus.ABORTED, "Jake", "Hillary", 15.10);
        Transaction transaction3 = new TransactionImpl(3, TransactionStatus.ABORTED, "Jhon", "Danny", 19.60);
        addTransactionsToChainblock(transaction, transaction1, transaction2, transaction3);
        // Act
        Iterable<String> actualReceivers = this.chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.ABORTED);
        // Assert
        List<String> expectedReceivers = addElementsToList(transaction, transaction2, transaction3)
                .stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .map(Transaction::getTo)
                .collect(Collectors.toList());

        assertEquals(expectedReceivers, actualReceivers);
    }

    @Test
    public void testGetAllOrderedByAmountDescendingThenById() {
        // Arrange
        Transaction transaction = new TransactionImpl(0, TransactionStatus.ABORTED, "Anne", "Donald", 11.50);
        Transaction transaction1 = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Brie", "Arnold", 10.20);
        Transaction transaction2 = new TransactionImpl(2, TransactionStatus.ABORTED, "Jake", "Hillary", 15.10);
        Transaction transaction3 = new TransactionImpl(3, TransactionStatus.ABORTED, "Jhon", "Danny", 11.50);
        addTransactionsToChainblock(transaction, transaction1, transaction2, transaction3);
        // Act
        Iterable<Transaction> actualTransactions = this.chainblock.getAllOrderedByAmountDescendingThenById();
        // Assert
        List<Transaction> expectedTransactions = addElementsToList(transaction, transaction1, transaction2, transaction3);

        expectedTransactions.sort(Comparator.comparing(Transaction::getAmount).reversed()
                .thenComparing(Transaction::getId));

        assertEquals(expectedTransactions, actualTransactions);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetBySenderOrderedByAmountDescendingMethodThrowsException() {
        Transaction transaction = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Brie", "Arnold", 10.20);
        Transaction transaction1 = new TransactionImpl(1, TransactionStatus.ABORTED, "Jake", "Hillary", 15.10);
        addTransactionsToChainblock(transaction, transaction1);
        this.chainblock.getBySenderOrderedByAmountDescending("George");
    }

    @Test
    public void testGetBySenderOrderedByAmountDescendingMethodWorksCorrectly() {
        // Arrange
        Transaction transaction = new TransactionImpl(0, TransactionStatus.ABORTED, "Jhon", "Donald", 7.20);
        Transaction transaction1 = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Brie", "Arnold", 10.20);
        Transaction transaction2 = new TransactionImpl(2, TransactionStatus.ABORTED, "Jake", "Hillary", 15.10);
        Transaction transaction3 = new TransactionImpl(3, TransactionStatus.ABORTED, "Jhon", "Danny", 19.60);
        addTransactionsToChainblock(transaction, transaction1, transaction2, transaction3);
        // Act
        Iterable<Transaction> actualTransactions = this.chainblock.getBySenderOrderedByAmountDescending("Jhon");
        // Assert
        List<Transaction> expectedTransactions = addElementsToList(transaction, transaction3);

        expectedTransactions
                .sort(Comparator.comparing(Transaction::getAmount).reversed());

        assertEquals(expectedTransactions, actualTransactions);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByReceiverOrderedByAmountThenByIdMethodThrowsException() {
        Transaction transaction = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Brie", "Arnold", 10.20);
        Transaction transaction1 = new TransactionImpl(1, TransactionStatus.ABORTED, "Jake", "Hillary", 15.10);
        addTransactionsToChainblock(transaction, transaction1);
        this.chainblock.getByReceiverOrderedByAmountThenById("James");
    }

    @Test
    public void testGetByReceiverOrderedByAmountThenByIdMethodWorksCorrectly() {
        // Arrange
        Transaction transaction = new TransactionImpl(0, TransactionStatus.ABORTED, "Jhon", "Donald", 7.20);
        Transaction transaction1 = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Brie", "James", 9.99);
        Transaction transaction2 = new TransactionImpl(2, TransactionStatus.ABORTED, "Jake", "James", 15.10);
        Transaction transaction3 = new TransactionImpl(3, TransactionStatus.ABORTED, "Anne", "James", 9.99);
        Transaction transaction4 = new TransactionImpl(4, TransactionStatus.ABORTED, "Jhon", "Danny", 19.60);
        addTransactionsToChainblock(transaction, transaction1, transaction2, transaction3, transaction4);
        // Act
        Iterable<Transaction> actualTransactions = this.chainblock.getByReceiverOrderedByAmountThenById("James");
        // Assert
        List<Transaction> expectedTransactions = addElementsToList(transaction1, transaction2, transaction3);

        expectedTransactions.sort(Comparator.comparing(Transaction::getAmount).reversed()
                .thenComparing(Transaction::getId));

        assertEquals(expectedTransactions, actualTransactions);
    }

    @Test
    public void testGetByTransactionStatusAndMaximumAmountReturnsEmptyCollection() {
        // Arrange
        Transaction transaction = new TransactionImpl(0, TransactionStatus.FAILED, "Jhon", "Sam", 7.20);
        Transaction transaction1 = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Jhon", "Sam", 21.50);
        addTransactionsToChainblock(transaction, transaction1);
        // Act
        Iterable<Transaction> actualCollection = this.chainblock.getByTransactionStatusAndMaximumAmount(TransactionStatus.SUCCESSFUL, 20.0);
        // Assert
        List<Transaction> expectedCollection = new ArrayList<>();
        assertEquals(expectedCollection, actualCollection);
    }

    @Test
    public void testGetByTransactionStatusAndMaximumAmountWorksCorrectly() {
        // Arrange
        Transaction transaction = new TransactionImpl(0, TransactionStatus.FAILED, "Jhon", "Sam", 7.20);
        Transaction transaction1 = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Jhon", "Sam", 21.50);
        Transaction transaction2 = new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Marry", "Anne", 10.40);
        Transaction transaction3 = new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "Niko", "Sam", 20.0);
        addTransactionsToChainblock(transaction, transaction1, transaction2, transaction3);
        // Act
        Iterable<Transaction> actualCollection = this.chainblock.getByTransactionStatusAndMaximumAmount(TransactionStatus.SUCCESSFUL, 20.0);
        // Assert
        List<Transaction> expectedCollection = addElementsToList(transaction2, transaction3);

        expectedCollection.sort(Comparator.comparing(Transaction::getAmount).reversed());

        assertEquals(expectedCollection, actualCollection);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetBySenderAndMinimumAmountDescendingThrowsException() {
        Transaction transaction = new TransactionImpl(0, TransactionStatus.SUCCESSFUL, "Marry", "Anne", 10.40);
        Transaction transaction1 = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "John", "Anne", 25.20);
        addTransactionsToChainblock(transaction, transaction1);

        this.chainblock.getBySenderAndMinimumAmountDescending("Marry", 20.0);
    }

    @Test
    public void testGetBySenderAndMinimumAmountDescendingWorksCorrectly() {
        Transaction transaction = new TransactionImpl(0, TransactionStatus.SUCCESSFUL, "Marry", "Anne", 10.40);
        Transaction transaction1 = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "John", "Anne", 20.00);
        Transaction transaction2 = new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Marry", "Sam", 27.50);
        Transaction transaction3 = new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "Marry", "Kevin", 20.60);
        addTransactionsToChainblock(transaction, transaction1, transaction2, transaction3);

        Iterable<Transaction> actualSenders = this.chainblock.getBySenderAndMinimumAmountDescending("Marry", 20.0);

        List<Transaction> expectedSenders = addElementsToList(transaction2, transaction3);

        expectedSenders.sort(Comparator.comparing(Transaction::getAmount).reversed());

        assertEquals(expectedSenders, actualSenders);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetByReceiverAndAmountRangeThrowsException() {
        Transaction transaction = new TransactionImpl(0, TransactionStatus.SUCCESSFUL, "Marry", "Sam", 10.40);
        Transaction transaction1 = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "John", "Kevin", 19.80);
        Transaction transaction2 = new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "John", "Anne", 25.10);
        addTransactionsToChainblock(transaction, transaction1, transaction2);

        this.chainblock.getByReceiverAndAmountRange("Anne", 10.0, 25.0);
    }

    @Test
    public void testGetByReceiverAndAmountRangeWorksCorrectly() {
        Transaction transaction = new TransactionImpl(0, TransactionStatus.SUCCESSFUL, "Marry", "Sam", 10.40);
        Transaction transaction1 = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "John", "Kevin", 19.80);
        Transaction transaction2 = new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "John", "Anne", 25.10);
        Transaction transaction3 = new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "Sam", "Anne", 10.0);
        Transaction transaction4 = new TransactionImpl(4, TransactionStatus.SUCCESSFUL, "Kevin", "Anne", 24.99);
        Transaction transaction5 = new TransactionImpl(5, TransactionStatus.SUCCESSFUL, "John", "Anne", 10.0);
        addTransactionsToChainblock(transaction, transaction1, transaction2, transaction3, transaction4, transaction5);

        Iterable<Transaction> actualReceivers = this.chainblock.getByReceiverAndAmountRange("Anne", 10.0, 25.0);

        List<Transaction> expectedReceivers = addElementsToList(transaction3, transaction4, transaction5);

        expectedReceivers.sort(Comparator.comparing(Transaction::getAmount).reversed()
                .thenComparing(Transaction::getId));

        assertEquals(expectedReceivers, actualReceivers);
    }

    @Test
    public void testGetAllInAmountRangeReturnsEmptyCollection() {
        Transaction transaction = new TransactionImpl(0, TransactionStatus.SUCCESSFUL, "Marry", "Sam", 9.99);
        Transaction transaction1 = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "John", "Kevin", 27.80);
        addTransactionsToChainblock(transaction, transaction1);

        Iterable<Transaction> actualTransactions = this.chainblock.getAllInAmountRange(10.0, 25.0);

        List<Transaction> expectedTransactions = new ArrayList<>();

        assertEquals(expectedTransactions, actualTransactions);
    }

    @Test
    public void testGetAllInAmountRangeWorksCorrectly() {
        Transaction transaction = new TransactionImpl(0, TransactionStatus.SUCCESSFUL, "Marry", "Sam", 10.00);
        Transaction transaction1 = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "John", "Kevin", 19.80);
        Transaction transaction2 = new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "John", "Anne", 27.80);
        Transaction transaction3 = new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "Sam", "Anne", 9.99);
        Transaction transaction4 = new TransactionImpl(4, TransactionStatus.SUCCESSFUL, "Kevin", "Anne", 25.00);
        addTransactionsToChainblock(transaction, transaction1, transaction2, transaction3, transaction4);

        Iterable<Transaction> actualTransactions = this.chainblock.getAllInAmountRange(10.0, 25.0);

        List<Transaction> expectedTransactions = addElementsToList(transaction, transaction1, transaction4);

        assertEquals(expectedTransactions, actualTransactions);
    }
}