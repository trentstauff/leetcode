class Solution {
    public int hammingDistance(int x, int y) {

        int count = 0;

        // using XOR, we can see what bits are different
        // between the numbers. We can then just count
        // the number of ones (bits that are different)
        // and that is our result

        for(int i = (x^y); i > 0; i = i >> 1){

            // since were looking to see if the right
            // most bit is 1, we can do "i mod 2", to see
            // if the remainder of the computation is
            // a 1. If this returns 0, then we have a zero
            // in this rightmost position

            if(i % 2 == 1){
                count++;
            }
        }

        return count;
    }
}