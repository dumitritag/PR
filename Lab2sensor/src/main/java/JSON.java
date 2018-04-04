import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSON {
    private String string;

    public JSON(String string)  {
        this.string = string;

    }

    public void execute() throws ParseException {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(string);
        Long type =  (Long) jsonObject.get("sensor_type");
        int typeCase = Integer.parseInt(String.valueOf(type));
        switch (typeCase) {
            case 0:
            {
                System.out.println("Temperature:");
                String id = (String) jsonObject.get("device_id");
                Double value =  (Double) jsonObject.get("value");
                System.out.println("Device: " + id + " - " + value+" °C");
                System.out.println();
                break;
            }
            case 1:
            {
                System.out.println("Humidity");
                String id = (String) jsonObject.get("device_id");
                Double value =  (Double) jsonObject.get("value");
                System.out.println("Device: " + id + " - " + value);
                System.out.println();
                break;
            }
            case 2:
            {
                System.out.println("Motion");
                String id = (String) jsonObject.get("device_id");
                Double value =  (Double) jsonObject.get("value");
                System.out.println("Device: " + id + " - " + value + " m/s");
                System.out.println();
                break;
            }
            case 3:
            {
                System.out.println("Alien Presence");
                String id = (String) jsonObject.get("device_id");
                Double value = (Double) jsonObject.get("value");
                System.out.println("Device: " + id + " - " + value);
                System.out.println();
                break;
            }
            case 4:
            {
                System.out.println("Dark Matter");
                String id = (String) jsonObject.get("device_id");
                Double value = (Double) jsonObject.get("value");
                System.out.println("Device: " + id + " - " + value);
                System.out.println();
                break;
            }
        }
    }
}

