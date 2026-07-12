class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // 1 2 3 4 5 6 7 12  11
        // 
        // Add to the hasmap first
        // Then check for compliment
        // If the compliment index is less than
        int left = 0;
        int right = numbers.length-1;
        int sumFound = 0;
        while (left < right) {
                int sum = numbers[left] + numbers[right];

                if (sum == target) {
                    // Return indices adjusted for 1-based indexing
                    return new int[] { left + 1, right + 1 };
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        return new int[0]; 
    } 
}
