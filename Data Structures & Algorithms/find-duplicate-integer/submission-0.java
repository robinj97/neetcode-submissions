class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int number : nums) {
            if (seen.contains(number)) {
                return number;
            } else {
                seen.add(number);
            }
        }
        return -1;
        
    }
}
