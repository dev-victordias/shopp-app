/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duke.choice;

/**
 *
 * @author radek
 */
public class Clothing implements Comparable<Clothing> {
    private String description;
    private String size;
    private double price;
    public final static double MINIMUM_PRICE = 10;
    public final static double TAX_RATE = 0.2;
    
    @Override
    public String toString(){
        return description + ", " + size + ", U$" + price;
    }
    
    public Clothing(String description, String size, double price) {
        this.description = description;
        this.size = size;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price + price * TAX_RATE;
    }

    public void setPrice(double price) {
        this.price = (price > MINIMUM_PRICE) ? price: MINIMUM_PRICE;
    }

    @Override
    public int compareTo(Clothing c) {
        return this.description.compareTo(c.description);
    }
}
