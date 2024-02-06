class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return "0";
        }

        Stack<Character> q = new Stack<>();
        q.push(num.charAt(0));
        for (int i = 1; i < num.length(); i++) {
            while (!q.isEmpty() && q.peek() > num.charAt(i) && k != 0) {
                q.pop();
                k--;
            }
            q.push(num.charAt(i));
        }

        Stack<Character> q2 = new Stack<>();
        while (!q.isEmpty()) {
            while (k != 0) {
                q.pop();
                k--;
            }
            q2.push(q.pop());
        }
        while (q2.size() != 1 && q2.peek() == '0') {
            q2.pop();
        }

        StringBuilder sb = new StringBuilder("");

        while (!q2.isEmpty()) {
            sb.append(q2.pop());
        }
        return sb.toString();
    }
}