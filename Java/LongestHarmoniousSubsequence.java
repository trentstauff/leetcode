class Solution {
    public int findLHS(int[] nums) {
        
        if(nums.length == 1) return 0;
        
        int result = 0;
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int n : nums)
        {
            if(map.containsKey(n))
            {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
            
            if(map.containsKey(n-1))
                result = Math.max(result, map.get(n) + map.get(n-1));
            
            if(map.containsKey(n+1))
                result = Math.max(result, map.get(n) + map.get(n+1));
        }
        
        return result;
    }
}