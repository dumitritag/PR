package Main;

import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        String url1 = "https://evil-legacy-service.herokuapp.com/api/v101/orders/?start=2017-09-01&end=2017-10-03";
        String key = "55193451-1409-4729-9cd4-7c65d63b8e76";
        ArrayList<String> orders;

        Http.HttpRequest request1 = new Http.HttpRequest(url1, key);
        orders = request1.getData();

        for (int i = 0; i < orders.size(); i++) {
            System.out.println(orders.get(i));
        }

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ArrayList<Model.Order> ordersList = new ArrayList<>();
        for (int i = 2; i < orders.size(); i++) {
            ordersList.add(new Model.Order(orders.get(i)));
        }

        for (int i = 0; i < ordersList.size(); i++) {
            System.out.println(ordersList.get(i));
        }
        System.out.println("1 size" + orders.size() + "2 lista" + ordersList.size());



    }
}
