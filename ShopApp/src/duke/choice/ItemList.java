/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duke.choice;

import io.helidon.common.http.Http;
import io.helidon.webserver.Handler;
import io.helidon.webserver.ServerRequest;
import io.helidon.webserver.ServerResponse;

/**
 *
 * @author radek
 */
public class ItemList implements Handler {

    public Clothing[] items;
    public StringBuilder welcome;
    
    ItemList(Clothing[] items, StringBuilder welcome) {
        this.items = items;
        this.welcome = welcome;
    }

    @Override
    public void accept(ServerRequest req, ServerResponse res) {
        res.status(Http.Status.OK_200);
        res.headers().put("Content-Type", "text/plain; charset=UTF-8");
        StringBuilder result = new StringBuilder();
        result.append(welcome);
        for (Clothing item : items) {
            result.append(item).append("\n");
        }
        res.send(result);
    }
}
