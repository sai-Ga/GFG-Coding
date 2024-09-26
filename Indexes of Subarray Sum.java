class Solution {

    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {

        int sum = 0; // Tracks the current sum of elements in the window.

        int l = 0;   // Left index of the window.
        int r = 0;   // Right index of the window.

        ArrayList<Integer> res = new ArrayList<>();

        // Loop through the array until the right index reaches the end.
        while (r < n) {

            // Add the current element to the sum.
            sum += arr[r];

            // Check if the sum exceeds the given target 's'.
            while (l < r && sum > s) {

                // reduce the window from left side (to decrease the sum)
                sum -= arr[l];
                l++;

            }

            // If the sum equals the target 's', we've found the subarray.
            // we need to return 1-based indexing as the answer
            if (sum == s) {

                res.add(l + 1);
                res.add(r + 1);
                return res;
            }

            // Increment the right index to expand the window.
            r++;
        }

        // no sub array with sum s was found
        res.add(-1);
        return res;
    }
}
