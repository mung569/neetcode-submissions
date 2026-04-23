class Solution {
    public int calPoints(String[] operations) {
        int[] record = new int[operations.length];
        int top = -1;
        int totalSum = 0;

        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "+" -> {
                    record[top+1] = record[top] + record[top - 1];
                    top++;
                }
                case "D" -> {
                    record[top+1] = record[top] * 2;
                    top++;
                }
                case "C" -> {
                    if (top != -1) top--; // check if stack empty
                }
                default -> {
                    record[top+1] = Integer.parseInt(operations[i]);
                    top++;
                }
            } // switch
        } // for

        for (int i = 0; i <= top; i++) {
            totalSum += record[i];
        }

        return totalSum;
    }
}