

import java.util.Arrays;
import java.util.Scanner;

class User implements Comparable<User> {
    int age;
    String name;
    int index;

    public User (int age, String name, int index) {
        this.name = name;
        this.age = age;
        this.index = index;
    }

    @Override
    public int compareTo(User other) {
        if (this.age == other.age) {
            return this.index - other.index;
        }
        return this.age - other.age;
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        User[] users = new User[n];
        for (int i=0; i<n; i++) {
            users[i] = new User(sc.nextInt(), sc.next(), i);
        }

        Arrays.sort(users);

        for (User u : users) {
            System.out.println(u.age + " " + u.name);
        }
    }
}
