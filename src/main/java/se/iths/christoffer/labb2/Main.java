package se.iths.christoffer.labb2;

public class Main {
    public static void main(String[] args) {
        Ui UiScanner = new UiScanner();
        WebshopManager open = new WebshopManager(UiScanner);

        open.openShop();


    }
}
