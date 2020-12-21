class Solution {
    public int maxProfit(int[] prices) {

        // we can use kadanes algorithm here!
        // similar to "Maximum Sub Array" solution
        int globalMax = 0;
        int currentMax = 0;

        // start at one so we stay in bounds of the array
        for(int i = 1; i < prices.length; i++){

            currentMax = Math.max(0, currentMax + prices[i] - prices[i-1]);
            globalMax = Math.max(globalMax, currentMax);
        }
        return globalMax;
    }
}