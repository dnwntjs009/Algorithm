import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        int n = numbers.length;
        String[] nums = new String[numbers.length];
        
        for(int i = 0; i < n; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(nums, (o1, o2) -> (o2+o1).compareTo(o1+o2));
        
        if (nums[0].equals("0")) return "0";
        
        for(int i = 0; i < n; i++) {
            sb.append(nums[i]);
        }
        
        
        return sb.toString();
    }
}