class Solution {
    public String convert(String s, int numRows) {
        StringBuilder str[] = new StringBuilder[numRows];
        for (int j = 0; j < numRows; j++) {
            str[j] = new StringBuilder();
        }
        int i = 0, n = s.length();
        while (i < n) {
            int count = 0;
            while (i < n && count < numRows) {
                str[count].append(s.charAt(i));
                i++;
                count++;
            }
            count -= 2;
            while (i < n && count < numRows && count > 0) {
                str[count].append(s.charAt(i));
                i++;
                count--;
            }
        }
        StringBuilder ans = new StringBuilder();
        for (StringBuilder sb : str) {
            ans.append(sb);
        }
        return ans.toString();
    }
}