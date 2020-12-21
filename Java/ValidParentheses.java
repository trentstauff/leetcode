// Note, can drastically save time by defining a global hashmap of:
//   Key | Value
//   ')' | '('
//   '}' | '{'
//   ']' | '['
// this way, we dont have to execute stack.peek(), the main contributor
// to our runtime

class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){

            if(c == '{' || c == '(' || c == '[' ){
                stack.push(c);
            } else {
                System.out.println(stack);
                if(stack.size() == 0)
                    return false;

                switch(c){
                    case '}':
                        if(stack.peek() != '{')
                            return false;
                        stack.pop();
                        break;
                    case ')':
                        if(stack.peek() != '(')
                            return false;
                        stack.pop();
                        break;
                    case ']':
                        if(stack.peek() != '[')
                            return false;
                        stack.pop();
                        break;
                }
            }
        }
        return stack.size() == 0;
    }
}