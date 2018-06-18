package com.soa.display;

import com.soa.ws.category.WSCave;
import com.soa.ws.category.WSForest;
import com.soa.ws.category.WSTower;
import com.soa.ws.hero.WSDragon;
import com.soa.ws.hero.WSElf;
import com.soa.ws.hero.WSMag;

public interface Displayer {
    void display(WSCave[] wsCaves);
    void display(WSForest[] wsForests);
    void display(WSTower[] wsTowers);

    void display(WSCave wsCave);
    void display(WSForest wsForest);
    void display(WSTower wsTower);

    void display(WSDragon[] wsDragons);
    void display(WSElf[] wsElves);
    void display(WSMag[] wsMags);

    void display(WSDragon wsDragon);
    void display(WSElf wsElves);
    void display(WSMag wsMag);
}
