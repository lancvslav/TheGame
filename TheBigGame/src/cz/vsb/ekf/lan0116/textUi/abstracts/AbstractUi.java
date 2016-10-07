package cz.vsb.ekf.lan0116.textUi.abstracts;

import cz.vsb.ekf.lan0116.textUi.Context;
import cz.vsb.ekf.lan0116.world.items.Merchandise;

import java.util.List;

public abstract class AbstractUi implements Ui {

    private final Context context;

    protected AbstractUi(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    /**
     * Prints numbered choices to make
     *
     * @param choices, varargs
     * @return Integer, number representing users choice
     */
    protected int choice(String... choices) {
        this.printArray(choices);
        System.out.printf("%n");
        String choice = this.getContext().getScanner().nextLine();
        if (this.getContext().getLocalization().get("textUi.AbstractUi.flee").equals(choice)) {
            throw new RuntimeException(this.get("textUi.AbstractUi.fled") + "\n");
        }
        return Integer.parseInt(choice);
    }

    /**
     * Prints array on line with line folding
     *
     * @param values Array of choices to print
     */
    protected void printArray(String[] values) {
        int max = 0;
        for (String value : values) {
            max = ((value.length()) > max) ? value.length() : max;
        }
        int column;
        if (max <= 80 && max > 40) {
            column = 1;
        } else if (max <= 40 && max > 27) {
            column = 2;
        } else if (max <= 27 && max > 20) {
            column = 3;
        } else {
            column = 4;
        }
        int checker = 0;
        for (int index = 0; index < values.length; index++) {
            String value = index + " " + values[index];
            String format = "%-" + (max + 3) + "s";
            System.out.print("│");
            System.out.printf(format, value);
            checker++;
            if (checker == column) {
                System.out.printf("%n");
                checker = 0;
            }
        }
    }


    /**
     * Convert list to Array of Strings
     *
     * @param items List of items to print
     */
    protected String[] listToChoices(List<Merchandise> items) {
        String[] choicesArray = new String[items.size()];
        for (int i = 0; i < items.size(); i++) {
            choicesArray[i] = this.get(items.get(i).getName());
        }
        return choicesArray;
    }

    protected String get(String keyFormat) {
        return this.getContext().getLocalization().get(keyFormat);
    }

}
