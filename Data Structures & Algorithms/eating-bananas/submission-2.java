class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);

        int s = 1;
        int e = piles[piles.length - 1];

        while (s <= e) {
            int m = s + (e - s) / 2;
            int time = 0;
            
            for (int pile : piles) {
                time += (pile + m - 1) / m;
            }

            if (time <= h) {
                e = m - 1;
            }
            else {
                s = m + 1;
            }
        }

        return s;
    }
}
