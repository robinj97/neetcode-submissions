class Solution {
    // Iterate through list, add to hashMap where key is the word as sorted key -> toCharArray -> sort and then string of that
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> groups = new HashMap<>();

        for (String s: strs) {
            char[] letters = s.toCharArray();
            Arrays.sort(letters);
            String key = new String(letters);
            List<String> anagrams;
            if (groups.get(key) == null) {
                anagrams = new ArrayList<>();
            } else {
                anagrams = groups.get(key);
            }
            anagrams.add(s);
            groups.put(key,anagrams);
        }
        List<List<String>> groupedList = new ArrayList<>();
        for (List<String> group : groups.values()) {
            groupedList.add(group);
        }
        return groupedList;
    }
}
