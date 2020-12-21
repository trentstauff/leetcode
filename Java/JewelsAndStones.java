class Solution {
    public:
    int numJewelsInStones(string J, string S) {

        int result(0);

        for(auto stone: S){
            for(auto jewel: J){
                if(stone==jewel)
                    result++;
            }
        }
        return result;
    }
};