/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.util;

public class NetworkState {
    public static final NetworkState LOADED = new NetworkState(Status.SUCCESS, "Success");
    public static final NetworkState LOADING = new NetworkState(Status.RUNNING, "Running");
    private final String msg;
    private final Status status;

    public NetworkState(Status status, String string2) {
        this.status = status;
        this.msg = string2;
    }

    public String getMsg() {
        return this.msg;
    }

    public Status getStatus() {
        return this.status;
    }

    public static final class Status
    extends Enum<Status> {
        private static final /* synthetic */ Status[] $VALUES;
        public static final /* enum */ Status FAILED;
        public static final /* enum */ Status RUNNING;
        public static final /* enum */ Status SUCCESS;

        static {
            Status status;
            RUNNING = new Status();
            SUCCESS = new Status();
            FAILED = status = new Status();
            Status[] arrstatus = new Status[]{RUNNING, SUCCESS, status};
            $VALUES = arrstatus;
        }

        public static Status valueOf(String string2) {
            return (Status)Enum.valueOf(Status.class, (String)string2);
        }

        public static Status[] values() {
            return (Status[])$VALUES.clone();
        }
    }

}

