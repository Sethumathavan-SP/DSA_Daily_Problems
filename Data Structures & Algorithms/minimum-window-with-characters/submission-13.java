class Solution {
    public String minWindow(String s, String t) {
        int start = 0;
        int end = 0;

        int size = Integer.MAX_VALUE;
        int ms = 0;
        int me = 0;

        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> src = new HashMap<>();

        long marker = 0;

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            marker |= (1l << (ch - 'A'));
        }


        while (start < s.length() && !map.containsKey(s.charAt(start))) start++;

        for (end = start; end < s.length(); end++) {
            char ch = s.charAt(end);
            src.put(ch, src.getOrDefault(ch, 0) + 1);

            
            if (map.containsKey(ch) && map.get(ch).equals(src.get(ch))) {
                System.out.println(start + " " + end);
                marker &= ~(1L << (ch - 'A'));
                
                while (marker == 0) {
                    if ((end - start + 1) < size) {
                        size = end - start + 1;
                        ms = start;
                        me = end + 1;
                    }

                    src.put(s.charAt(start), src.get(s.charAt(start)) - 1);
                    if (map.containsKey(s.charAt(start)) && src.get(s.charAt(start)) < map.get(s.charAt(start))) {
                        marker |= (1l << (s.charAt(start) - 'A'));
                    }
                    start++;
                }
            }
        }

        return (size != Integer.MAX_VALUE) ? s.substring(ms, me) : "";
    }
}
