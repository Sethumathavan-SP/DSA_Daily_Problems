class TimeMap {

    Map<String, ArrayList<Pair<Integer, String>>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        ArrayList<Pair<Integer, String>> val;
        val = map.getOrDefault(key, new ArrayList<>());

        int ind = binarySearch(val, timestamp, true);

        if (ind < val.size() && val.get(ind).getKey() == timestamp) {
            val.remove(ind);
        }

        val.add(ind, new Pair<>(timestamp, value));

        map.put(key, val);
    }
    
    public String get(String key, int timestamp) {
        ArrayList<Pair<Integer, String>> val = map.get(key);

        if (val == null) return "";

        int ind = binarySearch(val, timestamp, false);

        return (ind >= 0) ? val.get(ind).getValue() : "";
    }

    private int binarySearch(ArrayList<Pair<Integer, String>> l, int t, boolean op) {
        int s = 0;
        int e = l.size() - 1;

        while (s <= e) {
            int m = s + (e - s) / 2;
            int v = l.get(m).getKey();
            
            if (v == t) {
                return m;
            }
            else if (v  < t) {
                s = m + 1;
            }
            else {
                e = m - 1;
            }
        }

        return (op) ? s : e;
    }
}
