class Solution {
    public int pivotIndex(int[] nums) {
        
        // https://leetcode.com/problems/find-pivot-index/

        int total = 0;
        int firstHalf = 0;
        
        for(int x : nums) total += x;
        
        for(int i = 0; i < nums.length; i++){
            
            if(firstHalf == total - firstHalf - nums[i]) return i;
            firstHalf += nums[i];
               
        }

        return -1;
    }
}