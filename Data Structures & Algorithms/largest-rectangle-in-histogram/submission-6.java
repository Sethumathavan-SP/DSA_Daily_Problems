class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();

        int maxArea = 0;

        stack.push(new int[] {heights[0], 0});

        for (int i = 1; i < heights.length; i++) {
            if (stack.isEmpty() || heights[i] > stack.peek()[0]) {
                stack.push(new int[] {heights[i], i});
            }
            else {
                int current = i;
                int s = 0;
                while (!stack.isEmpty() && stack.peek()[0] >= heights[i]) {
                    int[] currHeight = stack.pop();
                    maxArea = Math.max(maxArea, currHeight[0] * (current - currHeight[1]));
                    s = currHeight[1];
                }

                stack.push(
                    new int[] 
                    {heights[i], s});
            }
        }

        int last = heights.length;
        
        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            maxArea = Math.max(maxArea, current[0] * (last - current[1]));
        }


        return maxArea;
    }
}
