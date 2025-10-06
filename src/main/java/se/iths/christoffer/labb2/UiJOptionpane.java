package se.iths.christoffer.labb2;

import javax.swing.*;

public class UiJOptionpane implements Ui {
    @Override
    public String prompt(String message) {
        return JOptionPane.showInputDialog(null, message);

    }

    @Override
    public void info(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    @Override
    public String menu() {
        String choice = JOptionPane.showInputDialog(null, """
                Välkommen till Intrasport
                1. Lägg till en produkt.
                2. Visa hela sortimentet.
                3. Visa info om en produkt.
                4. Stäng applikationen.""");
        if (choice == null) {
            return "4";
        }
        return choice;
    }
}
