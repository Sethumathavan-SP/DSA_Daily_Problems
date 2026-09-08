class Solution {
    public int search(int[] nums, int target) {
        int pos = Arrays.binarySearch(nums, target);

        return (pos < 0) ? -1 : pos;
    }
}
