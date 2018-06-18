package com.soa.display;

import com.soa.ws.category.WSCave;
import com.soa.ws.category.WSForest;
import com.soa.ws.category.WSTower;
import com.soa.ws.hero.WSDragon;
import com.soa.ws.hero.WSElf;
import com.soa.ws.hero.WSMag;

public class ConsoleDisplayer implements Displayer {

    @Override
    public void display(WSForest wsForest) {
        System.out.println(wsForest);
    }

    @Override
    public void display(WSForest[] wsForests) {
        if (wsForests.length > 0) {
            System.out.println("|\tId\t|\tTrees amount\t|\tElves amount\t");
        }
        StringBuilder builder = new StringBuilder();
        for (WSForest wsForest : wsForests) {
            builder.append("|\t").append(wsForest.getId()).append("\t")
                    .append("|\t").append(wsForest.getAmountOfTrees()).append("\t")
                    .append("|\t").append(wsForest.getElfs().size()).append("\t|\n");
        }
        System.out.println(builder.toString());
    }

    @Override
    public void display(WSTower wsTower) {
        System.out.println(wsTower);
    }

    @Override
    public void display(WSDragon[] wsDragons) {
        if (wsDragons.length > 0) {
            System.out.println("|\tId\t|\tName\t|\tGold\t|\tPower\t|\tColor\t|\tCave id\t|");
        }
        StringBuilder builder = new StringBuilder();
        for (WSDragon wsDragon : wsDragons) {
            builder.append("|\t").append(wsDragon.getId()).append("\t")
                    .append("|\t").append(wsDragon.getName()).append("\t")
                    .append("|\t").append(wsDragon.getGold()).append("\t")
                    .append("|\t").append(wsDragon.getPower()).append("\t")
                    .append("|\t").append(wsDragon.getColor()).append("\t")
                    .append("|\t").append(wsDragon.getCaveId()).append("\t|\n");
        }
        System.out.println(builder.toString());
    }

    @Override
    public void display(WSElf[] wsElves) {
        if (wsElves.length > 0) {
            System.out.println("|\tId\t|\tName\t|\tArrows amount\t|\tPower\t|\tBow type\t|\tForest id\t|");
        }
        StringBuilder builder = new StringBuilder();
        for (WSElf wsElve : wsElves) {
            builder.append("|\t").append(wsElve.getId()).append("\t")
                    .append("|\t").append(wsElve.getName()).append("\t")
                    .append("|\t").append(wsElve.getArrowCount()).append("\t")
                    .append("|\t").append(wsElve.getPower()).append("\t")
                    .append("|\t").append(wsElve.getBowType()).append("\t")
                    .append("|\t").append(wsElve.getForestId()).append("\t|\n");
        }
        System.out.println(builder.toString());
    }

    @Override
    public void display(WSMag[] wsMags) {
        if (wsMags.length > 0) {
            System.out.println("|\tId\t|\tName\t|\tMana\t|\tPower\t|\tElement\t|\tTOwer id\t|");
        }
        StringBuilder builder = new StringBuilder();
        for (WSMag wsMag : wsMags) {
            builder.append("|\t").append(wsMag.getId()).append("\t")
                    .append("|\t").append(wsMag.getName()).append("\t")
                    .append("|\t").append(wsMag.getMana()).append("\t")
                    .append("|\t").append(wsMag.getPower()).append("\t")
                    .append("|\t").append(wsMag.getElement()).append("\t")
                    .append("|\t").append(wsMag.getTowerId()).append("\t|\n");
        }
        System.out.println(builder.toString());
    }

    @Override
    public void display(WSDragon wsDragon) {
        System.out.println(wsDragon);
    }

    @Override
    public void display(WSElf wsElves) {
        System.out.println(wsElves);
    }

    @Override
    public void display(WSMag wsMag) {
        System.out.println(wsMag);
    }

    @Override
    public void display(WSCave wsCave) {
        System.out.println(wsCave);
    }

    @Override
    public void display(WSTower[] wsTowers) {
        if (wsTowers.length > 0) {
            System.out.println("|\tId\t|\tHeight\t|\tMags amount\t");
        }
        StringBuilder builder = new StringBuilder();
        for (WSTower wsTower : wsTowers) {
            builder.append("|\t").append(wsTower.getId()).append("\t")
                    .append("|\t").append(wsTower.getHeight()).append("\t")
                    .append("|\t").append(wsTower.getMags().size()).append("\t|\n");
        }
        System.out.println(builder.toString());
    }

    @Override
    public void display(WSCave[] wsCaves) {
        if (wsCaves.length > 0) {
            System.out.println("|\tId\t|\tSquare\t|\tDragons amount\t");
        }
        StringBuilder builder = new StringBuilder();
        for (WSCave wsCave : wsCaves) {
            builder.append("|\t").append(wsCave.getId()).append("\t")
                    .append("|\t").append(wsCave.getSquare()).append("\t")
                    .append("|\t").append(wsCave.getDragons().size()).append("\t|\n");
        }
        System.out.println(builder.toString());
    }
}
