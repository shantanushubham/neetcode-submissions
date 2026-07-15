class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }

}

class AnagramGroup {
    List<String> anagramsInTheGroup;

    public AnagramGroup() {
        this.anagramsInTheGroup = new ArrayList<>();
    }

    public void addAnagram(String s) {
        this.anagramsInTheGroup.add(s);
    }

    public boolean shouldContain(String incomingString) {
        if (this.anagramsInTheGroup.isEmpty()) {
            return false;
        }
        String existingString = this.anagramsInTheGroup.getFirst();
        if (incomingString.length() != existingString.length()) {
            return false;
        }
        int[] arr = new int[26];
        for (int i = 0; i < incomingString.length(); i++) {
            arr[incomingString.charAt(i) - 'a']++;
            arr[existingString.charAt(i) - 'a']--;
        }
        return Arrays.stream(arr).allMatch(el -> el == 0);
    }
}
