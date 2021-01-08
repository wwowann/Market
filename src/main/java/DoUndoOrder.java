import java.util.List;
import java.util.Map;

public interface DoUndoOrder {
    boolean doOrder(int value, Map<Integer, List<Baskets>> buildProductBasket);
    boolean unOrder(int value, Map<Integer, List<Baskets>> buildProductBasket);

}
