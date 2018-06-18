package com.soa;

import com.soa.command.CavesRestCommand;
import com.soa.command.TowersRestCommand;
import com.soa.ws.category.WSCave;
import com.soa.ws.category.WSTower;

import java.util.Scanner;

public class RestClientApplication {

    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (!Thread.interrupted()) {
            printOptions();
            int command = scanner.nextInt();
            switch (command) {
                case 1:
                    display(new CavesRestCommand().getAll());
                    break;
                case 2:
                    System.out.print("Enter cave id:");
                    display(new CavesRestCommand().getById((long) scanner.nextInt()));
                    break;
                case 3:
                    display(new TowersRestCommand().getAll());
                    break;
                case 4:
                    System.out.print("Enter tower id:");
                    display(new TowersRestCommand().getById((long) scanner.nextInt()));
                    break;
            }
        }
    }

    private static void display(WSTower wsTower) {
        System.out.println(wsTower);
    }

    private static void display(WSCave wsCave) {
        System.out.println(wsCave);
    }

    private static void display(WSTower[] wsTowers) {
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

    private static void display(WSCave[] wsCaves) {
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

    private static void printOptions() {
        System.out.println("Choose action:\n"
                + "[OK]\t1. Get caves.\n"
                + "[OK]\t2. Get cave by id.\n"
                + "[OK]\t3. Get towers.\n"
                + "[OK]\t4. Get tower by id.\n"
                + "\t5. Get forest.\n"
                + "\t6. Get forest by id.\n"
                + "\t7. Get dragons.\n"
                + "\t8. Get dragon by id.\n"
                + "\t9. Get elves.\n"
                + "\t10. Get elf by id.\n"
                + "\t11. Get mags.\n"
                + "\t12. Get mag by id.\n"

                + "\t13. Post cave.\n"
                + "\t14. Post tower.\n"
                + "\t15. Post forest.\n"

                + "\t16. Post dragon.\n"
                + "\t17. Post elf.\n"
                + "\t18. Post mag.\n"
        );
    }
}
