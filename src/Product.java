public class Product {
    String bcode;
    String title;
    Integer quantify;
    double price;
    public Product() {

    }

    /**

     * Constructor method to initialize a product

     *

     * @param bcode    Product's bar code

     * @param title    Product's title

     * @param quantity Product's quantity

     * @param price    Product's price

     */

    public Product(String bcode, String title, Integer quantity, double price) {
        this.bcode = bcode;
        this.title = title;
        this.quantify = quantity;
        this.price = price;
    }

    public String getBcode() {
        return bcode;
    }

    public void setBcode(String bcode) {
        this.bcode = bcode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getQuantify() {
        return quantify;
    }

    public void setQuantify(Integer quantify) {
        this.quantify = quantify;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    /**

     * Convert this product to String for printing

     */

    @Override
    public String toString() {
        return "Product{" +
                "bcode='" + bcode + '\'' +
                ", title='" + title + '\'' +
                ", quantify=" + quantify +
                ", price=" + price +
                '}';
    }
}
