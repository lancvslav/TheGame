package cz.vsb.ekf.lan0116.textUi.abstracts;

import cz.vsb.ekf.lan0116.textUi.Context;
import cz.vsb.ekf.lan0116.world.item.Item;
import cz.vsb.ekf.lan0116.world.item.Merchandise;

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
        System.out.println();
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
        int oneLine = 27;
        for (int index = 0, column = 0; index < values.length; index++, column++) {
            if (column % 3 == 0) System.out.println();
            System.out.printf("%2d %-24s", index, values[index]);
            if (!(index % 3 == 2)) System.out.print("|");
        }
    }


    /**
     * Convert list of item to Array of Strings
     *
     * @param items List of item to print
     * @return String[] of names
     */
    protected String[] itemsToArray(List<Item> items) {
        String[] choicesArray = new String[items.size()];
        for (int i = 0; i < items.size(); i++) {
            choicesArray[i] = this.get(items.get(i).getName());
        }
        return choicesArray;
    }

    protected String[] merchandiseToArray(List<Merchandise> merchandise) {
        String[] choicesArray = new String[merchandise.size()];
        for (int i = 0; i < merchandise.size(); i++) {
            choicesArray[i] = this.get(merchandise.get(i).getName()) + "-" + merchandise.get(i).getCost();
        }
        return choicesArray;
    }

    protected String get(String keyFormat) {
        return this.getContext().getLocalization().get(keyFormat);
    }

}
