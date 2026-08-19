class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> tracker = new HashMap<>();

        for (int num : nums) {
            if (tracker.containsKey(num)) {
                return true;
            } else {
                tracker.put(num, 1);
            }
        } // for

        return false;
    }
}