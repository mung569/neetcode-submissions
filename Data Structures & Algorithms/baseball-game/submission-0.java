class Solution {
    public int calPoints(String[] operations) {
        int[] record = new int[operations.length];
        int top = -1;
        int totalSum = 0;

        for (int i = 0; i < operations.length; i++) {
            // consider converting to switch/case:
            
            if (operations[i].equals("+")) {
                record[top+1] = record[top] + record[top - 1];
                top++;
            } 
            else if (operations[i].equals("D")) {
                record[top+1] = record[top] * 2;
                top++;
            } 
            else if (operations[i].equals("C")) {
                if (top != -1) { // check if stack empty
                    top--;
                }
            }
            else { // integer
                record[top+1] = Integer.parseInt(operations[i]);
                top++;
            }
        } // for

        for (int i = 0; i <= top; i++) {
            totalSum += record[i];
        }

        return totalSum;
    }
}