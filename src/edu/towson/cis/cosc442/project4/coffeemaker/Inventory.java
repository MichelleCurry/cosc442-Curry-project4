package edu.towson.cis.cosc442.project4.coffeemaker;

/**
 * Inventory for the coffee maker
 * @author Josh
 * @version $Revision: 1.0 $
 */
public class Inventory {
    
    private static int coffee;
    private static int milk;
    private static int sugar;
    private static int chocolate;
    
    public Inventory() {
    	setCoffee(15);
    	setMilk(15);
    	setSugar(15);
    	setChocolate(15);
    }
    
    /**
     * Method getChocolate.
     * @return int
     */
    public int getChocolate() {
        return chocolate;
    }
    /**
     * Method setChocolate.
     * @param chocolate int
     */
    public static boolean setChocolate(int chocolate) {
    	boolean ret = true;
    	if(chocolate >= 0) {
    		Inventory.chocolate = chocolate;
    	}
    	else {
    		Inventory.chocolate = 0;
    		ret = false;
    	}
        return ret;
    }
    /**
     * Method getCoffee.
     * @return int
     */
    public int getCoffee() {
        return coffee;
    }
    /**
     * Method setCoffee.
     * @param coffee int
     */
    public static boolean setCoffee(int coffee) {
    	boolean ret = true;
    	if(coffee >= 0) {
    		Inventory.coffee = coffee;
    	}
    	else {
    		Inventory.coffee = 0;
    		ret = false;
    	}
    	return ret;
    }
    /**
     * Method getMilk.
     * @return int
     */
    public int getMilk() {
        return milk;
    }
    /**
     * Method setMilk.
     * @param milk int
     */
    public static boolean setMilk(int milk) {
    	boolean ret = true;

    	if(milk >= 0) {
    		Inventory.milk = milk;
    	}
    	else {
    		Inventory.milk = 0;
    		ret = false;
    	}
    	return ret;
    }
    /**
     * Method getSugar.
     * @return int
     */
    public int getSugar() {
        return sugar;
    }
    /**
     * Method setSugar.
     * @param sugar int
     */
    public static boolean setSugar(int sugar) {
    	boolean ret = true;
    	if(sugar >= 0) {
    		Inventory.sugar = sugar;
    	}
    	else {
    		Inventory.sugar = 0;
    		ret = false;
    	}
    	return ret;
    }
    
    /**
     * Returns true if there are enough ingredients to make
     * the beverage.
     * @param r
    
     * @return boolean */
    public boolean enoughIngredients(Recipe r) {
        boolean isEnough = true;
        if (Inventory.coffee < r.getAmtCoffee()) {
            isEnough = false;
        }
        if (Inventory.milk < r.getAmtMilk()) {
            isEnough = false;
        }
        if (Inventory.sugar < r.getAmtSugar()) {
            isEnough = false;
        }
        if (Inventory.chocolate < r.getAmtChocolate()) {
            isEnough = false;}
        return isEnough;
    }
    
    /**
     * Method toString.
     * @return String
     */
    public String toString() {
    	return "Coffee: " + getCoffee() + "\n" +
			"Milk: " + getMilk() + "\n" +
			"Sugar: " + getSugar() + "\n" +
			"Chocolate: " + getChocolate() + "\n";
    }
}
