package com.soa.command;

import com.soa.ws.hero.WSMag;
import lombok.Getter;

import java.net.URI;
import java.net.URISyntaxException;

@Getter
public class MagsRestCommand extends AbstractRestCommand<WSMag> {

    private String postfix = "/heroes/mags";

    public MagsRestCommand() {
        super(WSMag.class);
    }

    @Override
    public WSMag[] getAll() {
        try {
            URI uri = new URI(BASIC_API_URI + postfix);
            return restTemplate.getForObject(uri, WSMag[].class);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return new WSMag[]{};
    }
}
