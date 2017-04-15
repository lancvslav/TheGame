package cz.vsb.ekf.lan0116.eventSystem.serverEvents.speech;

public class NeutralSpeech implements SpeechResponse {

    private String speech;

    public NeutralSpeech(String speech) {
        this.speech = speech;
    }

    public String getSpeech() {
        return speech;
    }

    @Override
    public SpeechResponseType getType() {
        return SpeechResponseType.NEUTRAL;
    }
}
