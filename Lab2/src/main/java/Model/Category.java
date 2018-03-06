package Model;

public class Category {

    public int id;
    public String name;
    public int categoryId;
    public double total = 0.0;

    public Category(int id, String name, int categoryId) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
    }
    

}