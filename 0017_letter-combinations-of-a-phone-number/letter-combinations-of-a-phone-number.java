public class Solution {

    public List<String> letterCombinations(String digits) {
        ArrayList<String> s = new ArrayList<>();
        ArrayList<String> res = new ArrayList<>();
        s.add("");
        s.add("");

        if (digits.length() == 0) {
            return res;
        }

        String ss = "";
        int cc = 0;
        int jj = 97;

        for (int i = 1; i < 6; i++) {
            cc = 0;
            ss = "";
            for (; jj <= 122; jj++) {
                if (cc > 2) {
                    break;
                }
                cc++;
                ss += (char) (jj);
            }
            s.add(i, ss);
        }

        s.add(6, "pqrs");
        s.add(7, "tuv");
        s.add(8, "wxyz");
        res.add("");

        for (int i = 0; i < digits.length(); i++) {
            char d = digits.charAt(i);
            int x = Character.getNumericValue(d);

            ArrayList<String> temp = new ArrayList<>();
            for (int j = 0; j < s.get(x - 1).length(); j++) {
                char c = s.get(x - 1).charAt(j);

                for (int k = 0; k < res.size(); k++) {
                    temp.add(res.get(k) + c);
                }
            }

            res = temp;
        }

        return res;
    }
}