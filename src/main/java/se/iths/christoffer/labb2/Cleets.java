package se.iths.christoffer.labb2;

public class Cleets extends Product {

    public Cleets(int articleNumber, String title, double price, String description) {
        super(articleNumber, title, price, description);

    }

    @Override
    public String category() {
        return "Fotbollsskor";
    }
}
