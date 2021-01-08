public interface Order {
    Product product = null;
//    int quantity = 0;
//    int totalCost = 0;
    void doOrder();
    void undoOrder();

}
