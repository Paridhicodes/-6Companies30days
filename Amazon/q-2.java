package Amazon;

//Longest Mountain
class Solution {
    public int longestMountain(int[] arr) {
        int globalMax = 0;
        int incCount = 0;
        int decCount = 0;
        int prev = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int diff = arr[i + 1] - arr[i];
            if (diff == 0 || (diff > 0 && prev <= 0)) {
                if (incCount != 0 && decCount != 0) {
                    int totalCount = incCount + decCount + 1;
                    globalMax = Math.max(globalMax, totalCount);
                }
                incCount = 0;
                decCount = 0;
            }
            if (diff < 0) {
                decCount++;
            }
            if (diff > 0) {
                incCount++;
            }
            if (incCount != 0 && decCount != 0 && i == arr.length - 2) {
                int totalCount = incCount + decCount + 1;
                globalMax = Math.max(globalMax, totalCount);
            }
            prev = diff;
        }

        return globalMax;

    }
}
