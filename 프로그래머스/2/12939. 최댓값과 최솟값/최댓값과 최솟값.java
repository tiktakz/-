import java.util.*;

class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ");

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for (String st : arr) {
            max = Math.max(max, Integer.parseInt(st));
            min = Math.min(min, Integer.parseInt(st));
        }
    
        StringBuilder sb = new StringBuilder();
        sb.append(min).append(" ").append(max);
        
        return sb.toString();
    }
}