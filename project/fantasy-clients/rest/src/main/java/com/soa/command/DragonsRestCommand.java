package com.soa.command;

import com.soa.ws.hero.WSDragon;
import lombok.Getter;

import java.net.URI;
import java.net.URISyntaxException;

@Getter
public class DragonsRestCommand extends AbstractRestCommand<WSDragon> {

    private String postfix = "/heroes/dragons";

    public DragonsRestCommand() {
        super(WSDragon.class);
    }

    @Override
    public WSDragon[] getAll() {
        try {
            URI uri = new URI(BASIC_API_URI + postfix);
            return restTemplate.getForObject(uri, WSDragon[].class);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return new WSDragon[]{};
    }
}
