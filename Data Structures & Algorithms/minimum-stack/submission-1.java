class MinStack {
    
    Stack<Integer> stack;
    TreeMap<Integer, Integer> map;
    Map<Integer, Integer> cnt;

    public MinStack() {
        stack = new Stack<>();
        map = new TreeMap<>();    
        cnt = new HashMap<>();
    }
    
    public void push(int val) {
        stack.push(val);
        map.put(val, val);
        cnt.put(val, cnt.getOrDefault(val, 0) + 1);
    }
    
    public void pop() {
        int val = stack.pop();
        int count = cnt.get(val);
        
        if (--count == 0) {
            cnt.remove(val);
            map.remove(val);    
        }
        else {
            cnt.put(val, count);
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return map.firstEntry().getValue();
    }
}
