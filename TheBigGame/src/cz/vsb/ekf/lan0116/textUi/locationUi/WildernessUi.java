package cz.vsb.ekf.lan0116.textUi.locationUi;

import cz.vsb.ekf.lan0116.textUi.Context;
import cz.vsb.ekf.lan0116.textUi.abstracts.AbstractLocationUi;
import cz.vsb.ekf.lan0116.world.wilderness.Wilderness;

public class WildernessUi extends AbstractLocationUi<Wilderness> {

    public WildernessUi(Context context) {
        super(context);
    }

    @Override
    public void show() {
        System.out.println("You are fucked.");
    }

}
