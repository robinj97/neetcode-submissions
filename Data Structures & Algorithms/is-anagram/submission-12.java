class Solution {
    public boolean isAnagram(String s, String t) {
        // Anagrams are the same count of each letter.
        // Collect amount for each let
        char[] arrS = s.toCharArray();
        Arrays.sort(arrS);
        
        char[] arrT = t.toCharArray();
        Arrays.sort(arrT);

        System.out.println(arrT);
        System.out.println(arrS);

        return Arrays.equals(arrT,arrS);

    }
}
