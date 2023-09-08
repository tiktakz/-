import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> hm = new HashMap<>();
        int n = sc.nextInt();
        for (int i=0; i<n; i++) {
            String name = sc.next();
            String work = sc.next();

            if (hm.containsKey(name)) {
                hm.remove(name);
            }
            else {
                hm.put(name, work);
            }
        }

        ArrayList<String> list = new ArrayList<>(hm.keySet());
        Collections.sort(list, Collections.reverseOrder());
        for (String s : list) {
            System.out.println(s);
        }
    }
}
