package cz.vsb.ekf.lan0116.util;

import cz.vsb.ekf.lan0116.world.creature.humanoid.Dialogue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class DialogueLoaderTest {
    private List<String> dialogueList;

    /**
     * creating List of dialogueList in form that it is going to be loaded from file
     */
    @BeforeEach
    void setUp() {
        dialogueList = new ArrayList<>();
        dialogueList.add("<friendly>");
        dialogueList.add("<friendly-line>friendly line</friendly-line>");
        dialogueList.add("</friendly>");
        dialogueList.add("<friendly-bye>friendly-bye line</friendly-bye>");
        dialogueList.add("<neutral>");
        dialogueList.add("<neutral-line>neutral line</neutral-line>");
        dialogueList.add("</neutral>");
    }

    @Test
    void testLoadFriendly() {
        Dialogue dialogue = DialogueLoader.loadDialogue(dialogueList);

        String expectFriendly = "friendly line";
        String actualFriendly = dialogue.getFriendly().get(0);

        assertEquals(expectFriendly, actualFriendly);
    }

    @Test
    void testLoadFriendlyBye() {
        Dialogue dialogue = DialogueLoader.loadDialogue(dialogueList);

        String expectFriendlyBye = "friendly-bye line";
        String actualFriendlyBye = dialogue.getFriendlyBye();

        assertEquals(expectFriendlyBye, actualFriendlyBye);
    }

    @Test
    void testLoadNeutral() {
        Dialogue dialogue = DialogueLoader.loadDialogue(dialogueList);

        String expectNeutral = "neutral line";
        String actualNeutral = dialogue.getNeutral().get(0);

        assertEquals(expectNeutral, actualNeutral);
    }

}