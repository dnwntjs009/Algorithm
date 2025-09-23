import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> cool = new HashMap<>();
        for ( String[] cloth : clothes ) {
            cool.put(cloth[1], cool.getOrDefault(cloth[1], 0) + 1);
        }
        
        for ( int cnt : cool.values() ) {
            answer *= cnt + 1;
        }
        
        return answer-1;
    }
}