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
    public void testSetChocolate() {
        assertFalse(Inventory.setChocolate(-1));
        assertTrue(Inventory.setChocolate(1));
        assertTrue(Inventory.setChocolate(0));
    }

    @Test
    public void testSetCoffee() {
        assertFalse(Inventory.setCoffee(-1));
        assertTrue(Inventory.setCoffee(1));
        assertTrue(Inventory.setCoffee(0));
    }

    @Test
    public void testSetMilk() {
    	assertFalse(Inventory.setMilk(-1));
        assertTrue(Inventory.setMilk(1));
        assertTrue(Inventory.setMilk(0));
    }

    @Test
    public void testSetSugarPositive() {
    	assertFalse(Inventory.setSugar(-1));
        assertTrue(Inventory.setSugar(1));
        assertTrue(Inventory.setSugar(0));
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

