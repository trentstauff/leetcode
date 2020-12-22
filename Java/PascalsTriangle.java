class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        if(numRows == 0)
            return new ArrayList<List<Integer>>(0);
        
        List<List<Integer>> results = new ArrayList<List<Integer>>(numRows);
        
        // populate all 1's
        for(int i = 1; i <= numRows; i++){
            
            List<Integer> populate = new ArrayList<Integer>(Collections.nCopies(i, 0));
            populate.set(0, 1);
            populate.set(populate.size()-1, 1);
            results.add(populate);
            
        }
        
        if(numRows == 1)
            return results;
        
        List<Integer> prev = results.get(1);

        // now calculate the proper values not on the edges 
        // start at two as the first two rows are done
        for(int i = 2; i < numRows; i++){
            
            List<Integer> curr = results.get(i);
            
            // calculate values
            // start at 1, as the first entry is a 1.
            // go to size-1, as last entry is a 1.
            for(int j = 1; j < curr.size()-1; j++ ){
                
                int value = prev.get(j-1) + prev.get(j);
                curr.set(j, value);
                
            }
            prev = curr;
            results.set(i, curr);
        }
        
        return results;
    }
}