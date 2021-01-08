import java.util.Comparator;

public class SortedNameProducts implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        return o1.getGoodsProductName().compareTo(o2.getGoodsProductName());

    }
}
