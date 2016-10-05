package cz.vsb.ekf.lan0116.textUi.abstracts;

import cz.vsb.ekf.lan0116.textUi.Context;

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
        int toNextLine = 80;
        for (int i = 0; i < choices.length; i++) {
            String lineChoice = (i) + " " + choices[i];
            if (lineChoice.length() > toNextLine) {
                System.out.printf("%n");
                toNextLine = 80;
            }
            System.out.println(lineChoice);
            toNextLine -= lineChoice.length();
        }
        String choice = this.getContext().getScanner().nextLine();
        if (this.getContext().getLocalization().get("textUi.AbstractUi.flee").equals(choice)) {
            throw new RuntimeException(this.get("textUi.AbstractUi.fled") + "\n");
        }
        return Integer.parseInt(choice);
    }

    protected String get(String keyFormat) {
        return this.getContext().getLocalization().get(keyFormat);
    }

}
