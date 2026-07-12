class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // 1 2 3 4, 3 -> 1,2 (addone)
        // 2 1 2 1 2 ,3 -> 2 1
        // Add to the hasmap first
        // Then check for compliment
        // If the compliment index is less than
        HashMap<Integer,Integer> numAt = new HashMap<>();
        int[] indices = new int[2];
        for (int i=0;i<numbers.length;i++) {
            int compliment = target - numbers[i];
            if (numAt.containsKey(compliment)) {
                indices[0] = Math.min(i+1,numAt.get(compliment) +1);
                indices[1] = Math.max(i+1,numAt.get(compliment) +1);
            } else {
                numAt.put(numbers[i],i);
            }
        }
        return indices; 
    } 
}
