class Solution {
    public boolean hasDuplicate(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int number : nums) {
            if (set.contains(number)) {
                return true;
            } else {
                set.add(number);
            }
        }
        return false;
    }
}