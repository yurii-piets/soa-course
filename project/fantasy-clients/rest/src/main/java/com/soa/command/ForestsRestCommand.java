package com.soa.command;

import com.soa.ws.category.WSForest;
import lombok.Getter;

import java.net.URI;
import java.net.URISyntaxException;

@Getter
public class ForestsRestCommand extends AbstractRestCommand<WSForest> {

    private String postfix = "/categories/forests";

    public ForestsRestCommand() {
        super(WSForest.class);
    }

    @Override
    public WSForest[] getAll() {
        try {
            URI uri = new URI(BASIC_API_URI + postfix);
            return restTemplate.getForObject(uri, WSForest[].class);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return new WSForest[]{};
    }
}
