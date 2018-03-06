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

    public static Category fromCSV(String csv, String delimiter) {
        String[] dates = csv.split(delimiter);
        int id = Integer.parseInt(dates[0]);
        String name = dates[1];
        int categoryId = dates.length == 2 ? null : Integer.parseInt(dates[2]);
        return new Category(id, name, categoryId);
    }

    @Override public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", categoryId=" + categoryId +
                ", total=" + total +
                '}';
    }

}