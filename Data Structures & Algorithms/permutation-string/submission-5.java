class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // Frequency count of s1
        // Window will be s1.length
        // For each window, calculate the frequency count and compare.
        int left = 0;
        int right = s1.length();
        HashMap<Character,Integer> freq1 = new HashMap<>();
        for (char c : s1.toCharArray()) {
            freq1.put(c,freq1.getOrDefault(c,0)+1);
        }
        while (right<=s2.length()) {
            String substring = s2.substring(left,right);
            HashMap<Character,Integer> map = getFreqMap(substring);
            boolean areEqual = areMapsEqual(freq1,map);
            if (areEqual) {
                return true;
            } else {
                left++;
                right++;
            }
        }
        return false;

    }

    private HashMap<Character,Integer> getFreqMap(String s) {
        HashMap<Character,Integer> freq1 = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq1.put(c,freq1.getOrDefault(c,0)+1);
        }
        return freq1;
    }

    private boolean areMapsEqual(HashMap<Character,Integer> m1,HashMap<Character,Integer> m2) {
        for (char c : m1.keySet()) {
            if (!m2.containsKey(c) || m2.get(c) != m1.get(c)) {
                return false;
            }
        }
        return true;
    }
}
