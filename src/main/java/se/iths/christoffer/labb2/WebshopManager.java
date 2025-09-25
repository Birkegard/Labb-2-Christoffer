package se.iths.christoffer.labb2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Webshop {

    public void openShop() {
        Scanner sc = new Scanner(System.in);
        List<Product> products = new ArrayList<>();

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
}
