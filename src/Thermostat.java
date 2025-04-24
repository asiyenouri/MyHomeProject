public class Thermostat extends Device {
    private int temperature;

    public Thermostat(String name, String protocol) {
        super(name, protocol);
        this.temperature = 20;
    }

    @Override
    public String setProperty(String property, String value) {
        if (property.equals("status")) {
            return super.setProperty(property, value);
        } else if (property.equals("temperature")) {
            try {
                int b = Integer.parseInt(value);
                if (b >= 10 && b <= 30) {
                    temperature = b;
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
        return "thermostat: " + name + " " + status + " " + temperature + "C " + protocol;
    }
    public int getTemperature() {
        return temperature;
    }
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
}