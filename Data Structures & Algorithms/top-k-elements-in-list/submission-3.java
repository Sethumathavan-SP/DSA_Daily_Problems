class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[k];

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            q.add(new int[] {pair.getKey(), pair.getValue()});
        }

        for (int i = 0; i < k; i++) {
            res[i] = q.poll()[0];
        }

        return res;
    }
}
