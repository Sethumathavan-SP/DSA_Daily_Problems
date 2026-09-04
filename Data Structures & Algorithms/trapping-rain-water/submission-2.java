class Solution {
    public int trap(int[] height) {
        int[] m = new int[height.length];
        int sum = 0;

        m[0] = height[0];
        m[height.length - 1] = height[height.length - 1];

        for (int i = 1; i < height.length - 1; i++) {
            m[i] = Math.max(m[i - 1], height[i]);
            sum += height[i];
        }
        
        int secSum = 0;

        for (int i = height.length - 2; i > 0; i--) {
            int cur = Math.max(height[i], m[i + 1]);
            secSum += Math.min(cur, m[i]);
            m[i] = cur;
        }

        sum = secSum - sum;

        return sum;
    }
}