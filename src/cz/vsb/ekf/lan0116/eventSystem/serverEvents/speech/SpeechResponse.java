package cz.vsb.ekf.lan0116.eventSystem.serverEvents.speech;

public interface SpeechResponse {
    SpeechResponseType getType();

    enum SpeechResponseType {
        FRIENDLY,
        NEUTRAL,
        /**/;
    }
}
