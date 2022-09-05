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
public class Customer {
    private String name;    
    private String size;
    private Clothing[] items;

    public Customer(String name, int measurement) {
        this.name = name;
        setSize(measurement);
    }

    public double getTotalClothingCost(){
        double total = 0;
        for(Clothing item : items) { 
            if(item.getSize().equals(getSize())) {
                System.out.println(item);
                total += item.getPrice();
            }
        }
        return total;
    }
                
    public Clothing[] getItems(){
        return items;
    }
    
    public void addItems(Clothing[] clothes){
        this.items = clothes;
    }
        
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
    
    public void setSize(int size) {
        switch(size){
            case 1: case 2: case 3:
                setSize("S");
                break;
            case 4: case 5: case 6:
                setSize("M");
                break;
            case 7: case 8: case 9:
                setSize("L");
                break;
            default:
                setSize("XL");
        }
    }
}
