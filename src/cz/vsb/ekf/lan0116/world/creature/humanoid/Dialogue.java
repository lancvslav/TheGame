package cz.vsb.ekf.lan0116.world.creature.humanoid;

import java.util.List;

public class Dialogue {

    /**
     * this dialogue is used when same clazz talks to humanoid
     */
    private List<String> friendly;
    /**
     * this dialogue is used when different clazz talks to humanoid
     */
    private List<String> neutral;

    public Dialogue(List<String> friendly, List<String> neutral) {
        this.friendly = friendly;
        this.neutral = neutral;
    }

    public List<String> getFriendly() {
        return friendly;
    }

    public void setFriendly(List<String> friendly) {
        this.friendly = friendly;
    }

    public List<String> getNeutral() {
        return neutral;
    }

    public void setNeutral(List<String> neutral) {
        this.neutral = neutral;
    }
}
