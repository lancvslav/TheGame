package cz.vsb.ekf.lan0116.eventSystem.serverEvents.speech;

public class NeutralBye implements SpeechResponse {

    private String bye;

    public NeutralBye(String bye) {
        this.bye = bye;
    }

    public String getBye() {
        return bye;
    }

    @Override
    public SpeechResponseType getType() {
        return SpeechResponseType.NEUTRAL_BYE;
    }
}
