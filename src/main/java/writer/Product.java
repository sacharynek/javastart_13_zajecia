package writer;

public class Product {

    private String name, producer;
    private double price;

    public Product() {
    }

    public Product(String name, String producer, double price) {
        this.name = name;
        this.producer = producer;
        this.price = price;
    }

    public static Product parseProduct(String line){
        String[] splittedLine = line.split(";");
        try {
            return new Product(splittedLine[0], splittedLine[1], Double.parseDouble(splittedLine[2]));
        }catch(NumberFormatException e){
            throw new TomaszException("cena produktu nie została poprawnie odczytana");

        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name + ';' + producer + ';' + price;

    }
}
