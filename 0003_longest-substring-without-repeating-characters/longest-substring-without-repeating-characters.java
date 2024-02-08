// package 0003_longest-substring-without-repeating-characters;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Initialize pointers, a HashMap to store the last seen indices of characters,
        // and the result variable
        int left = 0, right = 0, lenn = 0;
        HashMap<Character, Integer> res = new HashMap<>();
        int n = s.length();

        // Iterate through the string
        while (right < n) {
            // Check if the character at the 'right' pointer is already in the substring
            if (res.containsKey(s.charAt(right))) {

                // Move the 'left' pointer to the right of the last occurrence of the current
                // character
                left = Math.max(res.get(s.charAt(right)) + 1, left); // Line to be noticed

                // Update the last seen index of the current character
                res.put(s.charAt(right), right);
            } else {
                // If the character is not in the substring, add it to the HashMap
                res.put(s.charAt(right), right);
            }

            // Update the length of the longest substring
            lenn = Math.max(lenn, (right - left) + 1);

            right++;
        }

        return lenn;
    }
}