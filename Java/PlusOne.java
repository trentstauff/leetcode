class Solution {
    public int[] plusOne(int[] digits) {
        
        // https://leetcode.com/problems/plus-one

        int curr = digits.length - 1;
        
        while(true){
            
            if(curr == -1){
                int[] solution = new int[digits.length+1];
                System.arraycopy(digits, 0, solution, 1, solution.length-1);
                solution[0] = 1;
                return solution;
            }
            
            if(digits[curr] == 9){
                digits[curr] = 0;
                curr--;
            } else {
                digits[curr]++;
                return digits;
            }
        }
        
    }
}