public class Rule {
    private String deviceName;
    private String time;
    private String action;

    public Rule(String deviceName, String time, String action) {
        this.deviceName = deviceName;
        this.time = time;
        this.action = action;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public String getTime() {
        return time;
    }

    public String getAction() {
        return action;
    }
    void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }
    void setTime(String time) {
        this.time = time;
    }
    void setAction(String action) {
        this.action = action;
    }
}