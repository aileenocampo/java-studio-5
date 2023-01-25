import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Menu {
    private ArrayList<MenuItem> menuItems;
    public Menu(){
       menuItems = new ArrayList<>();
       MenuItem misoSoup = new MenuItem("Miso Soup", 5.99,
               "Authentic miso broth with tofu and mushrooms", "Appetizer");
       MenuItem salmonNigiri = new MenuItem("Salmon Nigiri", 10.99,
               "fresh salmon paired with rice and wasabi", "Entree");
       MenuItem vegetableRoll = new MenuItem("Vegetable Roll", 6.99,
               "Cucumber, avocado, and greens roll", "Entree");

       menuItems.add(misoSoup);
       menuItems.add(salmonNigiri);
       menuItems.add(vegetableRoll);
    }

    public void addItem(String name, double price, String description, String category) {
        MenuItem item = new MenuItem(name, price, description, category);
        menuItems.add(item);
    }

    public void removeItem(String name) {
        MenuItem item = null;
        for (int i = 0; i < menuItems.size(); i++) {
            if (getItem(name) != null) {
                item = getItem(name);
            }
        }

        if (item != null) {
            menuItems.remove(name);
            System.out.println(name + " was removed from menu!");
        }
        else {
            System.out.println("Oops " + name + " does not exist.");
        }
    }

    public MenuItem getItem(String name) {
        MenuItem item = null;
        for (int i = 0; i < menuItems.size(); i++) {
            if (menuItems.get(i).getName().equals(name)) {
                item = menuItems.get(i);
            }
        }
        return item;
    }

    public ArrayList<MenuItem> getItems() {
        return menuItems;
    }


    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String userInput;

        Menu menu = new Menu();

        System.out.println("Welcome to Temaki Den");

        do {
            System.out.println("\nOPTIONS");
            System.out.println("   1. View Menu");
            System.out.println("   2. Search for item");
            System.out.println("   3. Add item");
            System.out.println("   4. Remove item");
            System.out.println("   5. Check last menu update");
            System.out.print("Enter selection or 'q' to exit: ");

            userInput = scnr.nextLine();

            switch(userInput) {
                case "1":
                    for (int i = 0; i < menu.getItems().size(); i++) {
                        System.out.println(menu.getItems().get(i).toString());
                    }
                    break;
                case "2":
                    System.out.print("Enter menu item name:");
                    userInput = scnr.nextLine();
                    MenuItem item = menu.getItem(userInput);

                    if (item != null) {
                        System.out.println(item.toString());
                    }
                    else {
                        System.out.println(userInput + " is not in the menu.");
                    }
                    break;
                case "3":
                    String name;
                    double price;
                    String description;
                    String category;

                    System.out.print("Enter menu item name:");
                    name = scnr.nextLine();

                    System.out.print("Enter menu item price:");
                    price = scnr.nextDouble();

                    System.out.print("Enter menu item description:");
                    description = scnr.nextLine();

                    System.out.print("Enter menu item category:");
                    category = scnr.nextLine();

                    menu.addItem(name, price, description, category);
                    System.out.println(name + "was added to the menu");
                    break;
                case "4":
                    System.out.print("Enter menu item to remove: ");
                    userInput = scnr.nextLine();

                    menu.removeItem(userInput);
                case "5":
                    // not implemented
                    break;
                default:
                    System.out.println("Enter valid input");
            }

        } while (!Objects.equals(userInput, "q"));

    }
}
