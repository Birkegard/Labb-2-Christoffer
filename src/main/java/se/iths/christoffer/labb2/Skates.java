package se.iths.christoffer.labb2;

public class Skates extends Product {

    public Skates(int articleNumber, String title, double price, String description) {
        super(articleNumber, title, price, description);

    }

    @Override
    public String category() {
        return "Skridskor";
    }
}
