package cz.vsb.ekf.lan0116.textUi;

import cz.vsb.ekf.lan0116.world.wilderness.Wilderness;

class WildernessUi extends AbstractLocationUi<Wilderness> {

    WildernessUi(Context context) {
        super(context);
    }

    @Override
    public void show() {
        System.out.println("You are fucked.");
    }

}
