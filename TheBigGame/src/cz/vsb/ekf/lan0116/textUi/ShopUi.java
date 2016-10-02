package cz.vsb.ekf.lan0116.textUi;

import cz.vsb.ekf.lan0116.world.buildings.Shop;

class ShopUi extends AbstractLocationUi<Shop> {

    private MerchandiseUi merchandiseUi;
    private RestHeroUi restHeroUi;

    ShopUi(Context context) {
        super(context);
    }

    @Override
    public Shop getLoc() {
        return (Shop) this.getContext().getHero().getPosition();
    }

    /**
     * Prints Ui for current shop
     */
    @Override
    public void show() {
        //You are at
        System.out.printf("\n%s %s%n", this.get(TextUtil.quote("current_location")), this.get(this.getLoc().getName()));

        System.out.printf("%s%n", this.get("textUi.ShopUi.doors"));
        for (int i = 0; i < this.getLoc().getGateways().size(); i++) {
            System.out.println(this.get(this.getLoc().getGateways().get(i).getTarget().getName()));
        }
        System.out.println();
        switch (this.choice(
                this.get("textUi.ShopUi.ask"),
                this.get("textUi.menu.rest"),
                this.get("textUi.ShopUi.leave"))) {
            case 0:
                merchandiseUi = new MerchandiseUi(getContext());
                merchandiseUi.show();
                break;
            case 1:
                restHeroUi = new RestHeroUi(getContext());
                restHeroUi.show();
            case 2:
                this.travel();
                break;
        }
    }
}
