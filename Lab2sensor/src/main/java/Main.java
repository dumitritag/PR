import java.util.ArrayList;

public class Main extends Thread{
    public static void main(String[] args) {
        PostRequest request = new PostRequest();
        ArrayList<String> paths = request.getPaths();
        String key = request.getKey();

        Runnable runnable = new GetRequest(key,paths);
        for (int i = 0; i < paths.size(); i++) {
            Thread thread = new Thread(runnable);
            thread.setName(String.valueOf(i));
            thread.start();
        }
    }
}
