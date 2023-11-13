package edu.towson.cis.cosc442.project4.coffeemaker;

/**
 * Recipe object for the coffee maker
 * @author Josh
 * @version $Revision: 1.0 $
 */
public class Recipe {
    private String name;
    private int price;
    private int amtCoffee;
    private int amtMilk;
    private int amtSugar;
    private int amtChocolate;
    
    /**
     * Method getAmtChocolate.
     * @return int
     */
    public int getAmtChocolate() {
        return amtChocolate;
    }
    /**
     * Method setAmtChocolate.
     * @param amtChocolate int
     */
    public boolean setAmtChocolate(int amtChocolate) {
    	boolean ret = true;
    	if(amtChocolate >= 0) {
    		this.amtChocolate = amtChocolate;
    	}
    	else {
    		this.amtChocolate = 0;
    		ret = false;
    	}
    	return ret;
    }
    /**
     * Method getAmtCoffee.
     * @return int
     */
    public int getAmtCoffee() {
        return amtCoffee;
    }
    /**
     * Method setAmtCoffee.
     * @param amtCoffee int
     */
    public boolean setAmtCoffee(int amtCoffee) {
    	boolean ret = true;
    	if(amtCoffee >= 0) {
    		this.amtCoffee = amtCoffee;
    	}
    	else {
    		this.amtCoffee = 0;
    		ret = false;
    	}
    	return ret;
    }
    /**
     * Method getAmtMilk.
     * @return int
     */
    public int getAmtMilk() {
        return amtMilk;
    }
    /**
     * Method setAmtMilk.
     * @param amtMilk int
     */
    public boolean setAmtMilk(int amtMilk) {
    	boolean ret = true;
    	if(amtMilk >= 0) {
    		this.amtMilk = amtMilk;
    	}
    	else {
    		this.amtMilk = 0;
    		ret = false;
    	}
    	return ret;
    }
    /**
     * Method getAmtSugar.
     * @return int
     */
    public int getAmtSugar() {
        return amtSugar;
    }
    /**
     * Method setAmtSugar.
     * @param amtSugar int
     */
    public boolean setAmtSugar(int amtSugar) {
    	boolean ret = true;
    	if(amtSugar >= 0) {
    		this.amtSugar = amtSugar;
    	}
    	else {
    		this.amtSugar = 0;
    		ret = false;
    	}
    	return ret;
    }
    /**
     * Method getName.
     * @return String
     */
    public String getName() {
        return name;
    }
    /**
     * Method setName.
     * @param name String
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Method getPrice.
     * @return int
     */
    public int getPrice() {
        return price;
    }
    /**
     * Method setPrice.
     * @param price int
     */
    public void setPrice(int price) {
    	if(price >= 0) {
    		this.price = price;
    	}
    	else {
    		this.price = 0;
    	}
    } 
    /**
     * Method equals.
     * @param r Recipe
     * @return boolean
     */
    public boolean equals(Recipe r) {
        if(r.getName() == null) {
	    	return false;
    	}	
        if(this.name == null) {
        	return false;
        }
        if((this.name).equals(r.getName())) {
            return true;
        }
        return false;
    }
    /**
     * Method toString.
     * @return String
     */
    public String toString() {
    	return name;
    }
}
