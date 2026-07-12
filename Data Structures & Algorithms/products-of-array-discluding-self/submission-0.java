class Solution {
    public int[] productExceptSelf(int[] nums) {
        //Find the total product, -! if there is a zero in the array because then total would always be 0
        // Current pointer iterate, if we are at currentPointer, we dont multiply to sum
        int[] products = new int[nums.length];
        int currentPointer = 0;
        while (currentPointer < nums.length) {
            int sumProduct=1;
            for (int i=0;i<nums.length;i++) {
                if (i != currentPointer) {
                    sumProduct = sumProduct * nums[i];
                }
            }
            products[currentPointer] = sumProduct;
            currentPointer++;
        }
        return products;
    }
}  
