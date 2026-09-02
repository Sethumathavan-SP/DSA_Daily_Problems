class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] mulsl = new int[nums.length];
        int[] mulsr = new int[nums.length];
        mulsl[0] = nums[0];
        mulsr[nums.length - 1] = nums[nums.length - 1];
        
        for (int i = 1; i < nums.length; i++) {
            mulsl[i] = nums[i] * mulsl[i - 1];
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            mulsr[i] = nums[i] * mulsr[i + 1];
        }

        nums[0] = mulsr[1];
        nums[nums.length - 1] = mulsl[nums.length - 2];

        for (int i = 1; i < nums.length - 1; i++) {
            nums[i] = mulsl[i - 1] * mulsr[i + 1];
        }

        return nums;
    }
}  
