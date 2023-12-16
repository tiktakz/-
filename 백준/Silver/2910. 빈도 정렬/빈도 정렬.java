
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        Map<Integer, Integer> hm = new LinkedHashMap<>();
        for (int i=0; i<n; i++) {
            int value = sc.nextInt();
            hm.put(value, hm.getOrDefault(value, 0) + 1);
        }

        Integer[] frequency = hm.keySet().toArray(new Integer[hm.size()]);
        Arrays.sort(frequency, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return hm.get(o2) - hm.get(o1);
            }
        });

        for (int i : frequency) {
            int count = hm.get(i);
            while (count-- > 0) {
                System.out.print(i + " ");
            }
        }
    }
}
