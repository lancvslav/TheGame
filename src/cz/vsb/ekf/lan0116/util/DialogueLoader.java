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

        int lineStart;
        int lineEnd;

        //load friendly from file, friendly dialogues are marked like this: <friendly>...dialogue...</friendly>
        int startIndex = dialogues.indexOf("<friendly>");
        int endIndex = dialogues.indexOf("</friendly>");

        //whole line looks like this <friendly-line>line of dialogue</friendly-line>
        for (int i = startIndex + 1; i < endIndex; i++) {
            String wholeLine = dialogues.get(i);
            lineStart = wholeLine.indexOf(">") + 1;
            lineEnd = wholeLine.lastIndexOf("<");
            String line = wholeLine.substring(lineStart, lineEnd);
            friendly.add(line);
        }

        //load friendly bye
        startIndex = dialogues.indexOf("<friendly-bye>");
        String byeWholeLine = dialogues.get(startIndex);
        lineStart = byeWholeLine.indexOf(">") + 1;
        lineEnd = byeWholeLine.lastIndexOf("<");
        String friendlyBye = byeWholeLine.substring(lineStart, lineEnd);

        //load neutral from file, looks similarly like friendly
        startIndex = dialogues.indexOf("<neutral>");
        endIndex = dialogues.indexOf("</neutral>");

        for (int i = startIndex + 1; i < endIndex; i++) {
            String wholeLine = dialogues.get(i);
            lineStart = wholeLine.indexOf(">") + 1;
            lineEnd = wholeLine.lastIndexOf("<");
            String line = wholeLine.substring(lineStart, lineEnd);
            neutral.add(line);
        }


        //load neutral bye
        startIndex = dialogues.indexOf("<neutral-bye>");
        byeWholeLine = dialogues.get(startIndex);
        lineStart = byeWholeLine.indexOf(">") + 1;
        lineEnd = byeWholeLine.lastIndexOf("<");
        String neutralBye = byeWholeLine.substring(lineStart, lineEnd);

        Dialogue dialogue = new Dialogue(friendly, neutral);
        dialogue.setFriendlyBye(friendlyBye);
        dialogue.setNeutralBye(neutralBye);
        return dialogue;
    }

}
