import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
public class PostRequest {
    private String urlString="https://desolate-ravine-43301.herokuapp.com";
    private ArrayList<String> paths;
    private String key;

    public PostRequest() {


        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Accept", "text/csv");
            InputStream content = connection.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(content));

            key = connection.getHeaderField(3);
            String line = in.readLine();

            int firstIndex = 0;
            int lastIndex;
            paths = new ArrayList<>();
            while (firstIndex != line.length() - 3) {

                firstIndex = line.indexOf('/', firstIndex);
                lastIndex = line.indexOf('"', firstIndex);
                paths.add(line.substring(firstIndex, lastIndex));
                firstIndex = lastIndex;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ArrayList<String> getPaths() {
        return paths;
    }

    public String getKey() {
        return key;
    }
}

