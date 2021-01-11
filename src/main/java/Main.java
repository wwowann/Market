import java.util.*;
import java.util.concurrent.TimeUnit;

import static java.lang.Integer.parseInt;

public class Main {
    public static int counter;

    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        boolean systemActivity = true;
        List<Product> list = new ArrayList<>();
        Map<Integer, List<Baskets>> buildProductBasket = new HashMap<>();
        //правило Magic - не использование значений переменных напрямую
        String nameProduct = "Салат китайский";
        int costProduct = 125;
        String nameProduct1 = "Тазик для салата";
        int costProduct1 = 425;
        String nameProduct2 = "Плитка \"Не надо марацца\"";
        int costProduct2 = 525;

        //создание объектов класса Продуктов с использованием фабрики
        ProductFactory factory = new ProductFactory();
        list.add(factory.getProduct(ProductType.FOOD_PRODUCTS, nameProduct,
                costProduct, Manufactured.FOREIGN, 4));
        list.add(factory.getProduct(ProductType.TABLEWARE, nameProduct1,
                costProduct1, Manufactured.DOMESTIC, 4));
        list.add(factory.getProduct(ProductType.PLUMBING, nameProduct2,
                costProduct2, Manufactured.DOMESTIC, 4));

        list.add(new FoodProducts("Хлеб белый", 55, Manufactured.DOMESTIC, 5));
        list.add(new FoodProducts("Молоко", 65, Manufactured.DOMESTIC, 5));
        list.add(new FoodProducts("Колбаса \"Останкинская\"", 260, Manufactured.DOMESTIC, 4));
        list.add(new FoodProducts("Яйца 1 сорт", 85, Manufactured.DOMESTIC, 4));
        list.add(new FoodProducts("Мясо индейки", 250, Manufactured.FOREIGN, 2));
        list.add(new FoodProducts("Сосиски бумажные", 120, Manufactured.FOREIGN, 2));
        list.add(new FoodProducts("Морской еж, филе", 700, Manufactured.FOREIGN, 3));
        list.add(new FoodProducts("Глаза кильки в томатном соусе", 40, Manufactured.FOREIGN, 1));
        list.add(new FoodProducts("Крабовое мясо минтая", 150, Manufactured.FOREIGN, 4));
        list.add(new FoodProducts("Свинные уши", 147, Manufactured.DOMESTIC, 4));
        list.add(new FoodProducts("Дырки от бублика с маком", 45, Manufactured.DOMESTIC, 1));
        list.add(new FoodProducts("Картоха, запеченная в куре", 180, Manufactured.DOMESTIC, 3));
        list.add(new FoodProducts("Березовый сок с мякотью", 55, Manufactured.DOMESTIC, 5));

        list.add(new Tableware("Ложка для полбу", 200, Manufactured.FOREIGN, 3));
        list.add(new Tableware("Сито для воды", 50, Manufactured.DOMESTIC, 4));
        list.add(new Tableware("Лапоть для щей", 100, Manufactured.DOMESTIC, 1));
        list.add(new Tableware("Тарелька", 10, Manufactured.FOREIGN, 1));
        list.add(new Tableware("Самовар для моей Маши", 1500, Manufactured.DOMESTIC, 5));
        list.add(new Tableware("Чайник для java", 750, Manufactured.FOREIGN, 3));
        list.add(new Tableware("Склеенная разбитая чаша", 120, Manufactured.FOREIGN, 2));
        list.add(new Tableware("Банка из-под селедки", 5, Manufactured.DOMESTIC, 2));
        list.add(new Tableware("Разбитое корыто", 1200, Manufactured.DOMESTIC, 4));

