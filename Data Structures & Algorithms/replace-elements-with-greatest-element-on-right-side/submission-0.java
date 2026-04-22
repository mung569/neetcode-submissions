class Solution {
    public int[] replaceElements(int[] arr) {
        for (int i=0; i<arr.length - 1; i++) {
            int max = arr[i+1];

            for (int j=i+1; j<arr.length - 1; j++) {
                int next = arr[j+1];

                if (next > max) {
                    max = next;
                }
            }

            arr[i] = max;
        }

        arr[arr.length - 1] = -1;

        return arr;
    }
}