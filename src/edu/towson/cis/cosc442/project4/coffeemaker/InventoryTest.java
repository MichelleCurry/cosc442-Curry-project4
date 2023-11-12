package edu.towson.cis.cosc442.project4.coffeemaker;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InventoryTest {

    private Inventory inventory;

    @Before
    public void setUp() {
        inventory = new Inventory();
    }

    @Test
    public void testSetChocolatePositive() {
        Inventory.setChocolate(5);
        assertEquals(5, inventory.getChocolate());
    }

    @Test
    public void testSetChocolateNegative() {
        Inventory.setChocolate(-5);
        assertEquals(0, inventory.getChocolate());
    }

    @Test
    public void testSetCoffeePositive() {
        Inventory.setCoffee(10);
        assertEquals(10, inventory.getCoffee());
    }

    @Test
    public void testSetCoffeeNegative() {
        Inventory.setCoffee(-10);
        assertEquals(0, inventory.getCoffee());
    }

    @Test
    public void testSetMilkPositive() {
        Inventory.setMilk(8);
        assertEquals(8, inventory.getMilk());
    }

    @Test
    public void testSetMilkNegative() {
        Inventory.setMilk(-8);
        assertEquals(0, inventory.getMilk());
    }

    @Test
    public void testSetSugarPositive() {
        Inventory.setSugar(12);
        assertEquals(12, inventory.getSugar());
    }

    @Test
    public void testSetSugarNegative() {
        Inventory.setSugar(-12);
        assertEquals(0, inventory.getSugar());
    }

    @Test
    public void testEnoughIngredients() {
        Recipe r = new Recipe();
        r.setAmtCoffee(5);
        r.setAmtMilk(3);
        r.setAmtSugar(2);
        r.setAmtChocolate(1);

        assertTrue(inventory.enoughIngredients(r));
    }

    @Test
    public void testNotEnoughIngredients() {
        Recipe r = new Recipe();
        r.setAmtCoffee(20);
        r.setAmtMilk(20);
        r.setAmtSugar(20);
        r.setAmtChocolate(20);

        assertFalse(inventory.enoughIngredients(r));
    }

    @Test
    public void testToString() {
        String expectedString = "Coffee: 15\n" +
                "Milk: 15\n" +
                "Sugar: 15\n" +
                "Chocolate: 15\n";

        assertEquals(expectedString, inventory.toString());
    }
}

