class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        helper(n,n,builder,res);
        return res;
        
    }


    public void helper(int open, int close, StringBuilder builder, List<String> res) {
        if(open==0 && close==0){
            res.add(builder.toString());
            return;
        }

        String[] brackets = {"(", ")"};
        for(String brcs: brackets){
            if(isValid(brcs, open, close)){
                builder.append(brcs);
                helper(brcs.equals("(") ? open-1:open, brcs.equals(")") ? close-1:close, builder, res);
                builder.deleteCharAt(builder.length()-1);
            }
        }

    }


    public boolean isValid(String brcs, int open, int close){
        if(open>close){
            return false;
        }

        if(brcs.equals("(") && open==0){
            return false;
        }

        if(brcs.equals(")") && (close==0 || open==close)){
            return false;
        }
        return true;
    }



}
