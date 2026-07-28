class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        char[] charArray = s.toLowerCase().toCharArray();
        for (char c : charArray) {
            if (Character.isAlphabetic(c) || Character.isDigit(c)) {
                sb.append(c);
            }
        }
        charArray = sb.toString().toCharArray();
        int left = 0;
        int right = charArray.length - 1;
        while (left < right && left <= charArray.length - 1 && right >= 0) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
