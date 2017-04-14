package cz.vsb.ekf.lan0116.eventSystem.serverEvents.speech;

public interface SpeechResponse {
    SpeechResponse getType();

    enum SpeechResponseType {
        FRIENDLY,
        NEUTRAL,
        /**/;
    }
}
