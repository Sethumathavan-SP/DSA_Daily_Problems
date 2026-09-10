class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        Set set = new HashSet<Character>();
        int len = 0;
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (set.contains(ch)) {
                while (start <= end && s.charAt(start) != ch) {
                    set.remove(s.charAt(start));
                    start++;
                }
                set.remove(ch);
                start++;
            }
            set.add(ch);
            len = Math.max(end - start + 1, len);
        }
        return len;
    }
}
