class Solution {
    public int findMin(int[] nums) {
        // 1 2 3 4 5 6 -> 3=3 so we go left
        // 2 3 4 5 6 1 -> 4>3 so we go right
        // 3 4 5 6 1 2 -> 5>3 so we go right
        // 4 5 6 1 2 3 -> 6>3 so we go right
        // 5 6 1 2 3 4 -> 1<3 so we go left 
        // 6 1 2 3 4 5 -> 2<3 so we go left
        
        // if midpoint equals length/2 -> we go left
        // if midpoint < length/2 -> we go left
        // if midpoint >= length/2 we go right
        int left = 0;
        int right = nums.length-1;
        while (left<right) {
            int midpointIndex = left + (right-left)/2;
            int valAtMiddle = nums[midpointIndex];
            if (valAtMiddle <= nums[right]) {
                right = midpointIndex;
            } else {
                left = midpointIndex+1;
            }
        }
        return nums[left];
    }
}
