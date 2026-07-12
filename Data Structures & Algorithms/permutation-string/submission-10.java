class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // We need to iterate over s2 with a window of s1.length() and check that window for permutations
        // How can we check permutations? -> Frequency map
        // 1. Create a frequency map of s1, check against s2
        // abc lecabee
        // a1 b1 c1 lec -> l1 e1 c1
        //      e1c1a1 -> false
        // Steps to solve
        // 1. Function to create frequency map
        // 2. Function to equals two freqMaps
        HashMap<Character,Integer> s1FreqMap = getFreqMap(s1);
        int left = 0;
        int right = s1.length();
        while (right <= s2.length()) {
            String currentSubstring = s2.substring(left,right);
            HashMap<Character,Integer> freqMapForSubstring = getFreqMap(currentSubstring);
            if (areMapsEqual(s1FreqMap,freqMapForSubstring)) {
                return true;
            } else {
                left++;
                right++;
            }
        }
        return false;
    }

    private HashMap<Character,Integer> getFreqMap(String s) {
        HashMap<Character,Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c,freqMap.getOrDefault(c,0)+1);
        }
        return freqMap;
    }

    private boolean areMapsEqual(HashMap<Character,Integer> m1, HashMap<Character,Integer> m2) {
        for (char c : m1.keySet()) {
            if (!m2.containsKey(c) || m1.get(c) != m2.get(c)) {
                return false;
            }
        }
        return true;
    }
}
