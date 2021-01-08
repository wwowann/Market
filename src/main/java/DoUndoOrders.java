import java.util.List;
import java.util.Map;

public abstract class DoUndoOrders implements DoUndoOrder{

    @Override
    public boolean doOrder(int value, Map<Integer, List<Baskets>> buildProductBasket) {
        List<Baskets> baskets = buildProductBasket.get(value);
        Main.createOrder(baskets, buildProductBasket);
        return true;
    }

    @Override
    public boolean unOrder(int value, Map<Integer, List<Baskets>> buildProductBasket) {
        buildProductBasket.remove(value);
        return true;
    }
}
