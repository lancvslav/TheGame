package cz.vsb.ekf.lan0116.eventSystem.serverEvents.speech;

import cz.vsb.ekf.lan0116.eventSystem.serverEvents.ServerEvent;

import java.util.List;

public class SpeechLogServerEvent implements ServerEvent {
    List<SpeechResponse> speechLog;

    public SpeechLogServerEvent(List<SpeechResponse> speechLog) {
        this.speechLog = speechLog;
    }

    @Override
    public ServerEventType getType() {
        return ServerEventType.SPEECH;
    }

    public List<SpeechResponse> getSpeechLog() {
        return speechLog;
    }
}