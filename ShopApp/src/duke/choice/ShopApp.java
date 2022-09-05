/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duke.choice;

import java.util.Arrays;
import io.helidon.webserver.Routing;
import io.helidon.webserver.ServerConfiguration;
import io.helidon.webserver.WebServer;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author radek
 */
public class ShopApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        StringBuilder welcome = new StringBuilder();
        Customer c1 = new Customer("Pinky", 3);
        welcome.append("==============================\n");
        welcome.append("Welcome to Duke Choice Shop!\n");
        welcome.append("The Customer is ").append(c1.getName()).append("!\n");
        welcome.append("The minimum price is ").append(Clothing.MINIMUM_PRICE).append("!\n");
        welcome.append("The tax rate is ").append(Clothing.TAX_RATE).append("!\n");
        welcome.append("==============================\n");
        
        Clothing item1 = new Clothing("Blue Jacket", "S", 20.9);     
        Clothing item2 = new Clothing("Orange T-Shirt", "X", 10.5);
        Clothing item3 = new Clothing("Green Scarf", "S", 20.0);            
        Clothing item4 = new Clothing("Blue T-Shirt", "M", 10.5);       
        Clothing[] items = {item1, item2, item3, item4};   

        try {
            ItemList list = new ItemList(items, welcome);
            Routing routing = Routing.builder()
                    .get("/items", list).build();
            ServerConfiguration config = ServerConfiguration.builder()
                    .bindAddress(InetAddress.getLocalHost())
                    .port(8888).build();
            WebServer ws = WebServer.create(config, routing);
            ws.start();
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        }
        
    }    
}
