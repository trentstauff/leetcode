// Hashmap solution, first approach
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        HashMap<Character,Integer> map = new HashMap<Character,Integer>();

        for(char c : magazine.toCharArray()){

            map.put(c, map.getOrDefault(c,0)+1);
        }

        for(char c : ransomNote.toCharArray()){

            if(!map.containsKey(c) || map.get(c) <= 0)
                return false;

            map.put(c, map.get(c)-1);
        }

        return true;
    }
}

// Faster, array solution
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        int[] count = new int[26];

        for(char c : magazine.toCharArray()){
            count[c-97]++;
        }

        for(char c : ransomNote.toCharArray()){

            if(count[c-97] <= 0)
                return false;

            count[c-97]--;
        }
        return true;

    }
}