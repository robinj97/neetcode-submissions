class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> valueToIdx = new HashMap<>();
        for (int i=0; i<nums.length;i++) {
            int toFind = target - nums[i];
            if (valueToIdx.containsKey(toFind)) {
                int[] indexes = new int[2];
                indexes[0] = valueToIdx.get(toFind);
                indexes[1] = i;
                return indexes;
            } else {
                valueToIdx.put(nums[i],i);
            }
        }
        return new int[2];
    }
}

// 3,4,5,6 target= 7
// First im at 3, so i know i need to find a 4 potentially
// We can check if we have encountered a 4 in a map that keeps track
// If we cannot make the target, add current to map and move on.