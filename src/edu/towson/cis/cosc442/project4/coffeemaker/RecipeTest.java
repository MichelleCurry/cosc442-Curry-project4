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
        assertFalse(recipe.setAmtChocolate(-1));
        assertTrue(recipe.setAmtChocolate(1));
        assertTrue(recipe.setAmtChocolate(0));
    }

    @Test
    public void testGetAmtCoffee() {
        assertEquals(6, recipe.getAmtCoffee());
    }

    @Test
    public void testSetAmtCoffee() {
        assertFalse(recipe.setAmtCoffee(-1));
        assertTrue(recipe.setAmtCoffee(1));
        assertTrue(recipe.setAmtCoffee(0));
    }

    @Test
    public void testGetAmtMilk() {
        assertEquals(1, recipe.getAmtMilk());
    }

    @Test
    public void testSetAmtMilk() {
        assertFalse(recipe.setAmtMilk(-1));
        assertTrue(recipe.setAmtMilk(1));
        assertTrue(recipe.setAmtMilk(0));
    }

    @Test
    public void testGetAmtSugar() {
        assertEquals(1, recipe.getAmtSugar());
    }

    @Test
    public void testSetAmtSugar() {
        assertFalse(recipe.setAmtSugar(-1));
        assertTrue(recipe.setAmtSugar(1));
        assertTrue(recipe.setAmtSugar(0));
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

