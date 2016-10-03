package cz.vsb.ekf.lan0116.textUi.heroUi;

import cz.vsb.ekf.lan0116.util.Localization;
import cz.vsb.ekf.lan0116.world.creature.hero.Hero;
import cz.vsb.ekf.lan0116.world.creature.hero.Ranger;
import cz.vsb.ekf.lan0116.world.creature.hero.Sorcerer;
import cz.vsb.ekf.lan0116.world.creature.hero.Warrior;

import java.util.Scanner;

public class HeroCreationUi {

    /**
     * Method basically creates a Hero, but has a form of a dialogue with user. Therefore it has text content printed on terminal
     *
     * @param scanner
     * @return Returns Hero created from users input
     */
    public static Hero creationOfHero(Scanner scanner, Localization localization) {

//        TextUtil.newGame(localization);
        String nameOfHero;
        System.out.printf("%s%n", localization.get("textUi.HeroCreationUi.name0"));
        while (true) {
            nameOfHero = scanner.nextLine();
            if (!((nameOfHero == null) || (nameOfHero.equals("")))) {
                break;
            }
            System.out.println(localization.get("textUi.HeroCreationUi.name1")+"\n");
        }
        System.out.printf("\n%s %s\n%n", localization.get("textUi.HeroCreationUi.pleasure"), nameOfHero);
        Hero hero = null;
        while (hero == null) {
            printClasses(localization);
            int tempChoiceNumber = scanner.nextInt();
            scanner.nextLine();
            switch (tempChoiceNumber) {
                case 0:
                    hero = new Warrior(nameOfHero);
                    System.out.printf("\n%s\n%n", hero.toString());
                    break;
                case 1:
                    hero = new Ranger(nameOfHero);
                    System.out.printf("\n%s\n%n", hero.toString());
                    break;
                case 2:
                    hero = new Sorcerer(nameOfHero);
                    System.out.printf("\n%s\n%n", hero.toString());
                    break;
            }
        }
        return hero;
    }

    /**
     * Prints text variety of hero's classes to select
     */
    public static void printClasses(Localization localization) {
        System.out.println(localization.get("textUi.HeroCreationUi.kind_of_man")+"\n");
        System.out.println(localization.get("textUi.HeroCreationUi.warrior"));
        System.out.println(localization.get("textUi.HeroCreationUi.ranger"));
        System.out.println(localization.get("textUi.HeroCreationUi.sorcerer"));
    }

}
