class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            int temp = temperatures[i];

            while (!stack.isEmpty() && stack.peek().getKey() < temp) {
                Pair<Integer, Integer> currentTemp = stack.pop();
                result[currentTemp.getValue()] = i - currentTemp.getValue();
            }
            
            stack.push(new Pair(temperatures[i], i));
        }

        return result;
    }
}
