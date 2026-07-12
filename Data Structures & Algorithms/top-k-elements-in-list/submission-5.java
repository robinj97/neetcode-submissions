class Solution {
    // Most frequent elements
    // We create a frequency map
    // Then we can make a queue with the largest elem at the start of the queue
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }
        HashMap<Integer,Integer> frequencies = new HashMap<>();
        for (int number : nums) {
            frequencies.put(number,frequencies.getOrDefault(number,0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>(k,(a,b)->a.getValue()-b.getValue());
        for (Map.Entry<Integer,Integer> entry : frequencies.entrySet()) {
            queue.add(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        List<Integer> largestElems = new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry : queue) {
            largestElems.add(entry.getKey());
        }
        return largestElems.stream().mapToInt(no->no).toArray();
        
    }
}
