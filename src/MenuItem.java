import java.time.LocalDate;
import java.util.Date;

public class MenuItem {
    private String name;
    private double price;
    private String description;
    private String category;

    private LocalDate added;

    public MenuItem(String name, double price, String description, String category) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
        this.added = LocalDate.now();
    }

    @Override
    public String toString() {
        return category + ": " + name + " - " + description + " | " + price;
    }


}
