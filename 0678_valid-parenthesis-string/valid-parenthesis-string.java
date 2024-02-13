// package 0678_valid-parenthesis-string;

class Solution {
    // public boolean isvalid(String s){

    // }
    public boolean checkValidString(String s) {

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> st = new Stack<>();
        int count = 0;
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {

                st.push(i);
            } else if (s.charAt(i) == '(') {
                stack.push(i);
            }

            else {// toh close hoga toh open ko n pop krdiya
                if (!stack.isEmpty()) {
                    stack.pop();// agr woh empty hai then * ko pop krdiya bcz we can replace with the star
                } else if (!st.isEmpty()) {
                    st.pop();
                } else {
                    return false;// agar dono empty retunr false
                }
            }
        }
        while (!stack.isEmpty()) {// means open mai hai braces but replace ke liye star khtm return false
            if (st.isEmpty()) {
                return false;
            } else if (stack.peek() < st.peek()) {
                stack.pop();
                st.pop();
            } else {
                return false;
            }
        }
        return true;

    }
}
