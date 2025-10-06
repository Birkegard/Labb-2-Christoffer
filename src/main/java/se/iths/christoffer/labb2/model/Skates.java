package se.iths.christoffer.labb2.model;

public class Skates extends Product {

    public Skates(int articleNumber, String title, double price, String description) {
        super(articleNumber, title, price, description);

    }

    public Skates() {
        super(0, "", 0.0, "");
    }

    @Override
    public String category() {
        return "Skridskor";
    }
}
