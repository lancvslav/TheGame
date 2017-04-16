package cz.vsb.ekf.lan0116.eventSystem.serverEvents.speech;

public class FriendlyBye implements SpeechResponse {

    private String bye;

    public FriendlyBye(String bye) {
        this.bye = bye;
    }

    public String getBye() {
        return bye;
    }

    @Override
    public SpeechResponseType getType() {
        return SpeechResponseType.FRIENDLY_BYE;
    }
}
