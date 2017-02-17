package cz.vsb.ekf.lan0116.textUi.heroUi;

import cz.vsb.ekf.lan0116.util.Localization;
import cz.vsb.ekf.lan0116.world.creature.hero.Hero;
import cz.vsb.ekf.lan0116.world.creature.hero.Ranger;
import cz.vsb.ekf.lan0116.world.creature.hero.Sorcerer;
import cz.vsb.ekf.lan0116.world.creature.hero.Warrior;

import java.util.Scanner;

public class HeroCreationUi {

    /**
     * Method basically creates a Hero, but has a form of a dialogue with user.
     * Therefore it has text content printed on terminal
     *
     * @param scanner Scanner created in main, then loaded
     * @return Returns Hero created from users input
     */
    public static Hero creationOfHero(Scanner scanner, Localization localization) {

//        TextUtil.newGame(localization);
        String nameOfHero;
        System.out.println(localization.get("textUi.HeroCreationUi.name0"));
        scanner.nextLine();
        System.out.println(localization.get("textUi.HeroCreationUi.poop0"));
        System.out.println(localization.get("textUi.HeroCreationUi.poop1"));
        scanner.nextLine();
        System.out.println("\n" + localization.get("textUi.HeroCreationUi.pleasure") + "\n");
        nameOfHero = "hero_name.poop";
        Hero hero = null;
        while (hero == null) {
            printClasses(localization);
            String tempString = "";
            tempString = scanner.nextLine();
            while (!(tempString.equals("0") || tempString.equals("1") || tempString.equals("2"))) {
                System.out.println(localization.get("textUi.one_job"));
                tempString = scanner.nextLine();
            }
            int tempChoiceNumber = Integer.parseInt(tempString);
            switch (tempChoiceNumber) {
                case 0:
                    hero = new Warrior(nameOfHero);
                    break;
                case 1:
                    hero = new Ranger(nameOfHero);
                    break;
                case 2:
                    hero = new Sorcerer(nameOfHero);
                    break;
            }
            System.out.println(localization.get(nameOfHero) + " " + localization.get("textUi.HeroCreationUi.wields")
                    + " " + localization.get(hero.getWeapon().getName()));
        }
        return hero;
    }

    /**
     * Prints text variety of heroHandling's classes to select
     */

    public static void printClasses(Localization localization) {
        System.out.println(localization.get("textUi.HeroCreationUi.kind_of_man") + "\n");
        System.out.println(localization.get("textUi.HeroCreationUi.warrior"));
        System.out.println(localization.get("textUi.HeroCreationUi.ranger"));
        System.out.println(localization.get("textUi.HeroCreationUi.sorcerer"));
    }

}
