package com.soa;

import com.soa.command.CavesRestCommand;
import com.soa.command.DragonsRestCommand;
import com.soa.command.ElvesRestCommand;
import com.soa.command.ForestsRestCommand;
import com.soa.command.MagsRestCommand;
import com.soa.command.TowersRestCommand;
import com.soa.display.ConsoleDisplayer;
import com.soa.display.Displayer;
import com.soa.domain.Power;
import com.soa.domain.hero.Dragon;
import com.soa.domain.hero.Elf;
import com.soa.domain.hero.Mag;
import com.soa.ws.category.WSCave;
import com.soa.ws.category.WSForest;
import com.soa.ws.category.WSTower;
import com.soa.ws.hero.WSDragon;
import com.soa.ws.hero.WSElf;
import com.soa.ws.hero.WSMag;

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

                case 13:
                    System.out.println("Enter cave square:");
                    int sqaure = scanner.nextInt();
                    WSCave cave = new WSCave();
                    cave.setSquare(sqaure);
                    new CavesRestCommand().post(cave);
                    break;
                case 14:
                    System.out.println("Enter tower's height:");
                    int height = scanner.nextInt();
                    WSTower wsTower = new WSTower();
                    wsTower.setHeight(height);
                    new TowersRestCommand().post(wsTower);
                    break;
                case 15:
                    System.out.println("Enter trees amount:");
                    int treesAmount = scanner.nextInt();
                    WSForest wsForest = new WSForest();
                    wsForest.setAmountOfTrees(treesAmount);
                    new ForestsRestCommand().post(wsForest);
                    break;
                case 16: {
                    System.out.println("Name:");
                    String name = scanner.nextLine();
                    System.out.println("Gold:");
                    Integer gold = scanner.nextInt();
                    System.out.println("Color:");
                    String color = scanner.nextLine();
                    System.out.println("Power:");
                    String power = scanner.nextLine();
                    System.out.println("Cave id:");
                    Long caveId = scanner.nextLong();

                    WSDragon wsDragon = new WSDragon();
                    wsDragon.setName(name);
                    wsDragon.setGold(gold);
                    wsDragon.setColor(Dragon.Color.valueOf(color));
                    wsDragon.setPower(Power.valueOf(power));
                    wsDragon.setCaveId(caveId);
                    new DragonsRestCommand().post(wsDragon);
                    break;
                }
                case 17: {
                    System.out.println("Name:");
                    String name = scanner.nextLine();
                    System.out.println("Arrow count:");
                    Integer arrowCount = scanner.nextInt();
                    System.out.println("Bow type:");
                    String bowType = scanner.nextLine();
                    System.out.println("Power:");
                    String power = scanner.nextLine();
                    System.out.println("Forest id:");
                    Long forestId = scanner.nextLong();

                    WSElf wsElf = new WSElf();
                    wsElf.setName(name);
                    wsElf.setArrowCount(arrowCount);
                    wsElf.setBowType(Elf.BowType.valueOf(bowType));
                    wsElf.setPower(Power.valueOf(power));
                    wsElf.setForestId(forestId);

                    new ElvesRestCommand().post(wsElf);
                    break;
                }
                case 18: {
                    System.out.println("Name:");
                    String name = scanner.nextLine();
                    System.out.println("Mana:");
                    Integer mana = scanner.nextInt();
                    System.out.println("element:");
                    String element = scanner.nextLine();
                    System.out.println("Power:");
                    String power = scanner.nextLine();
                    System.out.println("Tower id:");
                    Long towerId = scanner.nextLong();

                    WSMag wsMag = new WSMag();
                    wsMag.setName(name);
                    wsMag.setMana(mana);
                    wsMag.setElement(Mag.Element.valueOf(element));
                    wsMag.setPower(Power.valueOf(power));
                    wsMag.setTowerId(towerId);

                    new MagsRestCommand().post(wsMag);
                    break;
                }
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
