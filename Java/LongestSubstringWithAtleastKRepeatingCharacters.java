class Solution {
    public int longestSubstring(String s, int k) {
        return utilFunction(0, s.length(), k, s);
    }

    private int utilFunction(int start, int end, int k, String s){
        
        if(end < k) return 0;
        int[] countArray = new int[26];
        
        for(int begin = start; begin < end; begin++)
            countArray[s.charAt(begin) - 'a']++;

        for(int mid = start; mid < end; mid++){

            if(countArray[s.charAt(mid) - 'a'] >= k) continue;
            
            return Math.max(utilFunction(start, mid, k, s), utilFunction(mid+1, end, k, s));
        }

        return (end - start);
    }
}