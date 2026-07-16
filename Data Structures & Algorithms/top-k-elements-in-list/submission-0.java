class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return this.getHighestKElements(map.entrySet(), k);
    }

    private int[] getHighestKElements(Collection<Map.Entry<Integer, Integer>> collection, int k) {
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (el1, el2) -> el2.getValue() - el1.getValue());
        pq.addAll(collection);
        int[] topElements = new int[k];
        for (int i = 0; !pq.isEmpty() && i < k; i++) {
            topElements[i] = pq.poll().getKey();
        }
        return topElements;
    }
}
