package cz.vsb.ekf.lan0116.textUi;

import cz.vsb.ekf.lan0116.util.Localization;
import cz.vsb.ekf.lan0116.util.ResourceType;
import cz.vsb.ekf.lan0116.util.ResourceUtil;

import java.util.List;
import java.util.Random;

public class TextUtil {

    public static void sleep(long milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * New game quotes
     */
    public static void newGame(Localization localization) {
        List<String> newGame = ResourceUtil.getResource(ResourceType.QUOTE, "new_game");
        for (int i = 0; i < 3; i++) {
            System.out.println(localization.get(newGame.get(i)));
            sleep(1500);
        }
        for (int i = 3; i < 5; i++) {
            System.out.println(localization.get(newGame.get(i)));
            sleep(2500);
        }
        for (int i = 5; i < 12; i++) {
            System.out.println(localization.get(newGame.get(i)));
            sleep(4000);
        }
    }


    /**
     * Printing randomly generated quote
     *
     * @param fileName, file from which is read.
     * @return
     */
    public static String quote(String fileName) {
        Random random = new Random();
        List<String> curLocQuote = ResourceUtil.getResource(ResourceType.QUOTE, fileName);
        int randomQuote = random.nextInt(curLocQuote.size());
        return curLocQuote.get(randomQuote);
    }


}
