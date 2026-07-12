class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // We need to relate something to some values
        // strs can be 1 -> return list of 1
        // Anagrams have same letters different ORDER...sort?
        // HashMap<String,List<String>      sorted,words
        List<List<String>> toRet = new ArrayList<>();
        if (strs.length == 1) {
            List<String> anagrams = new ArrayList<>();
            anagrams.add(strs[0]);
            toRet.add(anagrams);
            return toRet;
        }
        HashMap<String,List<String>> groups = new HashMap<>();
        // For each value in strs -> Find the key by sorting, then put in list for that 
        for (String word : strs) {
            char[] keyArr = word.toCharArray();
            Arrays.sort(keyArr);
            String key = new String(keyArr);
            List<String> anagrams;
            if (groups.get(key) == null) {
                anagrams = new ArrayList<>();
            } else {
                anagrams = groups.get(key);
                
            }
            anagrams.add(word);
            groups.put(key,anagrams);
        }
        for (List<String> anagrams : groups.values()) {
            toRet.add(anagrams);
        }
        return toRet;
        
    }
}
