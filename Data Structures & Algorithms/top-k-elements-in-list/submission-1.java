class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // We need to count frequencies to find the k largest
        // number,frequency
        // We can have a PriorityQueue with elem where we always keep removing the smallest after reaching k elements?
        // 1. Create a frequency map
        // 2. Iterate over keys in map
        // 3. For each key, add k,v in PriorirtQueue (we need to add with comparator map.getValue)
        // 4. Once priorirtQueue is greater than k, we remove the elem with smallest val.
        HashMap<Integer,Integer> frequencies = new HashMap<>();
        for (int number : nums) {
            frequencies.put(number,frequencies.getOrDefault(number,0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> heap = new PriorityQueue<>(k,(a,b)->a.getValue()-b.getValue());
        for (Map.Entry<Integer,Integer> entry : frequencies.entrySet()) {
            heap.add(entry);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        int[] largestElems = new int[heap.size()];
        for (int i=0;i<k;i++) {
            largestElems[i] = heap.poll().getKey();
        }
        return largestElems;
    }
}
