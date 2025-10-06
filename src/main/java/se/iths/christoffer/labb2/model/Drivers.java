package se.iths.christoffer.labb2.model;

public class Drivers extends Product {

    public Drivers(int articleNumber, String title, double price, String description) {
        super(articleNumber, title, price, description);

    }

    public Drivers() {
        super(0, "", 0.0, "");
    }

    @Override
    public String category() {
        return "Driver";
    }
}
