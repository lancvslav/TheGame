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
        int toNextLine = 80;
        for (int index = 0; index < values.length; index++) {
            String value = index + " " + values[index] + "   ";
            if (value.length() > toNextLine) {
                System.out.println("%n");
                toNextLine = 80;
            }
            toNextLine -= value.length();
            System.out.print(value);
        }
    }

    /**
     * Ugly hardcoded method, only use in specific situations. That is why it is protected
     * Prints list of items, in which first value must have index 1
     *
     * @param items List of itemst to print
     */
    protected String[] listToChoices(List<Merchandise> items) {
        String[] choicesArray = new String[items.size() + 1];
        for (int i = 0; i <= items.size(); i++) {
            choicesArray[i] = items.get(i).getName();
        }
        return choicesArray;
    }

    protected String get(String keyFormat) {
        return this.getContext().getLocalization().get(keyFormat);
    }

}
