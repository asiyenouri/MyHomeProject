import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmartHome {
    private Map<String, Device> devices = new HashMap<>();
    private List<Rule> rules = new ArrayList<>();
    private List<String> deviceOrder = new ArrayList<>();

    public String addDevice(String type, String name, String protocol) {
        if (devices.containsKey(name)) return "duplicate device name";
        if (!type.equals("light") && !type.equals("thermostat")) return "invalid input";
        if (!protocol.equals("WiFi") && !protocol.equals("Bluetooth")) return "invalid input";

        Device device = type.equals("light") ?
                new Light(name, protocol) : new Thermostat(name, protocol);

        devices.put(name, device);
        deviceOrder.add(name);
        return "device added successfully";
    }

    public String setDevice(String name, String property, String value) {
        if (!devices.containsKey(name)) return "device not found";

        String result = devices.get(name).setProperty(property, value);
        if (result.equals("success")) return "device updated successfully";
        return result;
    }

    public String removeDevice(String name) {
        if (!devices.containsKey(name)) return "device not found";

        devices.remove(name);
        deviceOrder.remove(name);
        rules.removeIf(rule -> rule.getDeviceName().equals(name));
        return "device removed successfully";
    }

    public List<String> listDevices() {
        List<String> result = new ArrayList<>();
        if (devices.isEmpty()) {
            result.add("");
            return result;
        }

        for (String name : deviceOrder) {
            result.add(devices.get(name).getInfo());
        }
        return result;
    }

    public String addRule(String deviceName, String time, String action) {
        if (!devices.containsKey(deviceName)) return "device not found";
        if (!ValidTime(time)) return "invalid time";
        if (!action.equals("on") && !action.equals("off")) return "invalid action";

        for (Rule rule : rules) {
            if (rule.getDeviceName().equals(deviceName) && rule.getTime().equals(time)) {
                return "duplicate rule";
            }
        }

        rules.add(new Rule(deviceName, time, action));
        return "rule added successfully";
    }

    public String checkRules(String time) {
        if (!ValidTime(time)) return "invalid time";

        for (Rule rule : rules) {
            if (rule.getTime().equals(time)) {
                Device device = devices.get(rule.getDeviceName());
                if (device != null) {
                    device.setProperty("status", rule.getAction());
                }
            }
        }

        return "rules checked";
    }

    public List<String> listRules() {
        List<String> result = new ArrayList<>();
        if (rules.isEmpty()) {
            result.add("");
            return result;
        }

        for (Rule rule : rules) {
            result.add(rule.getDeviceName() + " " + rule.getTime() + " " + rule.getAction());
        }
        return result;
    }

    private boolean ValidTime(String time) {
        if (time.length() != 5 || time.charAt(2) != ':') return false;

        try {
            int hour = Integer.parseInt(time.substring(0, 2));
            int minute = Integer.parseInt(time.substring(3));
            return hour >= 0 && hour <= 23 && minute >= 0 && minute <= 59;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}