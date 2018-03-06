package Http;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class HttpRequest {
    private String url;
    private String key;
    private ArrayList<String> list;
    public HttpRequest(String url, String key) {
        this.url = url;
        this.key = key;
        list = new ArrayList<>();
    }

    public ArrayList<String> getData(){
        try {
            URL url = new URL(this.url);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//conection
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setRequestProperty("Accept", "text/csv");
            connection.setRequestProperty("x-api-key", key);
            InputStream content = (InputStream) connection.getInputStream();
            BufferedReader in =
                    new BufferedReader(new InputStreamReader(content));
            String line;
            // Thread.sleep(9000);
            while ((line = in.readLine()) != null) {
                list.add(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
