package edu.towson.cis.cosc442.project4.coffeemaker;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RecipeTest {

    private Recipe recipe;

    @Before
    public void setUp() {
        recipe = new Recipe();
        recipe.setName("Coffee");
        recipe.setPrice(50);
        recipe.setAmtCoffee(6);
        recipe.setAmtMilk(1);
        recipe.setAmtSugar(1);
        recipe.setAmtChocolate(0);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetAmtChocolate() {
        assertEquals(0, recipe.getAmtChocolate());
    }

    @Test
    public void testSetAmtChocolate() {
        recipe.setAmtChocolate(2);
        assertEquals(2, recipe.getAmtChocolate());

        // Test negative value
        recipe.setAmtChocolate(-1);
        assertEquals(0, recipe.getAmtChocolate());
    }

    @Test
    public void testGetAmtCoffee() {
        assertEquals(6, recipe.getAmtCoffee());
    }

    @Test
    public void testSetAmtCoffee() {
        recipe.setAmtCoffee(4);
        assertEquals(4, recipe.getAmtCoffee());

        // Test negative value
        recipe.setAmtCoffee(-1);
        assertEquals(0, recipe.getAmtCoffee());
    }

    @Test
    public void testGetAmtMilk() {
        assertEquals(1, recipe.getAmtMilk());
    }

    @Test
    public void testSetAmtMilk() {
        recipe.setAmtMilk(3);
        assertEquals(3, recipe.getAmtMilk());

        // Test negative value
        recipe.setAmtMilk(-1);
        assertEquals(0, recipe.getAmtMilk());
    }

    @Test
    public void testGetAmtSugar() {
        assertEquals(1, recipe.getAmtSugar());
    }

    @Test
    public void testSetAmtSugar() {
        recipe.setAmtSugar(2);
        assertEquals(2, recipe.getAmtSugar());

        // Test negative value
        recipe.setAmtSugar(-1);
        assertEquals(0, recipe.getAmtSugar());
    }

    @Test
    public void testGetName() {
        assertEquals("Coffee", recipe.getName());
    }

    @Test
    public void testSetName() {
        recipe.setName("Latte");
        assertEquals("Latte", recipe.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(50, recipe.getPrice());
    }

    @Test
    public void testSetPrice() {
        recipe.setPrice(75);
        assertEquals(75, recipe.getPrice());

        // Test negative value
        recipe.setPrice(-1);
        assertEquals(0, recipe.getPrice());
    }

    @Test
    public void testEquals() {
        Recipe r0 = new Recipe();
        r0.setName("Coffee");

        Recipe r2 = new Recipe();
        r2.setName("Latte");
        
        Recipe r3 = new Recipe();

        assertTrue(recipe.equals(r0));
        assertFalse(recipe.equals(r2));
        assertFalse(r3.equals(r2));
        assertFalse(r2.equals(r3));

    }

    @Test
    public void testToString() {
        assertEquals("Coffee", recipe.toString());
    }
}

