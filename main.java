import java.util.*;
class main {
    static HashMap<Integer, Double> user = new HashMap<>();
    public static void main(String[] args) {
        System.out.println("Program start");
        user.put(1234, 1000.00);
        user.put(5678, 500.00);
        ATM.run();
    }
}
