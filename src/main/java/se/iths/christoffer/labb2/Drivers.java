package se.iths.christoffer.labb2;

public class Golf extends Product {

    private String typeOfObject;

    public Golf(int articleNumber, String title, double price, String typeOfObject, String description) {
        super(articleNumber, title, price, description);
        this.typeOfObject = typeOfObject;
    }

    @Override
    public String category() {
        return typeOfObject;
    }
}
