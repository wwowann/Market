import java.util.Comparator;

interface Product extends Comparator <Product> {
    String getGoodsProductName();

    int getCost();

    Manufactured getManufactured();

    double getRating();

    void  setRating(double rating);
}
