class Solution {
    public int characterReplacement(String s, int k) {
        int[] al = new int[26];
        TreeMap<Integer, Set<Integer>> map = new TreeMap<>((a,b) -> b-a);

        int max = 1;
        int ans = 0;
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            int num = ch - 'A';
            
            if (map.containsKey(al[num])) {
                map.get(al[num]).remove(num);
                if (map.get(al[num]).size() == 0) {
                    map.remove(al[num]);
                }
            }
            al[num]++;
            
            if (map.containsKey(al[num])){
                map.get(al[num]).add(num);
            }
            else {
                Set<Integer> set = new HashSet<>();
                set.add(num);
                map.put(al[num], set);
            }
            
            Map.Entry<Integer, Set<Integer>> topSet = map.firstEntry();
            max = topSet.getKey();

            while (end - start + 1 - max > k) {
                char c = s.charAt(start++);
                int nm = c - 'A';

                if (map.containsKey(al[nm])) {
                    map.get(al[nm]).remove(nm);
                    if (map.get(al[nm]).size() == 0) {
                        map.remove(al[nm]);
                    }
                }
                
                al[nm]--;
                
                if (map.containsKey(al[nm])){
                    map.get(al[nm]).add(nm);
                }
                else {
                    Set<Integer> set = new HashSet<>();
                    set.add(nm);
                    map.put(al[nm], set);
                }

                max = map.firstKey();                       
            }

            ans = Math.max(ans, end - start + 1);
        }

        return ans;
    }
}