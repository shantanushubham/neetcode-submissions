class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = numbers.length - 1; i >= 0; i--) {
            int num = numbers[i];
                int diff = target - num;
                int otherIndex = this.binarySearch(numbers, 0, i, diff);
                if (otherIndex >= 0) {
                    return new int[]{otherIndex + 1, i + 1};
                }
        }
        return null;
    }

    private int binarySearch(int[] numbers, int start, int end, int target) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (numbers[mid] == target) {
                return mid;
            } else if (numbers[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