        list.add(new Plumbing("Утка для подкровати", 270, Manufactured.FOREIGN, 1));
        list.add(new Plumbing("Ванна с виниловым покрытием", 5270, Manufactured.FOREIGN, 3));
        list.add(new Plumbing("Лен сантехнический", 35, Manufactured.DOMESTIC, 5));
        list.add(new Plumbing("Раковина армированная", 4550, Manufactured.FOREIGN, 4));
        list.add(new Plumbing("Труба полипропиленовая", 240, Manufactured.DOMESTIC, 5));
        list.add(new Plumbing("Вентиль шаровый", 135, Manufactured.DOMESTIC, 2));
        list.add(new Plumbing("Джакузи", 7890, Manufactured.FOREIGN, 2));
        list.add(new Plumbing("Вода для труб", 105, Manufactured.DOMESTIC, 3));
        System.out.println("Добро пожаловать, покупатель!");

        List<Baskets> baskets;
        while (systemActivity) {
            System.out.println("Предлагается на выбор следующий сервис магазина товаров. Нажмите порядковый номер или \"0\" для выхода из программы:\n" +
                    "1. Вывод доступных для покупки товаров.\n" +
                    "2. Сортировака товаров по наименованию, цене, производителю или рейтингу\n" +
                    "3. Составление продуктовой корзины и формирование заказа\n" +
                    "4. Повторение заказа или возврат\n" +
                    "5. Трекинг заказа\n" +
                    "6. Перейти в систему рейтинга товаров\n" +
                    "7. Рекомендательная система");
            switch (parseInt(scan.nextLine())) {
                case 0:
                    System.out.println("До новых встреч!");
                    systemActivity = false;
                    break;
                case 1:
                    printListProducts(list);
                    break;
                case 2:
                    sortedProducts(scan, list);
                    break;
                case 3:
                    baskets = productBasketFormation(scan, list);
                    buildProductOrders(baskets, buildProductBasket);
                    break;
                case 4:
                    if (checkingBasketForNull(buildProductBasket)) break;
                    printAllOrders(buildProductBasket);
                    System.out.println("выберите по номеру заказ, который Вы хотите повторить или вернуть. " +
                            "Нажмите \"0\" для возврата в основное меню");
                    int value = parseInt(scan.nextLine().trim());
                    if (value == 0) break;
                    System.out.println("Вы хотите повторить \">>\" заказ или вернуть\"<<\"?");
                    createOrRemoteOrders(scan, value, buildProductBasket);
                    break;
                case 5:
                    if (checkingBasketForNull(buildProductBasket)) break;
                    trackingOrder(buildProductBasket);
                    break;
                case 6:
                    while (true) {
                        System.out.println("Выберете товар по номеру для оценки. " +
                                "Нажмите \"0\" для возврата в основное меню");
                        String valueString = scan.nextLine().trim();
                        if (parseInt(valueString) == 0) {
                            break;
                        } else if (parseInt(valueString) > list.size() || parseInt(valueString) < 1) {
                            System.out.println("Введите корректное значение от 1 до " + list.size());
                        }
                        System.out.println("Введите свою оценку данному товару от \"1\" до \"5\"");
                        int valuePating = Integer.parseInt(scan.nextLine().trim());
                        averageRating(findProductsInList(list, parseInt(valueString)), valuePating);
                    }
                    break;
                case 7:
                    if (checkingBasketForNull(buildProductBasket)) break;
                    recommndedProduct(buildProductBasket, list);
            }
        }
    }

    //правило DRY
    public static void printListProducts(List<Product> product) {
        int count = 0;
        for (Product prod : product) {
            count++;
            System.out.println(count + ". " + prod);
        }
    }

    public static void averageRating(Product product, double rating) {
        product.setRating((product.getRating() + rating) / 2);
    }

    public static void sortedProducts(Scanner scan, List<Product> list) {
        boolean menuActivity = true;
        while (menuActivity) {
            System.out.println("Введите тип сортировки или нажмите \"0\" для выхода:\n" +
                    "1. наименование товара\n" +
                    "2. стоимость товара\n" +
                    "3. производитель товара\n" +
                    "4. рейтинг товара");
            switch (parseInt(scan.nextLine())) {
                case 0:
                    menuActivity = false;
                    break;
                case 1:
                    sortedNameProducts(list);
                    break;
                case 2:
                    sortedCostProducts(list);
                    break;
                case 3:
                    sortedManufacturedProducts(list);
                    break;
                case 4:
                    sortedRatingProducts(list);
                    break;
            }
        }

    }

    public static void sortedNameProducts(List<Product> list) {
        SortedNameProducts sortedNameProducts = new SortedNameProducts();
        list.sort(sortedNameProducts);
        for (Product l : list) {
            System.out.println(l.toString());
        }
    }

    public static void sortedCostProducts(List<Product> list) {
        SortedCostProduct sortedCostProducts = new SortedCostProduct();
        list.sort(sortedCostProducts);
        for (Product l : list) {
            System.out.println(l.toString());
        }
    }

    public static void sortedManufacturedProducts(List<Product> list) {
        SortedManufacturedProduct sortedManufacturedProducts = new SortedManufacturedProduct();
        list.sort(sortedManufacturedProducts);
        for (Product l : list) {
            System.out.println(l.toString());
        }
    }

    public static void sortedRatingProducts(List<Product> list) {
        SortedRatingProduct sortedRatingProduct = new SortedRatingProduct();
        list.sort(sortedRatingProduct);
        for (Product l : list) {
            System.out.println(l.toString());
        }
    }

    public static List<Baskets> productBasketFormation(Scanner scan, List<Product> list) {
        List<Baskets> baskets = new ArrayList<>();
        while (true) {
            System.out.println("выберите продукты и их количество в формате, например: \"13 4\"," +
                    " где \"13\" - порядковый номер продукта, \"4\" - количество");
            String line = scan.nextLine().trim();
            if (line.equals("0")) {
                System.out.println("Ваша корзина:");
                if (baskets.isEmpty()) {
                    System.out.println("пуст");
                } else {
                    for (Baskets ord : baskets) {
                        System.out.println(ord.toString());
                    }
                    System.out.println("Общая стоимость корзины выбранных товаров составляет: "
                            + Baskets.globalCostOrders + " золотыми карбованцами\n");
                }
                System.out.println("Вы хотите продолжить формирование корзины" +
                        " или можно оформить заказ? Нажмите \"Y\" - \"да, продолжить\" или \"N\" - \"нет, оформить заказ\"");
                String value = scan.nextLine().trim();
                while (true) {

                    if (value.equals("N") || value.equals("n")
                            || value.equals("Y") || value.equals("y")
                            || value.equals("Т") || value.equals("т") ||
                            value.equals("Н") || value.equals("н")) {
                        break;
                    } else System.out.println("Введите корректное значение");
                    value = scan.nextLine();
                }

                if (value.equals("N") || value.equals("n")
                        || value.equals("т") || value.equals("Т")) {
                    System.out.println("Корзина собрана!\n");
                    break;

                } else
                    continue;

            } else {
                String[] value = line.split(" ");//здесь проверяется, если введен товар
                // без количества, то автоматически присваивается 1 штука товара
                int indexProduct = parseInt(value[0]);
                int quantity;
                if (value.length == 1) {
                    quantity = 1;
                } else quantity = parseInt(value[1]);
                baskets.add(findProductsInList(list, indexProduct, quantity));
            }
        }
        return baskets;
    }

    public static Baskets findProductsInList(List<Product> list, int value1, int quantity) {
        Baskets orders;
        Product prod;
        prod = findProductsInList(list, value1);
        int totalCost = prod.getCost() * quantity;
        orders = new Baskets(prod, quantity, totalCost);
        return orders;
    }

    public static Product findProductsInList(List<Product> list, int value1) {
        return list.get(value1 - 1);

    }


    public static void buildProductOrders(List<Baskets> baskets, Map<Integer, List<Baskets>> buildProductBaskets) {
        try {
            if (!baskets.isEmpty())
                createOrder(baskets, buildProductBaskets);
            for (Baskets b : baskets) {
                System.out.println(b.toString());
            }
            System.out.println("заказ №" + counter + " сформирован\n");
        } catch (NullPointerException e) {
            System.out.println("Корзина пуста, сформируйте сначала корзину товаров\n");
        }

    }

    public static void createOrder(List<Baskets> baskets, Map<Integer, List<Baskets>> buildProductBaskets) {
        counter++;
        buildProductBaskets.put(counter, baskets);

    }

    public static void printAllOrders(Map<Integer, List<Baskets>> buildProductBaskets) {
        System.out.println("Доступны заказы:");
        for (Map.Entry<Integer, List<Baskets>> obj : buildProductBaskets.entrySet()) {
            System.out.println(obj.toString());
        }
    }

    //применение паттерна Command для повтора заказа или отмены заказа
    public static void createOrRemoteOrders(Scanner scan, int value, Map<Integer, List<Baskets>> buildProductBasket) {
        DoUndoOrders doUndoOrders = new DoUndoOrders() {
        };
        while (true) {
            String valueString = scan.nextLine().trim();
            if (valueString.equals("<<")) {
                doUndoOrders.unOrder(value, buildProductBasket);
                break;
            } else if (valueString.equals(">>")) {
                doUndoOrders.doOrder(value, buildProductBasket);
                break;
            } else System.out.println("введите корректное значение");
        }
    }

    public static void trackingOrder(Map<Integer, List<Baskets>> buildProductBasket) throws InterruptedException {
        //создается экземпляр класса, который будет отвечать за всю логику трекинга заказа
        TrackingOrders trackingOrders = new TrackingOrders() {};
        trackingOrders.productInStock();
        TimeUnit.SECONDS.sleep(2);
        trackingOrders.approvalWaitingForDelivery();
        TimeUnit.SECONDS.sleep(2);
        trackingOrders.deliveryOfProductsToWareHouse();
        TimeUnit.SECONDS.sleep(2);
        trackingOrders.orderConfirmation();
        TimeUnit.SECONDS.sleep(2);
        trackingOrders.shipmentOfProductFromWareHouse();
        TimeUnit.SECONDS.sleep(2);
        trackingOrders.executionOfDocumentsForOrder();
        TimeUnit.SECONDS.sleep(2);
        trackingOrders.resultsOfOrderToCourier();
        TimeUnit.SECONDS.sleep(2);
        trackingOrders.approvalOfDeliveryTime();
        TimeUnit.SECONDS.sleep(2);
        trackingOrders.orderCompleted();
    }

    //Single-responsibility principle
