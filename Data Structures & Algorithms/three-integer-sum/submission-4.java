class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            while (i < nums.length && i != 0 && nums[i] == nums[i - 1]) i++;
            
            int s = i + 1;
            int e = nums.length - 1;

            if (i == nums.length) break;

            while (s < e) {
                int num = nums[i] + nums[s] + nums[e];
                if (num == 0) {
                    res.add(List.of(nums[i], nums[s], nums[e]));
                    s++;
                    e--;

                    while (s < e && nums[s] == nums[s - 1]) s++;
                    while (s < e && nums[e] == nums[e + 1]) e--;

                }
                else if (num < 0) {
                    s++;
                }
                else {
                    e--;
                }
            }
        }

        return res;
    }
}
