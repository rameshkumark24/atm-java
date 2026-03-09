import java.util.*;
class Main {
    static HashMap<Integer, Double> user = new HashMap<>();
    public static void main(String[] args) {
        user.put(1234, 1000.00);
        user.put(5678, 500.00);
        ATM.run();
    }
}
