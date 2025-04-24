public class Light extends Device {
    private int brightness;

    public Light(String name, String protocol) {
        super(name, protocol);
        this.brightness = 50;
    }

    @Override
    public String setProperty(String property, String value) {
        if (property.equals("status")) {
            return super.setProperty(property, value);
        } else if (property.equals("brightness")) {
            try {
                int a = Integer.parseInt(value);
                if (a >= 0 && a <= 100) {
                    brightness = a;
                    return "success";
                }
                return "invalid value";
            } catch (NumberFormatException e) {
                return "invalid value";
            }
        }
        return "invalid property";
    }

    @Override
    public String getInfo() {
        return name + " " + status + " " + brightness + "% " + protocol;
    }
    public int getBrightness() {
        return brightness;
    }
    void setBrightness(int brightness) {
        this.brightness = brightness;
    }
}