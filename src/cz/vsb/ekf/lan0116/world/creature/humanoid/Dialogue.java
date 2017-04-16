package cz.vsb.ekf.lan0116.world.creature.humanoid;

import java.util.List;

public class Dialogue {

    /**
     * this dialogue is used when same clazz talks to humanoid
     */
    private List<String> friendly;
    /**
     * holds state of previous conversation, so npc doesn't start talk all over again
     */
    private int friendlyIndex;
    private String friendlyBye;
    /**
     * this dialogue is used when different clazz talks to humanoid
     */
    private List<String> neutral;
    /**
     * holds state of previous conversation, so npc doesn't start talk all over again
     */
    private int neutralIndex;
    private String neutralBye;

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

    public int getFriendlyIndex() {
        return friendlyIndex;
    }

    public void setFriendlyIndex(int friendlyIndex) {
        this.friendlyIndex = friendlyIndex;
    }

    public String getFriendlyBye() {
        return friendlyBye;
    }

    public void setFriendlyBye(String friendlyBye) {
        this.friendlyBye = friendlyBye;
    }

    public List<String> getNeutral() {
        return neutral;
    }

    public void setNeutral(List<String> neutral) {
        this.neutral = neutral;
    }

    public int getNeutralIndex() {
        return neutralIndex;
    }

    public void setNeutralIndex(int neutralIndex) {
        this.neutralIndex = neutralIndex;
    }

    public String getNeutralBye() {
        return neutralBye;
    }

    public void setNeutralBye(String neutralBye) {
        this.neutralBye = neutralBye;
    }
}
