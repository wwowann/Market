class FoodProducts implements Product {
    private String goodsProductName;
    private int cost;
    private Manufactured manufactured;
    private double rating;

    public String getGoodsProductName() {
        return goodsProductName;
    }

    public void setGoodsProductName(String goodsProductName) {
        this.goodsProductName = goodsProductName;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Manufactured getManufactured() {
        return manufactured;
    }

    public void setManufactured(Manufactured manufactured) {
        this.manufactured = manufactured;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "наименование: " + goodsProductName +
                ", стоимость: " + cost +
                ", производитель: " + manufactured.getName() +
                ", рейтинг: " + rating;
    }

    public FoodProducts(String goodsProductName, int cost, Manufactured manufactured, int rating) {
        this.goodsProductName = goodsProductName;
        this.cost = cost;
        this.manufactured = manufactured;
        this.rating = rating;
    }

    @Override
    public int compare(Product o1, Product o2) {
        return 0;
    }


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        FoodProducts that = (FoodProducts) o;
//        return cost == that.cost &&
//                goodsProductName.equals(that.goodsProductName) &&
//                manufactured == that.manufactured &&
//                rating == that.rating;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(goodsProductName, cost, manufactured, rating);
//    }


}
