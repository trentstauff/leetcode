class Solution {
    public String addBinary(String a, String b) {
        
        StringBuilder worker = new StringBuilder();
        
        if(a.length() < b.length()){
            
            int sizeDiff = b.length() - a.length();
            
            while(sizeDiff != 0){
                worker.append("0");
                sizeDiff--;
            }
            worker.append(a);
            a = worker.toString();

        } else if(b.length() < a.length()) {
            
            int sizeDiff = a.length() - b.length();
            
            while(sizeDiff != 0){
                worker.append("0");
                sizeDiff--;
            }
            worker.append(b);
            b = worker.toString();
        } else {
            
        }
        
        // clear worker
        worker.setLength(0);
        
        char[] aChar = a.toCharArray();
        char[] bChar = b.toCharArray();
        char carry = '0';
        String toAdd = "";
        
        for(int i = a.length()-1; i >= 0; i--){
            
            char aTemp = aChar[i];
            char bTemp = bChar[i];
            
            if(aTemp == '0' && bTemp == '1' || aTemp == '1' && bTemp == '0'){
                
                toAdd = (carry == '0' ? "1" : "0");
                worker.append(toAdd);
                carry = (carry == '1' ? '1' : '0');
                
            } else if (aTemp == '1' && bTemp == '1'){
                
                toAdd = (carry == '0' ? "0" : "1");
                worker.append(toAdd);
                carry = '1';
                
            } else if (aTemp == '0' && bTemp == '0'){
                
                toAdd = (carry == '0' ? "0" : "1");
                worker.append(toAdd);
                carry = '0';
            }
        }
        
        if(carry == '1')
            worker.append("1");
        
        return worker.reverse().toString();
    }
}