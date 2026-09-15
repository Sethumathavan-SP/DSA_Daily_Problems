class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }

        Map<Character, Integer> srcMap = new HashMap<>();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            srcMap.put(ch, srcMap.getOrDefault(ch, 0) + 1);
        } 

        int start = 0;
        int cur = 0;
        for (int end = 0; end < s2.length(); end++) {
            if (end - start + 1 > s1.length()) {
                int val = map.get(s2.charAt(start));
                
                if (val == 1) {
                    map.remove(s2.charAt(start));
                }
                
                else {
                    map.put(s2.charAt(start) , val - 1);
                }

                start++;
            }

            char ch = s2.charAt(end);

            map.put(ch, map.getOrDefault(ch, 0) + 1);

            if (end - start + 1 == s1.length() && srcMap.equals(map)) {
                return true;
            }

            System.out.println(srcMap + " " + map);
                
        }

        return false;
    }
}
