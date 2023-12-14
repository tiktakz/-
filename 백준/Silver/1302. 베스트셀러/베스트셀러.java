
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<String, Integer> books = new HashMap<>();
        for (int i=0; i<n; i++) {
            String bookName = sc.next();
            if (books.containsKey(bookName)) {
                books.put(bookName, books.get(bookName) + 1);
            }
            else {
                books.put(bookName, 1);
            }
        }


        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;

        for (Map.Entry<String,Integer> entry : books.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();

            if (value > maxValue || value == maxValue && key.compareTo(maxKey) < 0) {
                maxValue = value;
                maxKey = key;
            }
        }
        System.out.println(maxKey);
    }
}
