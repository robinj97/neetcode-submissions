class Solution {
    public int lengthOfLongestSubstring(String s) {
        //Brute force attempt is for each character, we find all substrings and see if they are unique, if so we save to a max
        // Track characters seen in a set. 
        // zxyzxyz
        //  ^ ^
        // left and right pointers
        // Once we hit a duplicate we increment left by one, otherwise we keep incrementing right and checking size.
        // xxxxxx
        // 
        if (s.length() < 1) {
            return 0;
        }
        HashSet<Character> seen = new HashSet<>();
        int left = 0;
        int right =0;
        int maxLengthSoFar = 0;
        while (right<s.length()) {
            if (!seen.contains(s.charAt(right))) {
                seen.add(s.charAt(right));
                right++;
            } else {
                seen.remove(s.charAt(left));
                left++;
            }
            maxLengthSoFar = Math.max(maxLengthSoFar,seen.size());
        }
        return maxLengthSoFar;
    }
}
