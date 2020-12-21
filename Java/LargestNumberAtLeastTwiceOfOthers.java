class Solution {
    public int dominantIndex(int[] nums) {
        
        // https://leetcode.com/problems/largest-number-at-least-twice-of-others/

        int max = 0;
        int secondMax = 0;
        int maxIndex = 0;
    
        // get the two biggest numbers
        
        for(int i = 0; i < nums.length; i++){
            
            int x = nums[i];
            
            if(x > max){
                secondMax = max;
                maxIndex = i;
                max = x;
            } else if (x > secondMax){
                secondMax = x;
            }
        }
        
        // if second largest number isn't greater than the largest,
        // then any of the other numbers cannot be larger either.

        return (max >= secondMax * 2 ? maxIndex : -1);
        
    }
}