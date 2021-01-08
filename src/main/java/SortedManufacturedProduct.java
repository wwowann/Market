import java.util.Comparator;

public class SortedManufacturedProduct implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        return o1.getManufactured().compareTo(o2.getManufactured());

    }
}
