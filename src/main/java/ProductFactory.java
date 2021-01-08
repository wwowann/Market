public class ProductFactory{
    public Product getProduct(ProductType type, String nameProduct, int costProduct,
                              Manufactured manufactured, int rating) {
        Product toReturn = null;
        switch (type){
            case FOOD_PRODUCTS:
                toReturn = new FoodProducts(nameProduct, costProduct, manufactured,rating);
                break;
            case PLUMBING:
                toReturn = new Plumbing(nameProduct, costProduct, manufactured,rating);
                break;
            case TABLEWARE:
                toReturn = new Tableware(nameProduct, costProduct, manufactured,rating);
                break;
            default:
                throw new IllegalArgumentException("неправильный тип продукта: " + type);

        }
        return toReturn;
    }
}
