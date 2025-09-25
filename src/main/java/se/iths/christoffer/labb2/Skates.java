package se.iths.christoffer.labb2;

public class Icehockey extends Product {

    private String typeOfObject;


    public Icehockey(int articleNumber, String title, double price, String typeOfObject, String description) {
        super(articleNumber, title, price, description);
        this.typeOfObject = typeOfObject;
    }

    @Override
    public String category() {
        return typeOfObject;
    }
}
