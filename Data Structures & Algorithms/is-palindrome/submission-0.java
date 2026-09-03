class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        s = s.toLowerCase();
        
        while (start < end) {
            while (start < end && !Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }
            while (end > start && !Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }

            if (start >= end) {
                break;
            }
            
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
