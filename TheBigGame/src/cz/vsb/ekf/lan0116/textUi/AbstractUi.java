package cz.vsb.ekf.lan0116.textUi;

public abstract class AbstractUi implements Ui {

    private final Context context;

    public AbstractUi(Context context) {
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
        for (int i = 0; i < choices.length; i++) {
            System.out.println((i) + " " + choices[i]);
        }
        String choice = this.getContext().getScanner().nextLine();
        if (this.getContext().getLocalization().get("textUi.AbstractUi.flee").equals(choice)) {
            throw new RuntimeException(this.get("textUi.AbstractUi.fled") + "\n");
        }
//        if (!((Integer.parseInt(choice)) < 0 && (Integer.parseInt(choice)) >= choices.length)) {
        return Integer.parseInt(choice);
//        } else {
//            this.choice(choices);
//        }
    }

    void sleep(long milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected String get(String keyFormat) {
        return this.getContext().getLocalization().get(keyFormat);
    }

}
