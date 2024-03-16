package product;

// Todos os atributos de ProductModel devem ser privados.
public class ProductModel {
    private String barCode;
    private String name;
    private int priceInCents;
    private int stock;

    // Construtor
    public ProductModel(String barCode, String name, int priceInCents, int stock) {
        this.barCode = barCode;
        this.name = name;
        this.priceInCents = priceInCents;
        this.stock = stock;
    }

    // Getters e Setters
    // Todos os atributos devem ter getters e setters, a única exceção é o atributo barCode, que deve conter apenas o getter.
    public String getBarCode() {
        return barCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriceInCents() {
        return priceInCents;
    }

    public void setPriceInCents(int priceInCents) {
        this.priceInCents = priceInCents;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}