

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static class SerialNumber implements Comparable<SerialNumber> {
        String serial;
        int sum;

        SerialNumber(String serial) {
            this.serial = serial;
        }

        @Override
        public int compareTo(SerialNumber other) {
            if (this.serial.length() != other.serial.length()) {
                return this.serial.length() - other.serial.length();
            }
            else if (this.serial.length() == other.serial.length()) {
                int thisSerial = doSum(this.serial);
                int otherSerial = doSum(other.serial);
                if (thisSerial == otherSerial) {
                    return this.serial.compareTo(other.serial);
                }
                else {
                    return thisSerial - otherSerial;
                }
            }
            return this.serial.compareTo(other.serial);
        }

        public int doSum(String serial) {
            int sum = 0;
            char[] serialChar = serial.toCharArray();
            for (int i=0; i<serial.length(); i++) {
                if (Character.isDigit(serialChar[i])) {
                    sum += serialChar[i] - '0';
                }
            }
            return sum;
        }

        @Override
        public String toString() {
            return this.serial;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        SerialNumber[] serials = new SerialNumber[n];
        for (int i=0; i<n; i++) {
            serials[i] = new SerialNumber(sc.nextLine());
        }
        Arrays.sort(serials);
        for (SerialNumber s : serials) {
            System.out.println(s);
        }
    }
}
