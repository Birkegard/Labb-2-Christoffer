import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Product> products = getProducts();

        System.out.println("Välkommen till vår webbshop!");
        System.out.println("För att lägga till en produkt, tryck 1!");
        System.out.println("För att se hela sortimentet, tryck 2!");
        System.out.println("För att visa info om en produkt, tryck 3!");
        System.out.println("För att stänga shoppen, tryck 4!");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:
                System.out.println("Du valde lägga till en produkt.");
                
                break;
            case 2:
                for (Product product : products) {
                    System.out.println("Artikelnummer: " + product.getArticleNumber() + "\n" +
                            product.getTitle() + " $" + product.getPrice() + " " + product.getDescription());
                }
                break;
            case 3:
                System.out.println("Då");
                break;
            case 4:
                System.out.println("Du stänger nu webbshopen.");
                break;
        }
    }

    private static List<Product> getProducts() {
        List<Product> products = new ArrayList<>();

        Icehockey skate1 = new Icehockey(1, "Bauer", 19.99, "Skridsko", "Skridsko");
        Icehockey skate2 = new Icehockey(2, "CCM", 18.99, "Skridsko", "Skridsko");
        Football cleet1 = new Football(3, "Adidas", 10.99, "Fotbollssko", "Fotbollssko");
        Football cleet2 = new Football(4, "Nike", 8.99, "Fotbollssko", "Fotbollssko");
        Golf driver1 = new Golf(5, "Cobra", 49.99, "Fotbollssko", "Driver");
        Golf driver2 = new Golf(6, "Ping", 39.99, "Fotbollssko", "Driver");


        products.add(skate1);
        products.add(skate2);
        products.add(cleet1);
        products.add(cleet2);
        products.add(driver1);
        products.add(driver2);
        return products;
    }
}
