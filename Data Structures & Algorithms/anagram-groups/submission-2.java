class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] x = new int[strs.length];
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String s = String.valueOf(chs);
            if (map.containsKey(s)) {
                map.get(s).add(str);
            }            
            else {
                List<String> l = new ArrayList<>();
                l.add(str);
                map.put(s, l);
            }
        }

        List<List<String>> res = new ArrayList<>();
        for (String key : map.keySet()) {
            res.add(map.get(key));
        }

        return res;
    }
}
