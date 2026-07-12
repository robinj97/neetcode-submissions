class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character,Integer> mapS = new HashMap<>();
        HashMap<Character,Integer> mapT = new HashMap<>();
        for (int i=0;i<s.length();i++) {
            char currentCharacterS = s.charAt(i);
            char currentCharacterT = t.charAt(i);

            mapS.put(currentCharacterS,mapS.getOrDefault(currentCharacterS,0)+1);
            mapT.put(currentCharacterT,mapT.getOrDefault(currentCharacterT,0)+1);
        }
        for (char character:s.toCharArray()) {
            int countS = mapS.get(character);
            if (!mapT.containsKey(character)) {
                return false;
            }
            else if (countS != mapT.get(character)) {
                return false;
            }
        }
        return true;
    }
}
