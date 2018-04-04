public class CSV {
    private String string;

    public CSV(String string) {
        this.string = string;
    }

    public void execute() {

        String cvsSplitBy = ",";

        String[] sensors = string.split(cvsSplitBy);
        int typeCase = Integer.parseInt(sensors[1]);
        switch (typeCase) {
            case 0:
            {
                System.out.println("Temperature:");
                System.out.println("Device: " + sensors[0] + " - " + sensors[2]+" °C");
                System.out.println();
                break;
            }
            case 1:
            {
                System.out.println("Humidity");
                System.out.println("Device: " + sensors[0] + " - " + sensors[2]);
                System.out.println();
                break;
            }
            case 2:
            {
                System.out.println("Motion");
                System.out.println("Device: " + sensors[0] + " - " + sensors[2] + " m/s");
                System.out.println();
                break;
            }
            case 3:
            {
                System.out.println("Alien Presence");
                System.out.println("Device: " + sensors[0] + " - " + sensors[2]);
                System.out.println();
                break;
            }
            case 4:
            {
                System.out.println("Dark Matter");
                System.out.println("Device: " + sensors[0] + " - " + sensors[2]);
                System.out.println();
                break;
            }
        }

    }
}