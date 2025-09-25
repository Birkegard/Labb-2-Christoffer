package se.iths.christoffer.labb2;

public class Drivers extends Product {

    public Drivers(int articleNumber, String title, double price, String description) {
        super(articleNumber, title, price, description);

    }

    @Override
    public String category() {
        return "Driver";
    }
}
