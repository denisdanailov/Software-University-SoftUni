package unitTesting.exercises.p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {
    private final static Person[] PEOPLE = {new Person(111, "Pesho"), new Person(113, "Teodor"), new Person(112, "Gosho"), new Person(114, "Mitko")};

    private Database db;

    @Before
    public void preSet() throws OperationNotSupportedException{
        this.db = new Database(PEOPLE);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testSetElementsThrowsExceptionForTooManyElements() throws OperationNotSupportedException{
        Person[] people = new Person[17];
        this.db = new Database(people);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testSetElementThrowsExceptionForTooFewElements() throws OperationNotSupportedException {
        Person[] people = new Person[0];
        this.db = new Database(people);
    }

    @Test  (expected = OperationNotSupportedException.class)
    public void testAddMethodThrowsExceptionWhenAddedNull() throws OperationNotSupportedException {
        this.db.add(null);
    }

    @Test
    public void testAddMethodWorksCorrectly() throws OperationNotSupportedException {
        this.db.add(new Person(117, "Ivan"));
        Assert.assertEquals(PEOPLE.length + 1, this.db.getElements().length);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testRemoveMethodThrowsException() throws OperationNotSupportedException {
        int length = this.db.getElements().length;
        for (int i = 0; i < length; i++) {
            this.db.remove();
        }
        this.db.remove();
    }

    @Test
    public void testRemoveMethodWorksCorrectly() throws OperationNotSupportedException {
        this.db.remove();
        Assert.assertEquals(PEOPLE.length - 1, this.db.getElements().length);
    }

    @Test
    public void testGetElementsMethodWorksCorrectly() throws OperationNotSupportedException {
        Assert.assertArrayEquals(PEOPLE, this.db.getElements());
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testFindByUsernameMethodThrowsExceptionWhenGivenNull() throws OperationNotSupportedException {
        this.db.findByUsername(null);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testFindByUsernameMethodThrowsExceptionWithTwoEqualUsernames() throws OperationNotSupportedException {
        this.db = new Database(new Person(111, "Pesho"), new Person(113, "Pesho"));
        this.db.findByUsername("Pesho");
    }

    @Test
    public void testFindByUsernameMethodWorksCorrectly() throws OperationNotSupportedException {
        Person person = new Person(111, "Pesho");
        this.db = new Database(person);
        Assert.assertEquals(person, this.db.findByUsername("Pesho"));

    }

    @Test (expected = OperationNotSupportedException.class)
    public void testFindByIdMethodThrowsExceptionWithTwoEqualIDs() throws OperationNotSupportedException {
        this.db = new Database(new Person(111, "Peter"), new Person(111, "George"));
        this.db.findById(111);
    }

    @Test
    public void testFindByIdMethodWorksCorrectly() throws OperationNotSupportedException {
        Person person = new Person(111, "Peter");
        this.db = new Database(person);
        Assert.assertEquals(person, this.db.findById(111));

    }
}