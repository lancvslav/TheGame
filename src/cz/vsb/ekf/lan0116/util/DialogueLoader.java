package cz.vsb.ekf.lan0116.util;

import cz.vsb.ekf.lan0116.world.creature.humanoid.Dialogue;

import java.util.ArrayList;
import java.util.List;

public class DialogueLoader {

    /**
     * purpose of this method is to load dialogues from file and process them properly to object Dialogue
     */
    public static Dialogue loadDialogue(List<String> dialogues) {
        List<String> friendly = new ArrayList<>();
        List<String> neutral = new ArrayList<>();

        //load friendly from file, friendly dialogues are marked like this: <friendly>...dialogue...</friendly>
        int fStart = dialogues.indexOf("<friendly>");
        int fEnd = dialogues.indexOf("</friendly>");

        //whole line looks like this <friendly-line>line of dialogue</friendly-line>
        for (int i = fStart + 1; i < fEnd - 1; i++) {
            String wholeLine = dialogues.get(i);
            int lineStart = wholeLine.indexOf(">") + 1;
            int lineEnd = wholeLine.lastIndexOf("<") - 1;
            String line = wholeLine.substring(lineStart, lineEnd);
            friendly.add(line);
        }

        //load neutral from file, looks similarly like friendly
        int nStart = dialogues.indexOf("<neutral>");
        int nEnd = dialogues.indexOf("</neutral>");

        for (int i = nStart + 1; i < nEnd - 1; i++) {
            String wholeLine = dialogues.get(i);
            int lineStart = wholeLine.indexOf(">") + 1;
            int lineEnd = wholeLine.lastIndexOf("<") - 1;
            String line = wholeLine.substring(lineStart, lineEnd);
            neutral.add(line);
        }
        return new Dialogue(friendly, neutral);
    }

}
