class Solution {
    public boolean isPalindrome(String s) {
        // We need to build a string without spaces or punctuation
        StringBuilder sb = new StringBuilder();
        for (char c : s.toLowerCase().toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(c);
            }
        }
        String check = sb.toString();
        for (int left=0,right=check.length()-1;left<right;left++,right--) {
            if (check.charAt(left)!=check.charAt(right)) {
                return false;
            }
        }
        return true;
    }
}
