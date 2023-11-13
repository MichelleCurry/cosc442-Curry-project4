package edu.towson.cis.cosc442.project4.coffeemaker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class CoffeeMakerTest extends TestCase {
    private CoffeeMaker cm;
    private Inventory i;
    private Recipe r1;
    
    @Before
    public void setUp() {
        cm = new CoffeeMaker();
        i = cm.checkInventory();

        r1 = new Recipe();
        r1.setName("Coffee");
        r1.setPrice(50);
        r1.setAmtCoffee(6);
        r1.setAmtMilk(1);
        r1.setAmtSugar(1);
        r1.setAmtChocolate(0);
    }
    
	@After
	public void tearDown() throws Exception {
	}

	@Test
    public void testAddRecipe1() {
        assertTrue(cm.addRecipe(r1));
    }

	@Test
	public void testAddRecipe2() {
        // Add a new recipe
        cm.addRecipe(r1);
        assertFalse(cm.addRecipe(r1));
    }	
	@Test
	public void testAddRecipe3() {
        // Add a new recipe
        cm.addRecipe(r1);
        
        r1 = new Recipe();
        r1.setName("Latte");
        cm.addRecipe(r1);

        r1 = new Recipe();
        r1.setName("Frappachino");
        cm.addRecipe(r1);

        r1 = new Recipe();
        r1.setName("Americano");
        cm.addRecipe(r1);

        assertFalse(cm.addRecipe(r1));
    }

	@Test
	public void testDeleteRecipe1() {
        cm.addRecipe(r1);
        assertTrue(cm.deleteRecipe(r1));
    }
	
	@Test
	public void testDeleteRecipe2() {
        // Try to delete a non-existing recipe
        Recipe nonExistingRecipe = new Recipe();
        nonExistingRecipe.setName("Nonexistent Recipe");
        assertFalse(cm.deleteRecipe(nonExistingRecipe));
    }

	@Test
	public void testEditRecipe1() {
        cm.addRecipe(r1);
        Recipe newRecipe = new Recipe();
        newRecipe = r1;
        newRecipe.setAmtSugar(2);
        assertTrue(cm.editRecipe(r1, newRecipe));
    }
	
	@Test
	public void testEditRecipe2() {
        // Edit a recipe that doesn't exist
        Recipe nonExistingRecipe = new Recipe();
        nonExistingRecipe.setName("Nonexistent Recipe");
        Recipe newRecipe = new Recipe();
        newRecipe.setName("Cappuccino");
        newRecipe.setAmtCoffee(5);
        newRecipe.setAmtMilk(2);
        newRecipe.setAmtSugar(1);
        newRecipe.setAmtChocolate(1);

        assertFalse(cm.editRecipe(nonExistingRecipe, newRecipe));
    }
	
	@Test
	public void testEditRecipe3() {
        assertFalse(cm.editRecipe(r1, r1));
    }

	@Test
	public void testAddInventory_InvalidAmounts() {
	    // Try to add inventory with negative coffee amount
	    assertFalse(cm.addInventory(-1, -1, -1, -1));
	}

	@Test
	public void testAddInventory_ValidAmounts() {
	    // Add inventory with valid amounts
	    assertTrue(cm.addInventory(1, 1, 1, 1));
	    assertTrue(cm.addInventory(0, 0, 0, 0));
	    assertTrue(cm.addInventory(10, 5, 2, 0));
	}
	
	@Test
	public void testAddInventory_checkAmt() {
	    // Add inventory with valid amounts
		int add = 1;
		int coffee = i.getCoffee();
		int milk = i.getMilk();
		int sugar = i.getSugar();
		int chocolate = i.getChocolate();
		cm.addInventory(add, add, add, add);

	    assertEquals(coffee+add, i.getCoffee());
	    assertEquals(milk+add, i.getMilk());
	    assertEquals(sugar+add, i.getSugar());
	    assertEquals(chocolate+add, i.getChocolate());
	}

	@Test
	public void testMakeCoffee() {
        // Attempt to make coffee with insufficient funds
        Recipe expensiveRecipe = new Recipe();
        expensiveRecipe.setName("Expensive Coffee");
        expensiveRecipe.setPrice(100);

        int change = cm.makeCoffee(expensiveRecipe, 50);
        assertEquals(50, change);

        // Make coffee successfully
        Recipe affordableRecipe = new Recipe();
        affordableRecipe.setName("Affordable Coffee");
        affordableRecipe.setPrice(50);
        cm.addRecipe(affordableRecipe);

        change = cm.makeCoffee(affordableRecipe, 75);
        assertEquals(25, change);
        
        //Not enough ingredients
        affordableRecipe.setAmtMilk(20);
        change = cm.makeCoffee(affordableRecipe, 75);
        assertEquals(75, change);
    }
    
	@Test
	public void testGetRecipes() {
        // Ensure initially there are no recipes
		Recipe[] recipes = cm.getRecipes();
	    for (int i = 0; i < recipes.length; i++) {
	    	assertNull(recipes[i].getName());
	    }
	    
        // Add a recipe and check if the array is updated
        cm.addRecipe(r1);
        recipes = cm.getRecipes();
        
        assertEquals("Coffee", recipes[3].getName());
        for (int i = 2; i >= recipes.length; i--) {
	    	assertNull(recipes[i].getName());
	    }
    }

	@Test
	public void testGetRecipeForName() {
        // Case 1: Recipe with the given name exists
        Recipe r1 = new Recipe();
        r1.setName("Coffee");
        cm.addRecipe(r1);

        Recipe result1 = cm.getRecipeForName("Coffee");
        assertNotNull(result1);
        assertEquals("Coffee", result1.getName());

        // Case 2: Recipe with the given name does not exist
        Recipe result2 = cm.getRecipeForName("Tea");
        assertNotNull(result2);
        // Assuming a default behavior for a non-existing recipe (e.g., a new empty recipe)
        assertNull(result2.getName());
    }
}
