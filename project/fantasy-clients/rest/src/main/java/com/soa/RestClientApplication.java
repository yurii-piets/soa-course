package com.soa;

import com.soa.command.CavesRestCommand;
import com.soa.command.DragonsRestCommand;
import com.soa.command.ElvesRestCommand;
import com.soa.command.ForestsRestCommand;
import com.soa.command.MagsRestCommand;
import com.soa.command.TowersRestCommand;
import com.soa.display.ConsoleDisplayer;
import com.soa.display.Displayer;

import java.util.Scanner;

public class RestClientApplication {

    private final static Scanner scanner = new Scanner(System.in);

    private final static Displayer displayer = new ConsoleDisplayer();

    public static void main(String[] args) {
        while (!Thread.interrupted()) {
            printOptions();
            int command = scanner.nextInt();
            switch (command) {
                case 1:
                    displayer.display(new CavesRestCommand().getAll());
                    break;
                case 2:
                    System.out.print("Enter cave id:");
                    displayer.display(new CavesRestCommand().getById((long) scanner.nextInt()));
                    break;
                case 3:
                    displayer.display(new TowersRestCommand().getAll());
                    break;
                case 4:
                    System.out.print("Enter tower id:");
                    displayer.display(new TowersRestCommand().getById((long) scanner.nextInt()));
                    break;
                case 5:
                    displayer.display(new ForestsRestCommand().getAll());
                    break;
                case 6:
                    System.out.print("Enter tower id:");
                    displayer.display(new ForestsRestCommand().getById((long) scanner.nextInt()));
                    break;
                case 7:
                    displayer.display(new DragonsRestCommand().getAll());
                    break;
                case 8:
                    System.out.print("Enter dragon id:");
                    displayer.display(new DragonsRestCommand().getById((long) scanner.nextInt()));
                    break;
                case 9:
                    displayer.display(new ElvesRestCommand().getAll());
                    break;
                case 10:
                    System.out.print("Enter elf id:");
                    displayer.display(new ElvesRestCommand().getById((long) scanner.nextInt()));
                    break;
                case 11:
                    displayer.display(new MagsRestCommand().getAll());
                    break;
                case 12:
                    System.out.print("Enter mag id:");
                    displayer.display(new MagsRestCommand().getById((long) scanner.nextInt()));
                    break;
            }
        }
    }



    private static void printOptions() {
        System.out.println("Choose action:\n"
                + "\t1. Get caves.\n"
                + "\t2. Get cave by id.\n"
                + "\t3. Get towers.\n"
                + "\t4. Get tower by id.\n"
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
