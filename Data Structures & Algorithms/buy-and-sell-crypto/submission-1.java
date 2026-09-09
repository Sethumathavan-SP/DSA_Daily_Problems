class Solution {
    public int maxProfit(int[] prices) {
        int max = prices[prices.length - 1];
        int ans = 0;

        for (int i = prices.length - 1; i >= 0; i--) {
            max = (prices[i]> max) ? prices[i] : max;
            ans = (ans > max - prices[i]) ? ans : max - prices[i];
        }

        return ans;
    }
}
