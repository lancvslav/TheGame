package cz.vsb.ekf.lan0116.world.items;

public class Merchandise extends Item {

    private final int cost;
    private MerchType merchType;

    public Merchandise(String nameOfMerch, int cost) {
        super(nameOfMerch);
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public MerchType getMerchType() {
        return merchType;
    }

    @Override
    public String toString() {
        return this.getName() + ", cost: " + this.cost;
    }

}
