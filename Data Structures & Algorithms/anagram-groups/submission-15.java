class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> groupedAnagrams = new HashMap<>();
        for (String word : strs) {
            char[] sorted = word.toCharArray();
            Arrays.sort(sorted);
            String key = new String(sorted);
            List<String> anagramsInGroup;
            if (!groupedAnagrams.containsKey(key)) {
                anagramsInGroup = new ArrayList<>();
                anagramsInGroup.add(word);
                groupedAnagrams.put(key,anagramsInGroup);
            } else {
                anagramsInGroup = groupedAnagrams.get(key);
                anagramsInGroup.add(word);
                groupedAnagrams.put(key,anagramsInGroup);
            }
        }
        List<List<String>> listToRet = new ArrayList<>();
        for (List<String> anagramList : groupedAnagrams.values()) {
            listToRet.add(anagramList);
        }
        return listToRet;
    }
}

// We need to keep track of buckets of anagrams grouped together
// All in the same bucket will have their sorted version be the same
// Once we have all buckets, we can add to the list after iterating over all 

// For-each words in str