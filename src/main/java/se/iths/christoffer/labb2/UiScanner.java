package se.iths.christoffer.labb2;

import java.util.Scanner;

public class UiScanner implements Ui {
    Scanner sc = new Scanner(System.in);

    @Override
    public String prompt(String message) {
        System.out.println(message);

        return sc.nextLine();
    }

    @Override
    public void info(String message) {
        System.out.println(message);

    }

    @Override
    public String menu() {
        System.out.println("\nVälkommen till Intrasport!");
        System.out.println("""
                1. Lägg till en produkt.
                2. Visa hela sortimentet.
                3. Visa info om en produkt.
                4. Stäng applikationen.""");

        return sc.nextLine();
    }
}
