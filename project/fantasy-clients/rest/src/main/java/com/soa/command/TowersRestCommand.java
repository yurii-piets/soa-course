package com.soa.command;

import com.soa.ws.category.WSTower;
import lombok.Getter;

import java.net.URI;
import java.net.URISyntaxException;

@Getter
public class TowersRestCommand extends AbstractRestCommand<WSTower> {

    private String postfix = "/categories/towers";

    public TowersRestCommand() {
        super(WSTower.class);
    }

    @Override
    public WSTower[] getAll() {
        try {
            URI uri = new URI(BASIC_API_URI + postfix);
            return restTemplate.getForObject(uri, WSTower[].class);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return new WSTower[]{};
    }
}
