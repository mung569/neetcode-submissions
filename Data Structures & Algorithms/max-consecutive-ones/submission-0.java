class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxConsecutive= 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            }
            else { // nums[i] == 0
                if (maxConsecutive == 0 || count > maxConsecutive) {
                    maxConsecutive = count;
                }
                count = 0;
            }
        }

        if (count > maxConsecutive) {
                    maxConsecutive = count;
        }

        return maxConsecutive;
    }
}