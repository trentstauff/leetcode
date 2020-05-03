class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {

        int[] count = new int[101];

        for(int a : nums)
            count[a]++;

        int less = 0;

        for(int i = 0; i < count.length; i++){
            if(count[i] != 0){

                less += count[i];
                count[i]=less-count[i];
            }
        }

        for(int i=0;i<nums.length;i++){

            nums[i]=count[nums[i]];
        }

        return nums;
    }
}
