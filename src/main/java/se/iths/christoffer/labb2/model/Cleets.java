package se.iths.christoffer.labb2.model;

public class Cleets extends Product {

    public Cleets(int articleNumber, String title, double price, String description) {
        super(articleNumber, title, price, description);

    }

    public Cleets() {
        super(0, "", 0.0, "");
    }

    @Override
    public String category() {
        return "Fotbollsskor";
    }
}
