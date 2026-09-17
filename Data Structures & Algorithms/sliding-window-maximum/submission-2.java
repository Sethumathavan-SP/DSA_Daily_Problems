class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>((a,b) -> b - a);
        int[] res = new int[nums.length - k + 1];

        int start = 0;
        int end = 0;

        while (end < k) {
            map.put(nums[end], map.getOrDefault(nums[end++], 0) + 1);
        }

        res[end - k] = map.firstKey();

        for (; end < nums.length; end++) {
            map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);

            map.put(nums[start], map.get(nums[start]) - 1);
            
            if (map.get(nums[start]) == 0) {
                map.remove(nums[start]);
            }
            
            start++;

            res[end - k + 1] = map.firstKey();
        }

        return res;
    }
}
