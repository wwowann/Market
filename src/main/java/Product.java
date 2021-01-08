import java.util.Comparator;

interface Product extends Comparator <Product> {
//    String goodsProductName = null;
//    int cost = 0;
//    Manufactured manufactured = null;
//    Rating rating = null;

//    String toString();

    String getGoodsProductName();

    int getCost();

    Manufactured getManufactured();

    double getRating();

    void  setRating(double rating);
}
