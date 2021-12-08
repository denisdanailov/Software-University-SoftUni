package exams.javaOopExamAugust2021.shopAndGoods;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ShopTest {
    private Shop shop;

    @Before
    public void setUp() {
        this.shop = new Shop();
    }

    @Test
    public void testAddGoodsWorksCorrectly() throws OperationNotSupportedException, IllegalArgumentException{
        String goodsCode = "11234";
        Goods good = new Goods("Waffle", goodsCode);
        String actualOutput = shop.addGoods("Shelves1", good);
        String expectedOutput = String.format("Goods: %s is placed successfully!", goodsCode);
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddGoodsThrowsExceptionShelfTaken() throws OperationNotSupportedException, IllegalArgumentException{
        Goods good = new Goods("Waffle", "12334");
        shop.addGoods("Shelves1", good);

        Goods dummyGood = new Goods("Water", "12233");
        shop.addGoods("Shelves1", dummyGood);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testAddGoodsThrowsExceptionGoodAlreadyInShelf() throws OperationNotSupportedException, IllegalArgumentException {
        Goods good = new Goods("Waffle", "12334");
        shop.addGoods("Shelves1", good);

        shop.addGoods("Shelves5", good);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddGoodsThrowsExceptionNoSuchShelf() throws OperationNotSupportedException {
        Goods good = new Goods("Waffle", "11234");
        shop.addGoods("Shelves13", good);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRemoveGoodsThrowsExceptionShelfDoesNotExist() {
        shop.removeGoods("Shelves13", null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRemoveGoodsThrowsExceptionGoodDoesNotExistInShelf() {
        Goods good = new Goods("Waffle", "11234");
        shop.removeGoods("Shelves11", good);
    }

    @Test
    public void testRemoveGoodsReturnsCorrectMessage() throws OperationNotSupportedException, IllegalArgumentException{
        String goodsCode = "11234";
        Goods good = new Goods("Waffle", goodsCode);
        shop.addGoods("Shelves12", good);

        String actualOutput = shop.removeGoods("Shelves12", good);

        String expectedOutput = String.format("Goods: %s is removed successfully!", goodsCode);

        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testRemoveReplacesGoodWithNull() throws OperationNotSupportedException, IllegalArgumentException {
        Goods good = new Goods("Waffle", "12345");
        shop.addGoods("Shelves12", good);

        shop.removeGoods("Shelves12", good);

        Goods emptyShelf = shop.getShelves().get("Shelves12");

        Assert.assertNull(emptyShelf);
    }

    @Test
    public void testGetShelvesWorksCorrectly() {
        Map<String, Goods> dummyMap = new LinkedHashMap<>();
        dummyMap.put("Shelves1", null);
        dummyMap.put("Shelves2", null);
        dummyMap.put("Shelves3", null);
        dummyMap.put("Shelves4", null);
        dummyMap.put("Shelves5", null);
        dummyMap.put("Shelves6", null);
        dummyMap.put("Shelves7", null);
        dummyMap.put("Shelves8", null);
        dummyMap.put("Shelves9", null);
        dummyMap.put("Shelves10", null);
        dummyMap.put("Shelves11", null);
        dummyMap.put("Shelves12", null);

        Assert.assertEquals(dummyMap, shop.getShelves());
    }
}