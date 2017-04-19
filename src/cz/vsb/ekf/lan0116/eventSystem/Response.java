package cz.vsb.ekf.lan0116.eventSystem;

import cz.vsb.ekf.lan0116.eventSystem.failures.FailureCause;

/**
 * Stands for outcome of Event triggered by player
 */
public class Response {

    public static final Response SUCCESS = new Response();
    private final boolean success;
    private final FailureCause failureCause;

    public Response() {
        this.success = true;
        this.failureCause = null;
    }

    public Response(FailureCause failureCause) {
        this.success = false;
        if (failureCause == null) {
            throw new IllegalArgumentException("Event failed, but cause not mentioned.");
        }
        this.failureCause = failureCause;
    }

    public boolean isSuccess() {
        return success;
    }

    public FailureCause getFailureCause() {
        return failureCause;
    }
}
