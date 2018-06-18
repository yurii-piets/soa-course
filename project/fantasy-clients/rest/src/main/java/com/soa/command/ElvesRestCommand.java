package com.soa.command;

import com.soa.ws.hero.WSElf;
import lombok.Getter;

import java.net.URI;
import java.net.URISyntaxException;

@Getter
public class ElvesRestCommand extends AbstractRestCommand<WSElf> {

    private String postfix = "/heroes/elfs";

    public ElvesRestCommand() {
        super(WSElf.class);
    }

    @Override
    public WSElf[] getAll() {
        try {
            URI uri = new URI(BASIC_API_URI + postfix);
            return restTemplate.getForObject(uri, WSElf[].class);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return new WSElf[]{};
    }
}
