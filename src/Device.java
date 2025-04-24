public class Device {
    protected String name;
    protected String protocol;
    protected String status;

    public Device(String name, String protocol) {
        this.name = name;
        this.protocol = protocol;
        this.status = "off";
    }
    public String setProperty(String property, String value) {
        if (property.equals("status")) {
            if (value.equals("on") || value.equals("off")) {
                status = value;
                return "success";
            }
            return "invalid value";
        }
        return "invalid property";
    }

    public String getInfo() {
        return "";
    }
    public String getName() {
        return name;
    }
    public String getProtocol() {
        return protocol;
    }
    public String getStatus() {
        return status;
    }
    void setName(String name) {
        this.name = name;
    }
    void setProtocol(String protocol) {
        this.protocol = protocol;
    }
    void setStatus(String status) {
        this.status = status;
    }
}