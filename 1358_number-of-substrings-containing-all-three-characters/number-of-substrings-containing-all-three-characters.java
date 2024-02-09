// package 1358_number-of-substrings-containing-all-three-characters;

class Solution {
    public int numberOfSubstrings(String s) {
        int cnt = 0;

        Map<Character, Integer> map = new HashMap<>();

        int left = 0, right = 0;

        while (right < s.length()) {
            if (!map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), 1);
            } else {
                int freq = map.get(s.charAt(right));
                map.put(s.charAt(right), freq + 1);
            }

            // Here if map size is 3 means we have required
            // substring with characters a,b,c then all the substrings
            // afterwards 'right' pointer would also contain
            // these characters so we are updating counter here
            // as s.length()-right

            if (map.size() == 3) {
                cnt += s.length() - right;
            }

            // then one by one remove the characters pointed by left
            // to shift the window
            while (left <= right && map.size() == 3) {
                char ch = s.charAt(left);
                int val = map.get(ch);
                map.put(ch, val - 1);

                if (map.get(ch) == 0)
                    map.remove(ch);

                left++;

                // still if after moving the left pointer we have
                // 3 characters in map then update the counter
                // as counter += s.length()-right

                // why counter+= s.length()-right ?
                // because right is the pointer where a valid substring
                // has been formed containing three chars
                // so after right pointer all the substrings
                // would also contain these three chars.
                // that's the reason we are updating like s.length()-right

                if (map.size() == 3) {
                    cnt += s.length() - right;
                }
            }
            right++;
        }

        return cnt;
    }
}