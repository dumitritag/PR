import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class GetRequest implements Runnable{

    private String urlString = "https://desolate-ravine-43301.herokuapp.com";
    private String key;
    private ArrayList<String> paths;

    public GetRequest() {

    }

    public GetRequest(String key, ArrayList<String> paths) {
        this.key = key;
        this.paths = paths;
    }


    @Override
    public void run() {
        try {
            URL url = new URL(urlString+paths.get(Integer.parseInt(Thread.currentThread().getName())));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            System.out.println("Thread: "+Thread.currentThread().getName()+" Url: "+urlString+paths.get(Integer.parseInt(Thread.currentThread().getName())));

            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setRequestProperty("Accept", "text/csv");
            connection.setRequestProperty("session", key);
            InputStream content = connection.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(content));

            String line;
            while ((line = in.readLine()) != null) {
                if (line.startsWith("{")) {
                    JSON json = new JSON(line);
                    json.execute();
                } else if (line.startsWith("<")) {
                    XML xml = new XML(line);
                    xml.execute();
                } else {
                    if (!line.startsWith("device")&!line.startsWith("Yay")) {
                        CSV csv = new CSV(line);
                        csv.execute();
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
