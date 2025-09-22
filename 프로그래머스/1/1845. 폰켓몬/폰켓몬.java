import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int n = nums.length / 2;
        
        if (set.size() >= n) answer = n;
        else if (set.size() < n) answer = set.size();
        
        return answer;
    }
}