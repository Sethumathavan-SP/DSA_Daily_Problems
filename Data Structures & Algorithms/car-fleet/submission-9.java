class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> b[0] - a[0]);

        for (int i = 0; i < position.length; i++) {
            queue.add(new int[] {position[i], speed[i]});
        }
        
        Stack<int[]> stack = new Stack<>();

        stack.push(queue.poll());

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            double ct = (target - current[0]) / (current[1] * 1.0);

            int[] top = stack.peek();
            double nt = (target - top[0]) / (top[1] * 1.0);

            if (nt < ct) {
                stack.push(current);
            }
        }

        return stack.size();
    }
}
