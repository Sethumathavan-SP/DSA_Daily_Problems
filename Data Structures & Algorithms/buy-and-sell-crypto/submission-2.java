class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int max = prices[n - 1];
        int ans = 0;

        for (int i = n - 1; i >= 0; i--) {
            max = (prices[i]> max) ? prices[i] : max;
            ans = (ans > max - prices[i]) ? ans : max - prices[i];
        }

        return ans;
    }
}
