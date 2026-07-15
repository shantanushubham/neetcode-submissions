class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> elIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            elIndex.putIfAbsent(nums[i], new LinkedList<>());
            elIndex.get(nums[i]).add(i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (elIndex.containsKey(target - nums[i])) {
                List<Integer> indices = elIndex.get(target - nums[i]);
                for (int index: indices) {
                    if (index == i) {
                        continue;
                    }
                    return new int[]{i, index};
                }
            }
        }
        return null;
    }
}
