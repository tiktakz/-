import java.util.*;

class Solution {
    int position;
    
    public boolean isBalanced(String str) {
        boolean flag = true;
        int right = 0;
        int left = 0;
        Stack<Character> stack = new Stack<Character>();
        
        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) == '(') {
                left++;
                stack.push('(');
            }
            else {
                right++;
                if (stack.isEmpty()) {
                    flag = false;
                }
                else {
                    stack.pop();
                }
            }
            if (left == right) {
                position = i + 1;
                return flag;
            }
        }
        return flag;
    }
    
    
    
    
    public String solution(String p) {
        if (p.isEmpty()) return p;
        
        boolean check = isBalanced(p);
        String u = p.substring(0, position);
        String v = p.substring(position, p.length());
        
        if (check) {
            return u + solution(v);
        }
        
        String answer = "(" + solution(v) + ")";
        for (int i=1; i<u.length()-1; i++) {
            if (p.charAt(i) == '(') {
                answer += ')';
            }
            else {
                answer += '(';
            }
        }        
        
        return answer;
        
    }
}