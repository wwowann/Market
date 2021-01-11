public class TrackingOrders {
    //товар в наличии
     public boolean productInStock() {
        System.out.println("Товар имеется в наличии");
        return true;
    }

    //согласование ожидания поставки

    public boolean approvalWaitingForDelivery() {
        System.out.println("Клиент согласен на ожидание поступления товара с другого склада");
        return true;
    }

    //поставка товара на склад
    public boolean deliveryOfProductsToWareHouse() {
        System.out.println("Товар доставлен на склад");
        return true;
    }

    //подтверждение заказа
    public boolean orderConfirmation() {
        System.out.println("Заказ подтвержден заказчиком");
        return true;
    }

    //отгрузка товара со склада
    public boolean shipmentOfProductFromWareHouse() {
        System.out.println("Товар отгружен со склада");
        return true;
    }

    //оформление документов по заказу
    public boolean executionOfDocumentsForOrder() {
        System.out.println("Документы по заказу оформлены");
        return true;
    }

    //выдача заказа курьеру
    public boolean resultsOfOrderToCourier() {
        System.out.println("Заказ передан курьеру");
        return true;
    }

    //согласование времени доставки
    public boolean approvalOfDeliveryTime() {
        System.out.println("Время доставки заказа согласовано с клиентом");
        return true;
    }

    //доставка заказа покупателю
    public boolean deliveryOfOrderToBuyer() {
        System.out.println("Заказ доставлен покупателю");
        return true;
    }

    //заказ выполнен
    public boolean orderCompleted() {
        System.out.println("Заказ выполнен");
        return true;
    }

    //заказ отменен или клиент отказался от заказа
    public boolean orderNonCompleted() {
        System.out.println("Заказ отменен");
        return true;
    }

}
