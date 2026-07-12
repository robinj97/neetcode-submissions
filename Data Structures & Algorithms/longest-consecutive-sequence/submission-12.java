class Solution {
    public int longestConsecutive(int[] nums) {
        // Add all values to a set.
        // Then we do a counted for loop on nums to check each number.
        // When at each number we do a set lookup for the next number until it doesnt exist anymore. 
        //Return the max length found
        if (nums.length == 0) {
            return 0;
        }
        HashSet<Integer> uniqueNumbers = new HashSet<>();
        for (int num : nums) {
            uniqueNumbers.add(num);
        }

        int maxLength = 0;
        for (int i=0;i<nums.length;i++) {
            int currentNumber = nums[i];
            int currentLength = 1;
            int j=currentNumber+1;
            while (uniqueNumbers.contains(j)) {
                currentLength++;
                j++;
            }
            maxLength = Math.max(currentLength,maxLength);
        }
        return maxLength;
    }
}
