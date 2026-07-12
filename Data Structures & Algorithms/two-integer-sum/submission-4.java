class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> indexMap = new HashMap<>();
        int[] indexes = new int[2];
        for (int i=0;i<nums.length;i++) {
            int compliment = target - nums[i];
            if (indexMap.containsKey(compliment)) {
                indexes[0] = indexMap.get(compliment);
                indexes[1] = i;
            } else {
                indexMap.put(nums[i],i);
            }
        }
        return indexes;
        
    }
}
