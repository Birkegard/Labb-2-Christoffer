package se.iths.christoffer.labb2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WebshopManager {
    Scanner sc = new Scanner(System.in);
    List<Product> productList;

    public WebshopManager() {
        productList = new ArrayList<>();
    }

    private void addProduct(Product product) {
        productList.add(product);
    }

    public void addSkates(int articlenumber, String title, double price, String description) {
        Product product = new Skates(articlenumber, title, price, description);
        addProduct(product);
    }

    public void addCleets(int articlenumber, String title, double price, String description) {
        Product product = new Cleets(articlenumber, title, price, description);
        addProduct(product);
    }

    public void addDriver(int articlenumber, String title, double price, String description) {
        Product product = new Drivers(articlenumber, title, price, description);
        addProduct(product);
    }

    public void setProductsAttribute() {
        System.out.println("Vilken typ av produkt ska läggas till? 1: Skridskor. 2: Fotbollsskor. 3: Driver.");
        int input = sc.nextInt();
        sc.nextLine();

        if (input < 1 || input > 3) {
            System.out.println("Felaktigt värde, försök igen.");
        } else {
            System.out.println("Skriv in artikelnummer: ");
            int articlenumber = sc.nextInt();
            sc.nextLine();
            System.out.println("Skriv in titel: ");
            String title = sc.nextLine();
            System.out.println("Skriv in pris: ");
            double price = sc.nextDouble();
            sc.nextLine();
            System.out.println("Skriv in modell: ");
            String model = sc.nextLine();

            switch (input) {
                case 1 -> {
                    addSkates(articlenumber, title, price, model);
                    System.out.println("Skridskor tillagt i produktlistan.");
                }
                case 2 -> {
                    addCleets(articlenumber, title, price, model);
                    System.out.println("Fotbollsskor tillagt i produktlistan.");
                }
                case 3 -> {
                    addDriver(articlenumber, title, price, model);
                    System.out.println("Driver tillagd i produktlistan.");
                }
            }
        }
    }

    public void showProductlist() {
        for (Product product : productList) {
            System.out.println("Artikelnummer " + product.getArticleNumber() + ":\n" +
                    product.getTitle() + " " + product.getDescription() + ", $" + product.getPrice() + " .");
        }
    }

    public void showProductInformation() {
        boolean found = false;

        System.out.println("Skriv in artikelnummer på produkten: ");
        int articlenumber = sc.nextInt();
        sc.nextLine();
        for (Product product : productList) {
            if (articlenumber == product.getArticleNumber()) {
                System.out.println(product.category() + "\n" + product.getTitle() + " " +
                        product.getDescription() + " $" + product.getPrice() + ".");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Produkten finns inte i sortimentet.");
        }
    }

    public void openShop() {
        boolean running = true;

        while (running) {
            System.out.println("\nVälkommen till Intrasport!");
            System.out.println("""
                    1. Lägg till en produkt.
                    2. Visa hela sortimentet.
                    3. Visa info om en produkt.
                    4. Stäng applikationen.""");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> setProductsAttribute();

                case 2 -> showProductlist();

                case 3 -> showProductInformation();

                case 4 -> {
                    System.out.println("Du stänger nu webbshopen.");
                    running = false;
                }
                default -> System.out.println("Fel inmatning, försök igen.");

            }
        }
    }
}


