package com.soa.command;

import com.soa.ws.category.WSCave;
import lombok.Getter;

import java.net.URI;
import java.net.URISyntaxException;

@Getter
public class CavesRestCommand extends AbstractRestCommand<WSCave> {

    private String postfix = "/categories/caves";

    public CavesRestCommand() {
        super(WSCave.class);
    }

    @Override
    public WSCave[] getAll() {
        try {
            URI uri = new URI(BASIC_API_URI + postfix);
            return restTemplate.getForObject(uri, WSCave[].class);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return new WSCave[]{};
    }
}
