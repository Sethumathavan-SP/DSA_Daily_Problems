class Solution {
    public int maxArea(int[] heights) {
        int area = 0;
        int mh = 0;

        for (int i = 0; i < heights.length; i++) {
            if (heights[i] <= mh) continue;

            for (int j = i + 1; j < heights.length; j++) {
                int h = Math.min(heights[i], heights[j]);
                int w = j - i;
                
                if (h * w > area) {
                    mh = h;
                    area = h*w;
                }
            }
        }

        return area;
    }
}
