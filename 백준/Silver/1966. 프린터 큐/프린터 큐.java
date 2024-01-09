

import java.util.*;

class Document {
    int index;
    int importance;

    Document(int index, int importance) {
        this.index = index;
        this.importance = importance;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int i=0; i<tc; i++) {
            int numOfDocs = sc.nextInt();
            int indexDoc = sc.nextInt();
            Integer[] seq = new Integer[numOfDocs];
            Queue<Document> q = new LinkedList<>();
            for (int j = 0; j < numOfDocs; j++) {
                seq[j] = sc.nextInt();
                q.offer(new Document(j, seq[j]));
            }
            Arrays.sort(seq, Collections.reverseOrder());
            findIndex(q, seq, indexDoc, numOfDocs);
        }
    }

    public static void findIndex(Queue<Document> q, Integer[] seq, int indexDoc, int numOfDocs) {
        for (int i=0; i<numOfDocs; i++) {
            while (q.peek().importance != seq[i]) {
                q.offer(q.poll());
            }
            if (q.peek().index == indexDoc) {
                System.out.println(i + 1);
                break;
            }
            q.poll();
        }
    }
}
