
public class Main {

    public static void main(String[] args) {
        // Test your app here
//        Warehouse warehouse = new Warehouse();
//        warehouse.addProduct("coffee", 5, 1);
//
//        System.out.println("stock:");
//        System.out.println("coffee:  " + warehouse.stock("coffee"));
//        System.out.println("sugar: " + warehouse.stock("sugar"));
//
//        System.out.println("taking coffee " + warehouse.take("coffee"));
//        System.out.println("taking coffee " + warehouse.take("coffee"));
//        System.out.println("taking sugar " + warehouse.take("sugar"));
//
//        System.out.println("stock:");
//        System.out.println("coffee:  " + warehouse.stock("coffee"));
//        System.out.println("sugar: " + warehouse.stock("sugar"));

        ShoppingCart cart = new ShoppingCart();
        cart.add("milk", 3);
        cart.print();
        System.out.println("cart price: " + cart.price() + "\n");

        cart.add("buttermilk", 2);
        cart.print();
        System.out.println("cart price: " + cart.price() + "\n");

        cart.add("milk", 3);
        cart.print();
        System.out.println("cart price: " + cart.price() + "\n");

        cart.add("milk", 3);
        cart.print();
        System.out.println("cart price: " + cart.price() + "\n");
    }
}
