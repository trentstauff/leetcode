class Solution {
    public int smallestRepunitDivByK(int K) {
        
        int temp = K % 10;
        if(temp % 2 == 0 || temp % 5 == 0)
            return -1;

        int i = 1;
        int digitCounter = 1;

        while(i % K != 0){
            
            // this will get you the next remainder
            i = (i * 10 + 1) % K;
            digitCounter++;

        }
        return digitCounter;
    }
}