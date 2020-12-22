class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        
        // This solution got 100% better time!

        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return new int[0];
        
        // position[0] == y
        // position[1] == x
        // position[2] == index for result
        int[] position = new int[]{0,0,0};
        int[] results = new int[matrix.length * matrix[0].length];
       
        while(position[2] != matrix.length * matrix[0].length){
        
        digTopRight(matrix, position, results);
        digBottomLeft(matrix, position, results);
        }

        return results;
    }
    
    public int digTopRight(int[][] matrix, int[] position, int[] results){
        
        while(true){
            
            if(position[0] == -1 || position[1] == matrix[0].length){
                
                position[0] = (position[0] == -1 ? 0 : position[0]);
                position[1] = (position[1] == matrix[0].length ? matrix[0].length - 1 : position[1]);
                return 1;
            }
            
            // set the value of the results array
            results[position[2]] = matrix[position[0]][position[1]];
            
            // case that we should dig down to the left now, so move over one index and dig down left
            if(position[0] == 0 && (position[1] + 1 != matrix[0].length)){
                
                // move position over in x direction to right by one
                position[1]++;
                // increase index for results array
                position[2]++;
                return 1;
                
                // case of reaching right side of matrix
            } else if (position[1] == matrix[0].length - 1) {
                
                position[0]++;
                position[2]++;
                return 1;
                
            } else {
                
                position[0]--;
                position[1]++;
                position[2]++;
                
            }
        }
    }
    
    public int digBottomLeft(int[][] matrix, int[] position, int[] results){
     
        while(true){
            
            if(position[0] == matrix.length || position[1] == -1){
                position[0] = (position[0] == matrix.length ? matrix.length - 1 : position[0]);
                position[1] = (position[1] == -1 ? 0 : position[1]);
                return 1;
            }
            // set the value of the results array
            results[position[2]] = matrix[position[0]][position[1]];
            
            // case that we should dig up to the right now, so move over one index to dig up right 
            if(position[0] == matrix.length-1){
                // move position over in x direction to right by one
                position[1]++;
                // increase index for results array
                position[2]++;
                return 1;
                
                // case of reaching left side of matrix
            } else if (position[1] == 0) {
                
                position[0]++;
                position[2]++;
                return 1;
                
            } else {
                
                position[0]++;
                position[1]--;
                position[2]++;
                
            }
        }
    }
}