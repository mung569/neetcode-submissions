class Solution {
    public boolean isPalindrome(String s) {
        String str = s.replaceAll(" ", ""); // remove whitespace
        char[] s_array = str.toCharArray();
        String str_filtered = "";
        String s_reversed = "";

        for (char c : s_array) {
            if (!Character.isLetterOrDigit(c)) { // remove non-alphanumeric chars
                continue;
            }
            else {
                str_filtered += c;
            }
        } // for

        str = str_filtered; // update str

        s_reversed = new StringBuilder(str).reverse().toString(); // reverse string
        
        if (str.equalsIgnoreCase(s_reversed)) { // check if palindrome
            return true;
        } // if
        else return false;
    }
}