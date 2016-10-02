package cz.vsb.ekf.lan0116.textUi;

class RestHeroUi extends AbstractUi {

    private InventoryUi inventoryUi;
    private LocationUi locationUi;

    RestHeroUi(Context context) {
        super(context);
    }

    @Override
    public void show() {
        System.out.println();
        switch (this.choice(
                this.get("textUi.RestHeroUi.inventory"),
                this.get("textUi.RestHeroUi.consume"),
                this.get("textUi.RestHeroUi.getUp"))) {
            case 0:
                inventoryUi = new InventoryUi(getContext());
                inventoryUi.show();
                break;
            case 1:
                System.out.printf("%s\n%n", this.get("textUi.RestHeroUi.starve"));
                this.show();
                break;
            case 2:
                locationUi = new LocationUi(getContext());
                locationUi.show();
        }
    }

}
