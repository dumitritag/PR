package Model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;


public class Order {
    private String id;
    private double total;
    private  int category_id;
    private Date created;


    public Order(String string) {
        int lastPosition = 0;
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < string.length(); i++) {
            if(string.charAt(i) == ','){
                list.add(string.substring(lastPosition, i));
                System.out.println(string);
                lastPosition = i+1;
            }
            if(i == string.length()-1){
                list.add(string.substring(lastPosition, i));
            }
        }
//d
        this.id = list.get(0);
        this.total = Double.parseDouble(list.get(1));
        this.category_id = Integer.parseInt(list.get(2));
        DateFormat format = new SimpleDateFormat("yyyy-mmm-dd");
        try {
            this.created = format.parse(list.get(3));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
