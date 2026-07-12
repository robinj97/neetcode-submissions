class Solution {
    public int[] twoSum(int[] nums, int target) {
        // We have a list, target -> indices of components
        // i+j = target
        // target - i = j
        // We need to find j for i
        // For each i compare with j...
        // Store in map with index
        // number,index
        HashMap<Integer,Integer>  indexMap = new HashMap<>();
        int[] indexesToReturn = new int[2];
        for (int i=0;i<nums.length;i++) {
            int compliment = target - nums[i];
            if (indexMap.containsKey(compliment)) {
                indexesToReturn[1] = i;
                indexesToReturn[0] = indexMap.get(compliment);
            } else {
                indexMap.put(nums[i],i);
            }
        }
        return indexesToReturn;
        
    }
}
