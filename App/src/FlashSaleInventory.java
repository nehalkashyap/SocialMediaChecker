import java.util.*;

public class FlashSaleInventory {

    private HashMap<String, Integer> stock = new HashMap<>();
    private LinkedHashMap<Integer, String> waitingList = new LinkedHashMap<>();

    public FlashSaleInventory() {
        stock.put("IPHONE15_256GB", 100);
    }

    public synchronized void purchaseItem(String productId, int userId) {

        int available = stock.getOrDefault(productId, 0);

        if (available > 0) {
            stock.put(productId, available - 1);
            System.out.println("Success for user " + userId +
                    ", remaining: " + (available - 1));
        } else {
            waitingList.put(userId, productId);
            System.out.println("Added to waiting list user: " + userId);
        }
    }

    public void checkStock(String productId) {
        System.out.println(productId + " stock: " + stock.get(productId));
    }

    public static void main(String[] args) {
        FlashSaleInventory obj = new FlashSaleInventory();

        obj.checkStock("IPHONE15_256GB");

        obj.purchaseItem("IPHONE15_256GB", 101);
        obj.purchaseItem("IPHONE15_256GB", 102);
    }
}
