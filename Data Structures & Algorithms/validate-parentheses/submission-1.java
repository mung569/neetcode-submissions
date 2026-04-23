class Solution {
    public boolean isValid(String s) {
        char[] strArray = s.toCharArray();
        char[] stack = new char[strArray.length];
        int top = -1;

        if (s.length() % 2 != 0) return false;  // odd-length strings are invalid
        
        for (int i=0; i < strArray.length; i++) {
            char c = strArray[i];
            boolean isOpeningBracket = (c == '(' || c == '{' || c == '[');
            boolean isClosingBracket = (c == ')' || c == '}' || c == ']');

            // push onto stack if opening bracket
            if (isOpeningBracket) {
                stack[top+1] = c;   
                top++;
            }
            else if (isClosingBracket && top < 0) {
                // isClosingBracket but stack is empty
                return false;
            }
            else {
                boolean closed = (
                    (c == ')' && stack[top] == '(') ||
                    (c == ']' && stack[top] == '[') ||
                    (c == '}' && stack[top] == '{')
                );
                if (closed) top--; // pop off stack
                else return false;
            } // if
        } // for

        // check if stack is empty
        if (top == -1 && strArray.length != 0) {
            return true;
        }
        else return false;
    }
 }
