import java.util.ArrayList;

public class Menu {
    public static void main(String[] args) {
        System.out.println("Welcome to Temaki Den");
        ArrayList menuItems = new ArrayList<>();

        MenuItem salmonNigiri = new MenuItem("Salmon Nigiri", 10.99,
                "fresh salmon paired with rice and wasabi", "Entree");
        menuItems.add(salmonNigiri);

        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println(menuItems.get(i).toString());
        }

    }
}
