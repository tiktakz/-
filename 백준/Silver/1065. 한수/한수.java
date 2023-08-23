import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    
	    int n = sc.nextInt();
	    
	    System.out.println(hansoo(n));
	}
	
	public static int hansoo(int N) {
	    int count = 0;
	    
	    if (N<100) {
	        count = N;
	        return count;
	    }
	    
	    
	    else {
	        count = 99;
	        
	        for (int i=100; i<=N; i++) {
	            int x = i / 100;
	            int y = (i/10) % 10;
	            int z = i%10;
	            
	            if ((x-y) == (y-z)) {
	                count += 1;
	            }
	        }
	    }
	    return count;
	}
}
