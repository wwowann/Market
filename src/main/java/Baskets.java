public class Baskets implements Order {
    private Product product;
    final int quantity;
    final int totalCost;
    private int averagePriceProduct;
    static int globalCostOrders;
    private int count;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getGlobalCostOrders(int totalCost) {
        return globalCostOrders += totalCost;
    }

    public int getAveragePriceProduct() {
        return averagePriceProduct / count;
    }


    public Baskets(Product product, int quantity, int totalCost) {
        this.product = product;
        this.quantity = quantity;
        this.totalCost = totalCost;
        globalCostOrders = getGlobalCostOrders(totalCost);
        this.averagePriceProduct += product.getCost();
        count++;
    }

    @Override
    public String toString() {
        return product +
                ", количество: " + quantity +
                ", общая стоимость: " + totalCost;
    }

    @Override
    public void doOrder() {

    }

    @Override
    public void undoOrder() {

    }
}
