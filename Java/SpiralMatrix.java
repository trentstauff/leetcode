class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        ////////////////
        //
        // I admit the 4 functions are similar code with minor changes.
        // My next attempt would be to condense this into one function.
        //
        ////////////////

        // convert covered squares to -101
        // turn right when about to go out of range or hit -101 square
        // while(index != size of matrix)
        
        List<Integer> results = new ArrayList<Integer>();
        
        // data[0] = y cord
        // data[1] = x cord
        // data[2] = count
        int[] data = new int[]{0,0,0};
        
        int size = matrix.length * matrix[0].length;
        
        while(data[2] != size){
            goRight(results, data, matrix);
            goDown(results, data, matrix);
            goLeft(results, data, matrix);
            goUp(results, data, matrix);
        }
        
        return results;
        
    }
    
    public void goRight(List<Integer> results, int[] data, int[][] matrix){
        
        int x = data[1];

        while(true){
            
            if(x == matrix[0].length)
                break;
            
            if(matrix[data[0]][x] == -101)
                break;
            
            results.add(matrix[data[0]][x]);
            matrix[data[0]][x] = -101;
            x++;
            data[2]++;
        }
        
        // move back left one place, down one place
        x--;
        data[1] = x;
        data[0]++;
    }

    public void goDown(List<Integer> results, int[] data, int[][] matrix){

        int y = data[0];

        while(true){
           
            if(y == matrix.length)
                break;
            
            if(matrix[y][data[1]] == -101)
                break;
            
            results.add(matrix[y][data[1]]);
            matrix[y][data[1]] = -101;
            y++;
            data[2]++;
        }
        
        // move back up one place, left one place
        y--;
        data[0] = y;
        data[1]--;
        
    }
    
    public void goLeft(List<Integer> results, int[] data, int[][] matrix){
        
        int x = data[1];
        
        while(true){
            
            if(x == -1)
                break;
            
            if(matrix[data[0]][x] == -101)
                break;
            
            results.add(matrix[data[0]][x]);
            matrix[data[0]][x] = -101;
            x--;
            data[2]++;
        }
        
        // move back right one place, up one place
        x++;
        data[1] = x;
        data[0]--;
        
    }
    
    public void goUp(List<Integer> results, int[] data, int[][] matrix){

        int y = data[0];
        
        while(true){
            
            if(y == -1)
                break;
            
            if(matrix[y][data[1]] == -101)
                break;
            
            results.add(matrix[y][data[1]]);
            matrix[y][data[1]] = -101;
            y--;
            data[2]++;
        }
        
        // move back down one place, right one place
        y++;
        data[0] = y;
        data[1]++;
        
    }
}