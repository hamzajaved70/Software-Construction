package lab3;

public class Lab3 {

    public static void main(String[] args) {
        Restaurant rest = new Restaurant(11, 22);
        Order or = new Order(rest);
        or.orderSystem();
    }
}
