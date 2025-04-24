import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        SmartHome system = new SmartHome();
        int q = Integer.parseInt(scn.nextLine());

        for (int i = 0; i < q; i++) {
            String line = scn.nextLine();
            String[] parts = line.split(" ");
            String command = parts[0];

            if (command.equals("add_device")) {
                System.out.println(system.addDevice(parts[1], parts[2], parts[3]));
            }
            else if (command.equals("set_device")) {
                System.out.println(system.setDevice(parts[1], parts[2], parts[3]));
            }
            else if (command.equals("remove_device")) {
                System.out.println(system.removeDevice(parts[1]));
            }
            else if (command.equals("list_devices")) {
                for (String info : system.listDevices()) {
                    System.out.println(info);
                }
            }
            else if (command.equals("add_rule")) {
                System.out.println(system.addRule(parts[1], parts[2], parts[3]));
            }
            else if (command.equals("check_rules")) {
                System.out.println(system.checkRules(parts[1]));
            }
            else if (command.equals("list_rules")) {
                for (String rule : system.listRules()) {
                    System.out.println(rule);
                }
            }
        }
    }
}