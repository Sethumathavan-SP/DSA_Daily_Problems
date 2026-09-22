class Solution {
    public int findMin(int[] nums) {
        int s = 0;
        int e = nums.length - 1;

        while (s <= e) {
            int m = s + (e - s) / 2;

            if (nums[s] > nums[e]) {
                if (nums[m] >= nums[s]) {
                    s = m + 1;
                }
                else {
                    e = m;
                }
            }
            else {
                e = m - 1;
            }
        }

        return nums[s];
    }
}
