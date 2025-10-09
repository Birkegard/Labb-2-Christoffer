package se.iths.christoffer.labb2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import se.iths.christoffer.labb2.model.Cleets;
import se.iths.christoffer.labb2.model.Drivers;
import se.iths.christoffer.labb2.model.Product;
import se.iths.christoffer.labb2.model.Skates;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class WebshopManager {
    private ArrayList<Product> productList;
    private Ui ui;
    ObjectMapper mapper;

    public WebshopManager(Ui ui, ObjectMapper mapper) {
        this.ui = ui;
        this.mapper = mapper;

        File file = new File("Productlist.json");

        if (file.exists() && file.length() > 0) {
            try {
                productList = mapper.readValue(file, mapper.getTypeFactory()
                        .constructCollectionType(ArrayList.class, Product.class));
                ui.info("Läste in produkter från fil: " + productList.size());
            } catch (IOException e) {
                ui.info("Kunde inte läsa in produktlistan: " + e.getMessage());
                productList = new ArrayList<>();
            }
        } else {
            ui.info("Ingen fil hittades eller filen var tom.");
            productList = new ArrayList<>();
        }
    }

    private void addProduct(Product product) {
        productList.add(product);
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("Productlist.json"), productList);
        } catch (IOException e) {
            ui.info("Problem med filen: " + e.getMessage());
        }
    }

    public void addSkates(int articlenumber, String title, double price, String description) {
        Product product = new Skates(articlenumber, title, price, description);
        addProduct(product);
    }

    public void addCleets(int articlenumber, String title, double price, String description) {
        Product product = new Cleets(articlenumber, title, price, description);
        addProduct(product);
    }

    public void addDriver(int articlenumber, String title, double price, String description) {
        Product product = new Drivers(articlenumber, title, price, description);
        addProduct(product);
    }

    public void setProductsAttribute() {
        String input = ui.prompt("Vilken typ av produkt ska läggas till? 1: Skridskor. 2: Fotbollsskor. 3: Driver.");

        if (input.equals("1") || input.equals("2") || input.equals("3")) {
            String articlenumberInput = ui.prompt("Skriv in artikelnummer: ");
            int articlenumber = 0;
            try {
                articlenumber = Integer.parseInt(articlenumberInput);
            } catch (NumberFormatException e) {
                ui.info("Invalid input");
            }

            String title = ui.prompt("Skriv in titel: ");

            String priceinput = ui.prompt("Skriv in pris: ");
            double price = 0;
            try {
                price = Double.parseDouble(priceinput);
            } catch (NumberFormatException e) {
                ui.info("Invalid input");
            }

            String model = ui.prompt("Skriv in modell: ");

            switch (input) {
                case "1" -> {
                    addSkates(articlenumber, title, price, model);
                    ui.info("Skridskor tillagt i produktlistan.");
                }
                case "2" -> {
                    addCleets(articlenumber, title, price, model);
                    ui.info("Fotbollsskor tillagt i produktlistan.");
                }
                case "3" -> {
                    addDriver(articlenumber, title, price, model);
                    ui.info("Driver tillagd i produktlistan.");
                }
            }
        } else {
            ui.info("Felaktigt värde, försök igen.");
        }
    }

    public void showProductlist() {
        try {
            ui.info(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(productList));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    // }

    public void showProductInformation() {
        boolean found = false;

        String articlenumberInput = ui.prompt("Skriv in artikelnummer på produkten: ");
        int articlenumber = 0;
        try {
            articlenumber = Integer.parseInt(articlenumberInput);
        } catch (NumberFormatException e) {
            ui.info("Invalid input");
        }

        for (Product product : productList) {
            if (articlenumber == product.getArticleNumber()) {
                ui.info(product.category() + "\n" + product.getTitle() + " " +
                        product.getDescription() + " $" + product.getPrice() + ".");
                found = true;
                break;
            }
        }
        if (!found) {
            ui.info("Produkten finns inte i sortimentet.");
        }
    }

    public void openShop() {
        boolean running = true;

        while (running) {
            String choice = ui.menu();

            switch (choice) {
                case "1" -> setProductsAttribute();

                case "2" -> showProductlist();

                case "3" -> showProductInformation();

                case "4" -> {
                    ui.info("Du stänger nu webbshopen.");
                    running = false;
                }
                default -> ui.info("Fel inmatning, försök igen.");

            }
        }
    }
}