// Принцип единственной ответственности - каждый делает только то, для чего он предназначен,
//    например, следующий метод проверяет пустой заказ или нет
    public static boolean checkingBasketForNull(Map<Integer, List<Baskets>> buildProductBasket) {
        if (buildProductBasket.isEmpty()) {
            System.out.println("Заказ не оформлен, для начала" +
                    " перейдите к формированию продуктовой корзины (пункт \"3\" в меню)\n");
            return true;
        } else return false;
    }

    public static void recommndedProduct(Map<Integer, List<Baskets>> buildProductBasket, List<Product> list) {
        int averageCostProduct = 0;
        List<Baskets> baskets = new ArrayList<>();
        for (Map.Entry<Integer, List<Baskets>> obj : buildProductBasket.entrySet()) {
            baskets.addAll(obj.getValue());
        }
        for (Baskets b : baskets) {
            averageCostProduct += b.getAveragePriceProduct();
        }
        int finalAverageCostProduct = averageCostProduct / baskets.size();
        System.out.println("Средняя стоимость товаров в Вашей покупке составляет: "
                + finalAverageCostProduct);
        System.out.println("Дополнительно мы рекомендуем Вам приобрести " +
                "следуюшщие товары в вашей ценовой категории (+/- 100 рублей:\n");

        list.stream()
                .filter(x -> x.getCost() >= (finalAverageCostProduct - 100))
                .filter(x -> x.getCost() <= (finalAverageCostProduct + 100))
                .forEach(System.out::println);
    }

}






